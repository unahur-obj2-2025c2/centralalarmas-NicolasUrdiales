package ar.edu.unahur.obj2.observer.riesgos;

import java.util.List;

import ar.edu.unahur.obj2.observer.alertas.Alerta;

public interface IRiesgo {
    Integer calcularRiesgo(List<Alerta> alertas);
}
