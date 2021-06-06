import java.util.ArrayList;

public class Calculos2 {
    ArrayList <double[]> Distancias;
    ArrayList <double[]> CostoWatts;
    ArrayList <double[]> Tiempo;
    ArrayList <Nodo[]> Rutas;

    Nodo[] rutamasCorta,rutaMenorCosto,rutamenorTiempo;
    double[] tiempos;
    public Calculos2()
    {
        Distancias=new ArrayList<>();
        CostoWatts=new ArrayList<>();
        Tiempo=new ArrayList<>();
        Rutas = new ArrayList<>();
    }

    public void guardarArrayListD( double[] distancias)
    {
        Distancias.add(distancias);
    }

    public void guardarArrayListC( double[] CostoWats)
    {
        CostoWatts.add(CostoWats);
    }

    public void guardarArrayListT( double[] tiempo)
    {
        Tiempo.add(tiempo);
    }

    public  void guardarArrayListR(Nodo[] rutas)
    {
        Rutas.add(rutas);
    }

    public void rutas_disponibles()
    {
        //System.out.println(Rutas.size()+" "+ CostoWatts.size()+" "+Tiempo.size()+" "+Distancias.size());
        for(int i = 0; i< Rutas.size()-1||i<CostoWatts.size()-1||i<Tiempo.size()-1||i<Distancias.size()-1;i++)
        {
            Nodo[] nodos1 = Rutas.get(i);
            double[] distancias1 = Distancias.get(i);
            double[] tiempos1 = Tiempo.get(i);
            double[] costoWatss1= CostoWatts.get(i);
            Nodo[] nodos2 = Rutas.get(i+1);
            double[] distancias2 = Distancias.get(i+1);
            double[] tiempos2 = Tiempo.get(i+1);
            double[] costoWatss2= CostoWatts.get(i+1);
            double distancia1=0;
            double distancia2=0;
            double tiempo1=0;
            double tiempo2=0;
            double costoWatts1=0;
            double costoWatts2=0;
            //System.out.println();
            for(int j = 0;j<tiempos1.length;j++) {
                tiempo1+=tiempos1[j];
                tiempo2+=tiempos2[j];
                //System.out.print(tiempos1[j]+" ");
            }
            if(tiempo1<=tiempo2)
            {
                rutamenorTiempo = nodos1;
                tiempos= tiempos1;
            }
            else {
                rutamenorTiempo=nodos2;
                tiempos = tiempos2;
            }
            /*System.out.println(tiempo1 +" "+tiempo2);
            System.out.println();*/
            for(int j = 0;j<distancias1.length;j++) {
                distancia1+=distancias1[j];
                distancia2+=distancias2[j];
                //System.out.print(distancias1[j]+" ");
            }
            if(distancia1<=distancia2) rutamasCorta=nodos1;
            else rutamasCorta=nodos2;
            /*System.out.println(distancia1 +" "+distancia2);
            System.out.println();*/
            for(int j = 0;j<costoWatss1.length;j++) {
                costoWatts1+=costoWatss1[j];
                costoWatts2+=costoWatss2[j];
                //System.out.print(costoWatss1[j]+" ");
            }
            if(costoWatts1<=costoWatts2) rutaMenorCosto=nodos1;
            else rutaMenorCosto=nodos2;
            //System.out.println((16000.0-costoWatts1)+" "+(16000.0-costoWatts2));
            /*System.out.println(costoWatts1 +" "+costoWatts2);
            System.out.println();
            System.out.println();*/
            distancia1=0;
            distancia2=0;
            tiempo1=0;
            tiempo2=0;
            costoWatts1=0;
            costoWatts2=0;
        }
    }
}
