import java.util.ArrayList;
import java.util.Iterator;

public interface listable {
    static void listar(ArrayList lista){
        Iterator indice_lista = lista.iterator();
        for (Object o2:lista) {
            if (lista.isEmpty()) {
                System.out.println("Lista vacía");
            } else if (indice_lista.hasNext()) {
                System.out.println(o2+"\n");
        } else {
                System.out.println();
            }

        }
    }
}
