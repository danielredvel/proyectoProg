import java.time.LocalDateTime;
import java.time.Duration;
public class reserva{
    private LocalDateTime f1;
    private String nombre;
    private Duration d1;
    public reserva(LocalDateTime f1, String nombre,Duration d1){
        this.f1=f1;
        this.nombre=nombre;
        this.d1=d1;
    }

    public LocalDateTime getf1(){
        return f1;
    }

    public String getnombre() {
        return nombre;
    }
    public Duration getd1(){
        return d1;
    }
}

