import java.util.Objects;
import java.util.Scanner;


public class Menu_inicio implements Menu {
    public static Menu_departamento menuDepartamento;
    public static Menu_admin menuAdmin;
    private int opcionElegida=0;
    private String clave;
    public static boolean salir=false;
    public  Menu_inicio(String clave){
        this.clave=clave;
        menuAdmin=new Menu_admin(clave);
    }
    @Override
    public void escribir_menu() {
        Scanner in = new Scanner(System.in);
        System.out.print("""
                1) Menú admin
                2) Menú Departamento
                3) Salir
                """);
        //this.opcionElegida = Integer.parseInt(in.nextLine());
        this.opcionElegida = in.hasNextLine() ? Integer.parseInt(in.nextLine()) : 15;

        //No such element exception
        this.opcion(this.opcionElegida);
        in.close();
    }

    @Override
    public void opcion(int opcionElegida) {
        Scanner in = new Scanner(System.in);
        switch (opcionElegida) {
            case 1:
                System.out.println("Menu de admin elegido");
                System.out.println("Introduce la clave");
                String clave_intro;
                boolean clave_correcta=false;
                do {
                    clave_intro = in.nextLine();
                    if (Objects.equals(this.clave, clave_intro)) {
                        clave_correcta=true;
                        menuAdmin.escribir_menu();
                    } else {
                        System.out.println("Clave inconrrecta\nIntroduce la clave:");
                    }
                } while (!clave_correcta);
                break;

            case 2:
                System.out.println("Menu de Departamento elegido");
                menuDepartamento = new Menu_departamento();
                menuDepartamento.escribir_menu();

                break;
                case 3:
                    System.out.println("Hasta pronto");
                    salir=true;
                break;
            case 15:
                //Sentencia de control del scanner
                break;

            default:
                System.out.println("Opción no valida");

        }
    }


    public Menu_departamento getMenuDepartamento() {
        return menuDepartamento;
    }
}
