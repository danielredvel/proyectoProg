import java.util.ArrayList;

public interface Eliminable {
    static void eliminar(Object objeto_retirado, ArrayList lista){
    lista.remove(objeto_retirado);
    }


}
