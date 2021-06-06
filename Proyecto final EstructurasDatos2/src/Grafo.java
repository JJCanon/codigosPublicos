import java.util.ArrayList;

public class Grafo {

    // variables
    int n; //Total de nodos
    int m; //Total de clientes
    int u; // número de estaciones de carga
    int breaks; //numero de puntos de soporte de la funcion de la carga de bateria
    double r; //Tasa de consumo en watts hora por kilometro
    double speed; //velocidad en kilometros por hora
    double Tmax; //tiempo maximo de duracion de la ruta de un vehiculo en horas
    double Smax; //tiempo maximo de carga en horas en la estacion mas lenta
    double st_customer; //tiempo en horas que se demora visitando un cliente
    double Q; //Capacidad de la bateria en watts hora
    String [] coordinates;
    /*1. id del nodo  2. nombre del nodo  3. cordanada en X  4. cordenada en Y  5. tipo de nodo     6. tipo de estacion
                                                                                a. c = cliente      a. 0 = rapido
                                                                                b. d= deposito      b. 1 = media
                                                                                c. s = estacion     c. 2 = lenta*/
    Coordenada[] coordenadas; // arreglo de coordanadas instanciadas
    String [] l; // arreglo para estaciones de clientes incluyendo el deposito
    String [] g; // arreglo para estaciones de carga incluyendo el deposito
    Nodo[] nodos;
    ArrayList <Double> Distancias = new ArrayList<>();
    ArrayList <Double> CostoWatts = new ArrayList<>();
    ArrayList <Double> Tiempo = new ArrayList<>();
    ArrayList <Nodo> rutas = new ArrayList<>();
    Calculos2 calculos2=new Calculos2();
    public Grafo(Lector lector)
    {

        n=lector.n;
        m=lector.m;
        u=lector.u;
        breaks=lector.breaks;
        r = lector.r;
        speed=lector.speed;
        Tmax=lector.Tmax;
        Smax=lector.Smax;
        st_customer=lector.st_customer;
        Q=lector.Q;
        coordinates=lector.coordinates;
        coordenadas=lector.coordenadas;
        l=lector.l;
        g=lector.g;
        nodos=lector.nodos;
        arbol();

    }

    public void arbol()
    {
        //boolean[] recorridos = recorrer();
        //double[] totalDistancias = new double[recorridos.length];
        ArrayList<Nodo> nodoHijos= new ArrayList<>();
        for(Nodo a : nodos)
        {
            nodoHijos.add(a);
        }
        ArrayList<Nodo> recorrido= new ArrayList<>();
        Nodo padre = nodos[0];
        nodoHijos.remove(0);
        Arbol arbol = new Arbol(padre, nodoHijos, recorrido,r,speed,Tmax,Smax,st_customer,Q,l,g);
        for (Nodo hijo: arbol.nodoHijos)
        {
            System.out.print(hijo.coordenada.nombreDelNodo+" ");
        }
        System.out.println();
        System.out.println("el arbol ha sido creado\n");
        double distancia = 0;
        double costoWatts= 0;
        double tiempo = 0;
        ArrayList<String> ruta= new ArrayList<>();
        recorrer_Arbol(arbol);
        System.out.println("arbol recorrido");
        calculos2.rutas_disponibles();
        System. out.print("la ruta mas corta es: ");
        for (int i = 0; i <calculos2.rutamasCorta.length ; i++) System.out.print(calculos2.rutamasCorta[i].coordenada.nombreDelNodo+" ");
        System.out.println();
        System. out.print("la ruta de menor costo es: ");
        for (int i = 0; i <calculos2.rutaMenorCosto.length ; i++) System.out.print(calculos2.rutaMenorCosto[i].coordenada.nombreDelNodo+" ");
        System.out.println();
        System. out.print("la ruta mas rapida es: ");
        for (int i = 0; i <calculos2.rutamenorTiempo.length ; i++) System.out.print(calculos2.rutamenorTiempo[i].coordenada.nombreDelNodo+" ");
        System.out.println();
        ressultado();
    }

