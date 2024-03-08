public class Main {

    public static void main(String[] args) {
        Menu_inicio menuInicio =new Menu_inicio();
        try {
            menuInicio.escribir_menu();
        } catch (NumberFormatException nfe){
            System.out.println("Indica un número");
        } catch (Exception e){
            System.out.println("Error");
        }

    }
}
