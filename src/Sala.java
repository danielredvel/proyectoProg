public class Sala {
    private String nombre;
    private String clave;
    public Sala(String nombre, String clave){
        this.nombre=nombre;
        this.clave=clave;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }
    public String toString(){
        String escribir="";
        escribir+="Nombre: "+this.nombre+", clave: "+this.clave;
        return escribir;
    }

}
