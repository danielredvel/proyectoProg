import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Reserva {
    private LocalDateTime f1;
    private String  duracion;
    private String mensaje;
    private String clave;
    private Duration d1;
    DateTimeFormatter f = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy 'a las' kk:mm:ss");

    public Reserva(LocalDateTime f1, String nombre, Duration d1){
        this.f1=f1;
        this.clave =nombre;
        this.d1=d1;
    }
    public Reserva(LocalDateTime f1, String nombre){
        this.f1=f1;
        this.clave =nombre;
    }
public Reserva(){
        boolean sala_existe=false;
        int año=0, mes=0, dia=0, minutos=0, hora=0;
        Scanner in = new Scanner(System.in);


    System.out.println("Dime la fecha y hora");
    //Try y catch
    try {
        System.out.println("Indica el año:");
        año = Integer.parseInt(in.nextLine());

        System.out.println("Indica el mes:");
        mensaje = "mes";
        mes = Integer.parseInt(in.nextLine());

        System.out.println("Indica el dia:");
        mensaje = "dia";
        dia = Integer.parseInt(in.nextLine());

        System.out.println("Indica la hora:");
        mensaje = "hora";
        hora = Integer.parseInt(in.nextLine());

        System.out.println("Indica los minutos:");
        mensaje= "minutos";
        minutos = Integer.parseInt(in.nextLine());

    } catch (NumberFormatException nfe){

            if (Objects.equals(mensaje, "hora")) {
                System.out.println("Error al escribir la " + mensaje);
            } else if ((Objects.equals(mensaje, "minutos"))) {
                System.out.println("Error al escribir los " + mensaje);
            } else {
                System.out.println("Error al escribir el " + mensaje);
            }
    }
     this.f1 = LocalDateTime.of( año,mes,dia, hora,minutos);

    System.out.println("Dime el clave de la Sala que Reserva");
    clave = in.nextLine();
    try {
        Buscable.buscar_nombre(clave, Menu_admin.lista_salas);
        sala_existe=true;
    } catch (NullPointerException npe) {
        System.out.println("Esa sala no existe");
    }
    if (!sala_existe) {
        System.out.println("Dime el tiempo que reservas");
        this.duracion = in.nextLine();
        Duration d1 = Duration.parse(duracion);

    }

}
    public LocalDateTime getf1(){
        return f1;
    }

    public String getnombre() {
        return clave;
    }
    public Duration getd1(){
        return d1;
    }
    public String toString(){
        String escribir="";
        escribir+="Clave: "+this.clave +", fecha: "+this.f1.format(f);
        return escribir;
    }
}

