public class Main {

    public static void main(String[] args) {
        Menu_inicio menuInicio =new Menu_inicio("menu"); //"menu" es la contraseña para el menú de Administrador

        do {
            Menu_inicio.salir=false;
        try {
            menuInicio.escribir_menu();
        } catch (NumberFormatException nfe){
            System.out.println("Indica un número");
        } catch (Exception e){
            System.out.println("Error");
        }
        } while (!Menu_inicio.salir);
    }
}
