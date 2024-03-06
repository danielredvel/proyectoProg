import java.util.ArrayList;
import java.util.Scanner;
public interface eliminable {
    static void eliminar(Object objeto_retirado, ArrayList lista){
    lista.remove(objeto_retirado);
    }

}
