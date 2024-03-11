import java.util.ArrayList;

public interface Buscable {
    static Object buscar_objeto(Object objeto_a_buscar, ArrayList lista) {
        Object objeto_encontrado=null;
        if (objeto_a_buscar instanceof Departamento){
            for (Object o : lista){
                if (((Departamento)objeto_a_buscar).getNombre().equalsIgnoreCase(((Departamento)o).getNombre())
                &&((Departamento)objeto_a_buscar).getClave().equalsIgnoreCase(((Departamento)o).getClave())){
                    objeto_encontrado=o;
                }
            }
        } else if (objeto_a_buscar instanceof Sala) {
            for (Object o : lista){
                if (((Sala)objeto_a_buscar).getNombre().equalsIgnoreCase(((Sala)o).getNombre())
                        &&((Sala)objeto_a_buscar).getClave().equalsIgnoreCase(((Sala)o).getClave())){
                    objeto_encontrado=o;
                }
            }
        }
        return objeto_encontrado;
    }
    static Object buscar_clave(String clave, ArrayList lista) {
        Object objeto_encontrado=null;
        for (Object o : lista) {
            if (((Departamento)o).getClave().equalsIgnoreCase(clave)){
                objeto_encontrado=o;
            }
        }
        return objeto_encontrado;
    }
    static Object buscar_nombre(String nombre, ArrayList lista) {
        Object objeto_encontrado=null;
        for (Object o : lista) {
            if (((Departamento)o).getNombre().equalsIgnoreCase(nombre)){
                objeto_encontrado=o;
            }
        }
        return objeto_encontrado;
    }

}
