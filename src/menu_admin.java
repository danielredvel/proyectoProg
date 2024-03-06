import java.util.ArrayList;
import java.util.Scanner;

public class menu_admin implements menu, añadible, listable, buscable{
    int opcionElegida;
    String clave;
    static ArrayList lista_departamentos;
    static ArrayList lista_salas;
    public menu_admin(String clave){
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
                1) Listar departamento
                2) Añadir departamento
                3) Eliminar departamento
                4) Listar sala
                5) Añadir sala
                6) Eliminar sala
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
                listable.listar(lista_departamentos);
                break;

            case 2:
                System.out.println("Nombre del departamento:");
                nombre = in.nextLine();
                System.out.println("Clave del departamento:");
                clave = in.nextLine();
                departamento d = new departamento(nombre, clave);
                añadible.añadir(d, lista_departamentos);
                break;

            case 3:
                System.out.println("Clave del departamento a retirar");
                clave = in.nextLine();
                o = buscable.buscar_clave(clave, lista_departamentos);
                eliminable.eliminar(o, lista_departamentos);
                break;

            case 4:
                listable.listar(lista_salas);
                break;

            case 5:
                System.out.println("Nombre de la sala:");
                nombre = in.nextLine();
                System.out.println("Clave de la sala:");
                clave = in.nextLine();
                departamento s = new departamento(nombre, clave);
                añadible.añadir(s, lista_salas);
                break;

            case 6:
                System.out.println("Clave de la sala a retirar");
                clave = in.nextLine();
                o = buscable.buscar_clave(clave, lista_salas);
                eliminable.eliminar(o, lista_salas);

                break;

            case 7:
                listable.listar(menu_inicio.menuDepartamento.getLista_reservas());
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
