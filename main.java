import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        try {

            String prueba1 = "prueba 1.txt";
            Lector lector = new Lector(prueba1);
            Grafo grafo = new Grafo(lector);
        }catch (StackOverflowError e)
        {
            System.out.println("                                   excediste el uso de memoria                   ");
        }
    }
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
        /*
        1. id del nodo
	    2. nombre del nodo
	    3. cordanada en X
	    4. cordenada en Y
	    5. tipo de nodo
            a. c = cliente
            b. d= deposito
            c. s = estacion
	    6. tipo de estacion
            a. 0 = rapido
            b. 1 = media
            c. 2 = lenta
            */
    Coordenada[] coordenadas; // arreglo de coordanadas instanciadas
    String [] l; // arreglo para estaciones de clientes incluyendo el deposito, //tiempo de carga en horas para cada tipo de estacion y cada punto de soporte
    String [] g; // arreglo para estaciones de carga incluyendo el deposito, //nivel de bateria en watts hora para cada tipo de estacion y para cada punto de soporte
}