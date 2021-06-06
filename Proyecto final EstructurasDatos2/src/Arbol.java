import java.util.ArrayList;

public class Arbol {
    Nodo padre;
    ArrayList<Nodo> nodoHijos;
    ArrayList<Nodo>recorridos;
    double r, speed, tMax, sMax, st_customer,Q;
    String[] l;
    String[] g;
    ArrayList <Double> distancias, costoKilometros, costoWatts;
    double total;
    ArrayList <Arbol> Hijos = new ArrayList<>();
    int totalHijos;
    ArrayList<Double>resultados= new ArrayList<>();

    public Arbol(Nodo padre, ArrayList<Nodo> nodoHijos, ArrayList<Nodo> recorridos, double r, double speed, double tMax, double sMax, double st_customer, double Q, String [] l, String [] g)
    {
        //System.out.println("parada en la estacion: "+ padre.coordenada.nombreDelNodo);
        this.padre = padre;
        this.nodoHijos = nodoHijos;
        this.recorridos=recorridos;
        this.r = r;
        this.speed = speed;
        this.tMax = tMax;
        this.sMax = sMax;
        this. st_customer = st_customer;
        this.Q=Q;
        this.l = l;
        this.g = g;
        this.recorridos.add(padre);
        calculos();
        /*if(nodoHijos.size()>0)
        {
            System.out.println("tienes "+nodoHijos.size()+" hijos");
            //eliminarHijo();
        }
        //System.out.println(recorridos.size()+"  "+nodoHijos.size());
        //System.out.println(nodoHijos.size());*/
        if(nodoHijos.size()>0)
        {
            for(int i = 0; i<nodoHijos.size();i++)
            {
                Nodo hijo = nodoHijos.get(i);
                nodoHijos.remove(i);
                hijo(hijo);
                nodoHijos.add(i,hijo);
                //nodoHijos=devolverhijo(nodoHijos,hijo,i);
            }
        }
    }


    public void hijo(Nodo hijo)
    {
        Arbol rama = new Arbol(hijo,nodoHijos,recorridos,r,speed,tMax,sMax,st_customer,Q,l,g);
        //System.out.print(rama.padre.coordenada.nombreDelNodo+" "+nodoHijos.size()+" -");
        Hijos.add(rama);
        //System.out.println(Hijos.size());
    }

    public void calculos()
    {
        distancias();
        //System.out.println();
        costosKilometro();
       // System.out.println();
        costoWatts();
        //System.out.println();
    }

    public void distancias()
    {
        distancias = new ArrayList<>();
        for(int i = 0; i<nodoHijos.size();i++)
        {
            double DX = (nodoHijos.get(i).coordenada.coordenada_X - padre.coordenada.coordenada_X),DY =(nodoHijos.get(i).coordenada.coordenada_Y - padre.coordenada.coordenada_Y);
            double distancia = (Math.sqrt(Math.pow(DX, 2) + Math.pow(DX, 2)));
            distancias.add(distancia);
            //System.out.println("distancia de " + padre.coordenada.nombreDelNodo + " a " + nodoHijos.get(i).coordenada.nombreDelNodo + " es de " + distancia+ " KM");
        }
    }

    public void costosKilometro()
    {
        costoKilometros = new ArrayList<>();
        for(int i = 0; i<nodoHijos.size();i++)
        {
            double costo = (distancias.get(i)/speed);
            costoKilometros.add(costo);
            //System.out.println("el costo a la estación " + nodoHijos.get(i).coordenada.nombreDelNodo+" es de "+ costoKilometros.get(i) + " KM/H");
        }
    }

    public void costoWatts()
    {
        costoWatts=new ArrayList<>();
        for(int i  = 0; i<nodoHijos.size();i++)
        {
            double costoWatt = costoKilometros.get(i)*r;
            costoWatts.add(costoWatt);
            //System.out.println("el costo a la estación " + nodoHijos.get(i).coordenada.nombreDelNodo+" es de "+(Q-costoWatts.get(i))+ " Watts/H");
        }

    }

    public ArrayList<Nodo> devolverhijo(ArrayList<Nodo> nodoHijoss,Nodo hijo, int posHijo)
    {
        ArrayList <Nodo> arrayList = new ArrayList<>();
        for(int i=0;i<nodoHijoss.size();i++)
        {
            if(i==posHijo){
                arrayList.add(hijo);
            }
            arrayList.add(nodoHijoss.get(i));
        }
        System.out.println(nodoHijoss.size()+" "+ arrayList.size());
        return  arrayList;
    }
}
