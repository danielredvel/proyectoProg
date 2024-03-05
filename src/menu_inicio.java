import java.util.Scanner;

public class menu_inicio implements menu {
    int opcionElegida=0;

    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                1) Menú admin
                2) Menú departamento
                """);
        this.opcionElegida = Integer.parseInt(in.nextLine());
        this.opcion(this.opcionElegida);
        in.close();
    }

    @Override
    public void opcion(int opcionElegida) {
        switch (opcionElegida) {
            case 1:

                break;

            case 2:

                break;

            default:
                System.out.println("Opción no valida");

        }
    }
}
