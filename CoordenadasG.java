
public class CoordenadasG {
    Coordenada padre;
    CoordenadasG[] estaciones;
    Coordenada[] hijos;
    boolean recorridos[];
    double r,speed, tMax, sMax, st_customer,Q;
    String[]l;
    String[]g;
    double[] distancias;
    double[] costosKilometro;

    public CoordenadasG(Coordenada padre,Coordenada [] hijos,boolean[] recorridos,double r, double speed, double tMax, double sMax,double st_customer,double Q, String [] l, String [] g){
        this.padre=padre;
        //System.out.println(this.padre.nombreDelNodo);
        System.out.println();
        this.hijos=hijos;
        this.recorridos=recorridos;
        this.r = r;
        this.speed = speed;
        this.tMax = tMax;
        this.sMax = sMax;
        this. st_customer = st_customer;
        this.Q=Q;
        this.l = l;
        this.g = g;
        recorridos();
        //System.out.println(this.recorridos.length);
        for (int i = 0; i<this.recorridos.length;i++) {
            boolean a = this.recorridos[i];
            System.out.println(a);
    }
        distancias();
        //borrarHijo();
        this.estaciones=new CoordenadasG[this.hijos.length];
        System.out.println();
        if(this.hijos.length>1)
        {
            for(int i = 0;i<estaciones.length;i++)
            {
                if(recorridos[i]==true) continue;
                else {
                   System.out.println(i);
                    hijo(i, hijos[i]);
                }
            }
        }
    }

    public void distancias()
    {
       double distancias[] = new double[hijos.length];
       System.out.println(hijos.length);
       for(int i = 0;i<distancias.length;i++)
       {
           //System.out.println(hijos[i].nombreDelNodo);
           double DX=(hijos[i].coordenada_X-padre.coordenada_X),DY=(hijos[i].coordenada_Y-padre.coordenada_Y), distancia=(Math.sqrt(Math.pow(DX,2)+Math.pow(DY,2)));
           //System.out.println(distancia);
           distancias[i]=distancia;
       }
       this.distancias=distancias;
       costoKilometro(distancias);
    }

    public void costoKilometro(double[] distancias)
    {
        double costosKilometro[] = new double[hijos.length];
        for(int i = 0; i<costosKilometro.length;i++)
        {
            costosKilometro[i]=(distancias[i]/speed);
            //System.out.println(costosKilometro[i]);
        }
        this.costosKilometro=costosKilometro;
        costoWatts(costosKilometro);
    }

    public void costoWatts(double[] costosKilometro)
    {
        double [] costoWatts = new double[hijos.length];
        for(int i = 0; i<costoWatts.length;i++)
        {
            costoWatts[i]= costosKilometro[i]*r;
            //System.out.println(Q-(costoWatts[i]));
        }
    }

    public void recorridos()
    {
        for (int i = 0; i < recorridos.length; i++)
        {
            if(hijos[i]== padre)
            {
                recorridos[i]=true;
            }
        }
    }


    public void hijo(int i, Coordenada coordenada)
    {
        estaciones[i]=new CoordenadasG(coordenada,hijos,recorridos,r,speed,tMax,sMax,st_customer,Q,l,g);
    }

    public void borrarHijo()
    {
        boolean nuevosrecorridos[] = new boolean[recorridos.length-1];
        Coordenada[] nuevoshijos= new Coordenada[hijos.length-1];
        int count = 0;
        for(int i = 0;i<nuevosrecorridos.length+1;i++)
        {
            if(recorridos[i]==true)
            {
                continue;
            }else {
                nuevoshijos[count]=hijos[i];
                nuevosrecorridos[count]=recorridos[i];
                count++;
            }
        }
        System.out.println(recorridos.length +" "+ hijos.length);
        recorridos=nuevosrecorridos;
        hijos=nuevoshijos;
    }
}

















/*public Coordenada[] borrarHijo(Coordenada coordenada)
    {
        Coordenada[] nuevoHijo = new Coordenada[hijos.length-1];
        int count = 0;
        for(int i = 0; i< hijos.length;i++)
        {
            if(hijos[i]==coordenada)
            {
                continue;
            }else{
                nuevoHijo[count]=hijos[i];
                count++;
            }
        }
        return nuevoHijo;
    }*/