import java.util.ArrayList;

public interface Añadible {
    static void añadir(Object objeto_añadido, ArrayList lista){
        lista.add(objeto_añadido);
    }

}
