import java.util.ArrayList;
import java.util.Scanner;

public class menu_admin implements menu {
    int opcionElegida;
    String clave;
    ArrayList lista_departamentos;
    public menu_admin(String clave){
        this.opcionElegida=0;
        this.lista_departamentos = new ArrayList();
        this.clave=clave;
    }
    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                1)Listar departamento
                2)Añadir departamento
                3)Eliminar departamento
                4)Listar sala
                5) Añadir sala
                6) Eliminar sala
                7) Listar todas las reservas
                8) Cerrar sesión
                """);
        this.opcionElegida=Integer.parseInt(in.nextLine());
        this.opcion(this.opcionElegida);
        in.close();
    }


    @Override
    public void opcion(int opcionElegida) {
        switch (opcionElegida){
                case 1:
                listar_departamentos.listar(lista_departamentos);
                break;

                case 2:

                break;

                case 3:

                break;

                case 4:

                break;

                case 5:

                break;

                case 6:

                break;

                case 7:

                break;

                case 8:

                break;

                default:
                System.out.println("Opción no valida");

        }
    }
}
