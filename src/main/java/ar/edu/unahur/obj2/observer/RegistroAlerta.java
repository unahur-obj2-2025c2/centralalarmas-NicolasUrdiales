package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.alertas.Alerta;

public class RegistroAlerta {
    private final Alerta alerta;
    private final Integer cantidadDeEntidadesNotificadas;
    public RegistroAlerta(Alerta alerta, Integer cantidadDeEntidadesNotificadas) {
        this.alerta = alerta;
        this.cantidadDeEntidadesNotificadas = cantidadDeEntidadesNotificadas;
    }
    public Alerta getAlerta() {
        return alerta;
    }
    public Integer getCantidadDeEntidadesNotificadas() {
        return cantidadDeEntidadesNotificadas;
    }

    
}
