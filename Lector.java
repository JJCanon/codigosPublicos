import java.io.*;

public class Lector {


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
    String [] coordinates; // arreglo que contiene las cordenadas de las estaciones
    Coordenada[] coordenadas; // arreglo de coordanadas instanciadas
    String [] l; // arreglo para estaciones de clientes incluyendo el deposito
    String [] g; // arreglo para estaciones de carga incluyendo el deposito
    public Lector(String nombre) throws IOException
    {
        File file = new File(nombre);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea;
        int contador=1;
        int contador2 = 0;
        int contador3=0, contador3_1=0 , contador4=0, contador4_1=0;
        while ((linea=bufferedReader.readLine())!=null)
        {
            switch (contador) {
                case 1:
                    n = Integer.parseInt(linea);
                    break;
                case 2:
                    m = Integer.parseInt(linea);
                    break;
                case 3:
                    u = Integer.parseInt(linea);
                    break;
                case 4:
                    breaks = Integer.parseInt(linea);
                    break;
                case 5:
                    r = Double.parseDouble(linea);
                    break;
                case 6:
                    speed = Double.parseDouble(linea);
                    break;
                case 7:
                    Tmax = Double.parseDouble(linea);
                    break;
                case 8:
                    Smax = Double.parseDouble(linea);
                    break;
                case 9:
                    st_customer = Double.parseDouble(linea);
                    break;
                case 10:
                    Q = Double.parseDouble(linea);
                    break;
                case 11:
                    coordinates = new String[n];
                    coordenadas = new Coordenada[n];
                    break;
                case 12:
                    if (contador2 < n) {
                        coordinates[contador2] = linea;
                        coordenadas[contador2]= new Coordenada(linea);
                        contador2++;
                        if (contador2!=n)
                        {
                            contador--;
                        }
                    }else contador++;
                    break;
                case 13:
                    for(Coordenada a: coordenadas )
                    {
                        if(a.tipoDeNodo.equals("c")||a.tipoDeNodo.equals("d"))
                            contador3++;
                        if (a.tipoDeNodo.equals("s")||a.tipoDeNodo.equals("d"))
                            contador4++;
                    }
                    l=new String[contador3];
                    break;
                case 14:
                    if(contador3_1 < contador3)
                    {
                        l[contador3_1]=linea;
                        contador3_1++;
                        if(contador3_1!=contador3)
                        {
                            contador--;
                        }
                    }break;
                case 15:
                    g=new String[contador4];
                    break;
                case 16:
                    if(contador4_1<contador4)
                    {
                        g[contador4_1] = linea;
                        contador4_1++;
                        if(contador4_1 != contador4)
                        {
                            contador--;
                        }
                    }
                    break;
                default: System.out.println("recopilacion de datos completada");
            }
            contador++;
        }
        System.out.println("recopilacion de datos completada");
    }
}
