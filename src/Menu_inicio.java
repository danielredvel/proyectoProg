import java.util.Scanner;


public class Menu_inicio implements Menu {
    public static Menu_departamento menuDepartamento;
    public static Menu_admin menuAdmin;
    private int opcionElegida=0;
    private String clave;
    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.print("""
                1) Menú admin
                2) Menú Departamento
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
                menuAdmin = new Menu_admin(clave);
                menuAdmin.escribir_menu();
                break;

            case 2:
                System.out.println("Menu de Departamento elegido");
                menuDepartamento = new Menu_departamento();
                menuDepartamento.escribir_menu();

                break;

            default:
                System.out.println("Opción no valida");

        }
    }

    public Menu_departamento getMenuDepartamento() {
        return menuDepartamento;
    }
}
