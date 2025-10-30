package ar.edu.unahur.obj2.observer.alertas;

public class Alerta {
    private String descripcion;
    private Integer nivel;

    public Alerta(String descripcion, Integer nivel) {
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public Boolean esCritica(){
        return nivel >= 8;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }


}
