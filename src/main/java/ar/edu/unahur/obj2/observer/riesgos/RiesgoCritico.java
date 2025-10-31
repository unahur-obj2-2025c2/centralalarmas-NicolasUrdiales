package ar.edu.unahur.obj2.observer.riesgos;

import java.util.List;

import ar.edu.unahur.obj2.observer.alertas.Alerta;

public class RiesgoCritico implements IRiesgo{

    @Override
    public Integer calcularRiesgo(List<Alerta> alertas) {
        if(alertas.isEmpty()){
            return 0;
        }
        else{
            return calcularUltimoAlerta(alertas);
        }
    }
    
    private Integer calcularUltimoAlerta(List<Alerta> alertas){
        Alerta ultimaAlerta = alertas.getLast();
        Integer nivel = ultimaAlerta.getNivel();
        return ultimaAlerta.esCritica() ? 10 : (int)nivel;
    }
}
