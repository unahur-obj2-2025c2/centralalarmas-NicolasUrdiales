package ar.edu.unahur.obj2.observer.riesgos;

import java.util.List;

import ar.edu.unahur.obj2.observer.alertas.Alerta;

public class RiesgoPromedio implements IRiesgo{

    @Override
    public Integer calcularRiesgo(List<Alerta> alertas) {
        return alertas.isEmpty() ? 0: (int)calcularPromedio(alertas);
    }
    
    public Integer calcularPromedio(List<Alerta> alertas){
        Integer promedio = alertas.stream().mapToInt(Alerta :: getNivel).sum() / alertas.size();
        return promedio;
    }
}