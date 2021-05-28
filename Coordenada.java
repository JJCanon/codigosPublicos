import java.util.Scanner;

public class Coordenada {

    int idDeNodo, tipoDeEstacion;
    String nombreDelNodo, tipoDeNodo;
    double coordenada_X, coordenada_Y;
    public Coordenada(String coordenada)
    {
        Scanner scanner = new Scanner(coordenada);
        idDeNodo= Integer.parseInt(scanner.next());
        nombreDelNodo= scanner.next();
        coordenada_X = Double.parseDouble(scanner.next());
        coordenada_Y = Double.parseDouble(scanner.next());
        tipoDeNodo = scanner.next();
        tipoDeEstacion = Integer.parseInt(scanner.next());

        //System.out.println(idDeNodo + " " +nombreDelNodo+" "+coordenada_X+" "+coordenada_Y+" "+tipoDeNodo+" "+tipoDeEstacion);
    }
}
