package ar.edu.unahur.obj2.observer.riesgos;

import java.util.List;

import ar.edu.unahur.obj2.observer.alertas.Alerta;

public class RiesgoAcumulativo implements IRiesgo{

    @Override
    public Integer calcularRiesgo(List<Alerta> alertas) {
        return alertas.isEmpty()  ? 0 : (int)calculoAcumulativo(alertas);
    }

    private Integer calculoAcumulativo(List<Alerta> alertas){
        return alertas.stream().filter(Alerta :: esCritica)
            .mapToInt(Alerta :: getNivel)
            .sum();
    }
}
