import java.util.ArrayList;

public interface buscable {
    static Object buscar_objeto(Object objeto_a_buscar, ArrayList lista) {
        Object objeto_encontrado=null;
        for (Object o : lista) {
            if (objeto_a_buscar.equals(lista)) {
                 objeto_encontrado = o;
            } else {
                if (o instanceof departamento) {
                    System.out.println("Departamento no encontrado");
                }
                else if (o instanceof sala) {
                    System.out.println("Sala no encontrada");
                }
            }
        }
        return objeto_encontrado;
    }
    static Object buscar_clave(String clave, ArrayList lista) {
        Object objeto_encontrado=null;
        for (Object o : lista) {
            if (((departamento)o).getClave().equalsIgnoreCase(clave)){
                objeto_encontrado=o;
            } else System.out.println("Clave no encontrada");
        }
        return objeto_encontrado;
    }
    static Object buscar_nombre(String nombre, ArrayList lista) {
        Object objeto_encontrado=null;
        for (Object o : lista) {
            if (((departamento)o).getNombre().equalsIgnoreCase(nombre)){
                objeto_encontrado=o;
            } else System.out.println("Nombre no encontrado");
        }
        return objeto_encontrado;
    }

}
