import java.sql.SQLOutput;
import java.util.Scanner;


public class menu_inicio implements menu {
    public static menu_departamento menuDepartamento;
    public static menu_admin menuAdmin;
    private int opcionElegida=0;
    private String clave;
    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.print("""
                1) Menú admin
                2) Menú departamento
                """);
        this.opcionElegida = Integer.parseInt(in.nextLine());
        this.opcion(this.opcionElegida);
        in.close();
    }

    @Override
    public void opcion(int opcionElegida) {
        Scanner in = new Scanner(System.in);
        switch (opcionElegida) {
            case 1:
                System.out.println("Menu de admin elegido");
                System.out.println("Dime la clave");
                this.clave = in.nextLine();
                menuAdmin = new menu_admin(clave);
                menuAdmin.escribir_menu();
                break;

            case 2:
                System.out.println("Menu de departamento elegido");
                menuDepartamento = new menu_departamento();
                menuDepartamento.escribir_menu();

                break;

            default:
                System.out.println("Opción no valida");

        }
    }

    public menu_departamento getMenuDepartamento() {
        return menuDepartamento;
    }
}
