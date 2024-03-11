import java.util.ArrayList;
import java.util.Iterator;

public interface Listable {
    static void listar(ArrayList lista) {
        Iterator indice_lista = lista.iterator();
        if (lista.isEmpty()) {
            System.out.println("Lista vacía");
        } else {
            for (Object o2 : lista) {
                if (indice_lista.hasNext()) {
                    System.out.println(o2.toString() + "\n");
                } else {
                    System.out.println();
                }

            }
        }
    }
}
