public class Nodo {
    Nodo[] hijos;
    Coordenada coordenada;
    int cont;
    public Nodo(Coordenada coordenada, int i)
    {
        this.coordenada=coordenada;
        hijos= new Nodo[i];
        cont = 0;
    }
}
