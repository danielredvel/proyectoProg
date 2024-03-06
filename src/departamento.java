public class departamento {
    private String clave;
    private String nombre;
    public departamento(String nombre, String clave){
        this.clave=clave;
        this.nombre=nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }
}
