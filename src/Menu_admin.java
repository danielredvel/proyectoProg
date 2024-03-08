import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu_admin implements Menu, Añadible, Listable, Buscable {
    int opcionElegida;
    public int marca =0;
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
                //NoSuchElementException en el nextLine
                this.opcion(this.opcionElegida);
                //Si Integer.parseint no ha producido error, error=false;
                error = false;
            } catch (NumberFormatException nfe) {
                //Si el error ha sido provocado debido a que no se ha introducido un número se indica ese error, excepció: NumberFormatException
                System.out.println("Escribe un número");
            } catch (NoSuchElementException nsee){
                System.out.println("ERROR");
            }
            catch (Exception e) {
                //recoge cualquier otro error
                System.out.println("Error");
            }
        } while (opcionElegida!=8);

        in.close();
    }


    @Override
    public void opcion(int opcionElegida) {
        Scanner in = new Scanner(System.in);

        String nombre="";
        String clave="";
        Object o;
        boolean salir=false;


        if (opcionElegida==1) {
            if (marca > 0) {
                Listable.listar(lista_departamentos);
            } else System.out.println("No hay departamentos");
        } else if (opcionElegida==2) {
            System.out.println("Nombre del Departamento:");
            nombre = in.nextLine();
            System.out.println("Clave del Departamento:");
            clave = in.nextLine();
            Departamento d = new Departamento(nombre, clave);
            Añadible.añadir(d, lista_departamentos);
            this.marca++;   
        } else if (opcionElegida==3) {
            if (marca>0) {
                System.out.println("Clave del Departamento a retirar");
                clave = in.nextLine();
                o = Buscable.buscar_clave(clave, lista_departamentos);
                Eliminable.eliminar(o, lista_departamentos);
                this.marca--;
            } else System.out.println("No hay departamentos");   
        } else if (opcionElegida==4) {
            Listable.listar(lista_salas);
        } else if (opcionElegida==5) {
            System.out.println("Nombre de la Sala:");
            nombre = in.nextLine();
            System.out.println("Clave de la Sala:");
            clave = in.nextLine();
            Departamento s = new Departamento(nombre, clave);
            Añadible.añadir(s, lista_salas);
        } else if (opcionElegida ==6) {
            System.out.println("Clave de la Sala a retirar");
            clave = in.nextLine();
            o = Buscable.buscar_clave(clave, lista_salas);
            Eliminable.eliminar(o, lista_salas);
        } else if (opcionElegida==7) {
            Listable.listar(Menu_inicio.menuDepartamento.getLista_reservas());

        } else if (opcionElegida==8) {
            salir=true;
        } else System.out.println("Opción no valida");

        in.close();
    }
}
