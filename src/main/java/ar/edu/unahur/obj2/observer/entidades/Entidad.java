package ar.edu.unahur.obj2.observer.entidades;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.alertas.Alerta;
import ar.edu.unahur.obj2.observer.riesgos.IRiesgo;
import ar.edu.unahur.obj2.observer.riesgos.RiesgoCritico;

public class Entidad {
    private final String nombre;
    private final List<Alerta> alertasRegistradas = new ArrayList<>();
    private IRiesgo riesgo = new RiesgoCritico();
    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    
    public String getNombre() {
        return nombre;
    }


    public Integer calcularRiesgo(){
        return riesgo.calcularRiesgo(alertasRegistradas);
    }
    
    
    public void cambiarComportamiento(IRiesgo riesgo){this.riesgo = riesgo;}
    

}
