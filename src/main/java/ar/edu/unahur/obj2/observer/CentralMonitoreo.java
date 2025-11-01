package ar.edu.unahur.obj2.observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unahur.obj2.observer.alertas.Alerta;
import ar.edu.unahur.obj2.observer.excepciones.ErrorDeNivelDeAlerta;
import ar.edu.unahur.obj2.observer.observer.IObservado;
import ar.edu.unahur.obj2.observer.observer.IObservador;

public class CentralMonitoreo implements IObservado{
    private final Set<IObservador> observadores = new HashSet<>();
    private final Map<Alerta,Integer> registro = new HashMap<>();




    @Override
    public void agregarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void quitarObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar(Alerta alerta) {
        observadores.forEach(o -> o.actualizar(alerta));
    }

    public void emitirAlerta(String tipo, Integer nivel){
        if(nivel > 10 || nivel < 1){
            throw new ErrorDeNivelDeAlerta("Nivel de alerta incorrecto");
        }
        Alerta alerta = new Alerta(tipo, nivel);
        notificar(alerta);
        registro.put(alerta, observadores.size());
    }

    public Integer cantidadNotificacionesEnviadas(){
        return registro.values().stream().mapToInt(Integer::intValue).sum();
    }

}
