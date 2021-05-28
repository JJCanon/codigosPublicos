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
        recorrer();
    }


    public void recorrer()
    {
        boolean [] recorridos = new boolean[coordenadas.length];
        for(int i =  0; i<recorridos.length;i++)
        {
            recorridos[i]=false;
        }
        CoordenadasG coordenadasG = new CoordenadasG(coordenadas[0],coordenadas,recorridos,r,speed,Tmax,Smax,st_customer,Q, l, g);
    }
}
