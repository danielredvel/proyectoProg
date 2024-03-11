import java.util.NoSuchElementException;
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
        try {
            this.opcionElegida = Integer.parseInt(in.nextLine());
        }  catch (NumberFormatException nfe) {
        //Si el error ha sido provocado debido a que no se ha introducido un número se indica ese error, excepció: NumberFormatException
        System.out.println("Escribe un número");
    } catch (
    NoSuchElementException nsee) {
        System.out.println("ERROR");
    } catch (Exception e) {
        //recoge cualquier otro error
        System.out.println("Error");
    }

        //No such element exception
        this.opcion(this.opcionElegida);
    }

    @Override
    public void opcion(int opcionElegida) {
        String clave_intro;
        boolean clave_correcta=false;
        Scanner in = new Scanner(System.in);
        switch (opcionElegida) {
            case 1:
                System.out.println("Menu de admin elegido");
                System.out.println("Introduce la clave");

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

                System.out.println("Introduce la clave");

                do {
                    clave_intro = in.nextLine();
                    if (Buscable.buscar_clave(clave_intro, Menu_admin.lista_departamentos)!=null) {
                        clave_correcta=true;
                        menuDepartamento.escribir_menu();
                    } else {
                        System.out.println("Clave no encontrada\nIntroduce la clave:");
                    }
                } while (!clave_correcta);
                menuDepartamento.escribir_menu();

                break;
                case 3:

                    salir=true;
                    System.out.println("Hasta pronto");
                break;

            default:
                System.out.println("Opción no valida");

        }
    }


    public Menu_departamento getMenuDepartamento() {
        return menuDepartamento;
    }
}
