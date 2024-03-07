import java.util.ArrayList;
import java.util.Scanner;

public class Menu_admin implements Menu, Añadible, Listable, Buscable {
    int opcionElegida;
    String clave;
    static ArrayList lista_departamentos;
    static ArrayList lista_salas;
    public Menu_admin(String clave){
        /*
         * El constructor crea una lista para los departamentos y una lista para las salas
         * Se le  indica una clave de acceso
         */
        this.opcionElegida=0;
        lista_departamentos = new ArrayList();
        lista_salas = new ArrayList();
        this.clave=clave;
    }
    @Override
    public void escribir_menu(){
        Scanner in = new Scanner(System.in);
        //Error es un centinela que repite el menú hasta que la opción sea valida
        boolean error=true;
        do {
        System.out.print("""
                1) Listar Departamento
                2) Añadir Departamento
                3) Eliminar Departamento
                4) Listar Sala
                5) Añadir Sala
                6) Eliminar Sala
                7) Listar todas las reservas
                8) Cerrar sesión
                """);
       try {
           this.opcionElegida = Integer.parseInt(in.nextLine());
           this.opcion(this.opcionElegida);
           //Si Integer.parseint no ha producido error, error=false;
           error=false;
       } catch (NumberFormatException nfe){
           //Si el error ha sido provocado debido a que no se ha introducido un número se indica ese error, excepció: NumberFormatException
           System.out.println("Escribe un número");
       } catch (Exception e){
           //recoge cualquier otro error
           System.out.println("Error");
       }
        }while (error);
        in.close();
    }


    @Override
    public void opcion(int opcionElegida) {
        Scanner in = new Scanner(System.in);

        String nombre="";
        String clave="";
        Object o;
        boolean salir=false;

        do {
        switch (opcionElegida) {
            case 1:
                Listable.listar(lista_departamentos);
                break;

            case 2:
                System.out.println("Nombre del Departamento:");
                nombre = in.nextLine();
                System.out.println("Clave del Departamento:");
                clave = in.nextLine();
                Departamento d = new Departamento(nombre, clave);
                Añadible.añadir(d, lista_departamentos);
                break;

            case 3:
                System.out.println("Clave del Departamento a retirar");
                clave = in.nextLine();
                o = Buscable.buscar_clave(clave, lista_departamentos);
                Eliminable.eliminar(o, lista_departamentos);
                break;

            case 4:
                Listable.listar(lista_salas);
                break;

            case 5:
                System.out.println("Nombre de la Sala:");
                nombre = in.nextLine();
                System.out.println("Clave de la Sala:");
                clave = in.nextLine();
                Departamento s = new Departamento(nombre, clave);
                Añadible.añadir(s, lista_salas);
                break;

            case 6:
                System.out.println("Clave de la Sala a retirar");
                clave = in.nextLine();
                o = Buscable.buscar_clave(clave, lista_salas);
                Eliminable.eliminar(o, lista_salas);

                break;

            case 7:
                Listable.listar(Menu_inicio.menuDepartamento.getLista_reservas());
                break;

            case 8:
                salir=true;
                break;

            default:
                System.out.println("Opción no valida");
        }
        }while (!salir);

        in.close();
    }
}
