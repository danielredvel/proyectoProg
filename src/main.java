import java.util.Scanner;

public class main {
    static String clave;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        menu_admin menuAdmin = new menu_admin(clave);
        menuAdmin.escribir_menu();

        in.close();
    }
}