    public void recorrer_Arbol(Arbol arbol)
    {

        /*if(arbol.Hijos.size()<0 || arbol.nodoHijos.size()<0)
        {
         return;
        }else*/ if(arbol.Hijos.size()==0)
        {
            /*System.out.println("recorriendo el nodo "+ arbol.padre.coordenada.nombreDelNodo);
           // System.out.println("estas en una hoja");
            // se envian los arraylist a la clase calculos la cual guerda los datos enviados
            for (int i=0 ; i<calculos.Rutas.size();i++)
            {
                for(int j = 0; j<calculos.Rutas.get(i).size();j++)
                {
                    System.out.print(calculos.Rutas.get(i).get(j).coordenada.nombreDelNodo+" ");
                }
                System.out.println();
            }*/
            rutas.add(arbol.padre);
            ArrayList <Nodo> rutaTemporal = rutas;
            /*ArrayRutas.add(rutaTemporal);
            ArrayDistancias.add(Distancias);
            ArrayCostoWatts.add(CostoWatts);
            ArrayTiempo.add(Tiempo);*/
            double[] doublesD = crearArregloD(Distancias);
            double[] doublesW = crearArregloD(CostoWatts);
            double[] doublesT = crearArregloD(Tiempo);
            Nodo[] nodos = crearArregloN(rutas);
            calculos2.guardarArrayListC(doublesW);
            calculos2.guardarArrayListD(doublesD);
            calculos2.guardarArrayListT(doublesT);
            calculos2.guardarArrayListR(nodos);
            rutas.remove(arbol.padre);
            /*calculos.guardarArrayListR(rutas);
            calculos.guardarArrayListD(Distancias);
            calculos.guardarArrayListC(CostoWatts);
            calculos.guardarArrayListT(Tiempo);*/
            //System.out.println(rutas.size()+" "+Distancias.size()+" "+CostoWatts.size()+" "+Tiempo.size());
            return;
        }
        for(int i = 0; i < arbol.Hijos.size();i++)
        {
            // se hallan los valores correspondientes y se asignan a una variable
            double distancia = arbol.distancias.get(i);
            //String a = arbol.padre.coordenada.nombreDelNodo;
            double costoWatts = arbol.costoWatts.get(i);
            double tiempo = (arbol.distancias.get(i)/speed);
            // se añaden al Arraylist
            Distancias.add(distancia);
            rutas.add(arbol.padre);
            CostoWatts.add(costoWatts);
            Tiempo.add(tiempo);
           // System.out.println("recorriendo el nodo "+ arbol.Hijos.get(i).padre.coordenada.nombreDelNodo);
            recorrer_Arbol(arbol.Hijos.get(i));

            // se eliminan los valores una vez se halla llegado a las hojas
            rutas.remove(arbol.padre);
            Distancias.remove(distancia);
            CostoWatts.remove(costoWatts);
            Tiempo.remove(tiempo);
        }
    }

    public double[] crearArregloD(ArrayList <Double> arrayList)
    {
        double[] arreglo = new double[arrayList.size()];
        for(int i=0;i<arrayList.size();i++)
        {
            double valor = arrayList.get(i);
            arreglo[i]=valor;
        }
        return arreglo;
    }

    public Nodo[] crearArregloN(ArrayList <Nodo> arrayList)
    {
        Nodo[] arreglo = new Nodo[arrayList.size()+1];
        for(int i=0;i<arrayList.size();i++)
        {
            Nodo valor = arrayList.get(i);
            arreglo[i] = valor;
        }
        arreglo[arreglo.length-1]=nodos[0];
        return arreglo;
    }

    public void ressultado()
    {
        System.out.print("[{0,0.00}, ");
        int cont = 1;
        for(int i = 0; i<calculos2.tiempos.length;i++){
            String a = ""+calculos2.tiempos[i];
            a=a.substring(0,a.indexOf(".")+3);
            System.out.print("{"+calculos2.rutamenorTiempo[cont].coordenada.idDeNodo+","+a+"}");
            cont++;
        }
        System.out.print(" {0,0.00}]");
    }
}

/*
 public Nodo[] crearArregloN(ArrayList <Nodo> arrayList)
    {
        Nodo[] arreglo = new Nodo[arrayList.size()-1];
        int cont =0;
        for(int i=0;i<arrayList.size();i++)
        {
            if(i==0)continue;
            else {
                Nodo valor = arrayList.get(i);
                arreglo[cont] = valor;
                cont++;
            }
        }
        return arreglo;
    }

    public double[] crearArregloD(ArrayList <Double> arrayList)
    {
        double[] arreglo = new double[arrayList.size()-1];
        int cont= 0;
        for(int i=0;i<arrayList.size();i++)
        {
            if(i==0)continue;
            else
            {
                double valor = arrayList.get(i);
                arreglo[cont]=valor;
                cont++;
            }
        }
        return arreglo;
    }
 */