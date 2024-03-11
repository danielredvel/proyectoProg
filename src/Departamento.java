public class Departamento {
    private String clave;
    private String nombre;
    public Departamento(String nombre, String clave){
        this.clave=clave;
        this.nombre=nombre;
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
