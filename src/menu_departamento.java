import java.util.Scanner;

public class menu_departamento implements menu {
    int opcionElegida;
    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("""
               1) Añadir reserva
               2) Cancelar reserva
               3) Listartodas las reservas
               4) Cerrar sesión
                """);
        this.opcionElegida= Integer.parseInt(in.nextLine());
        this.opcion(this.opcionElegida);
        in.close();
    }

    @Override
    public void opcion(int opcionElegida) {

    }
}
