package ar.edu.unahur.obj2.observer.observer;

import ar.edu.unahur.obj2.observer.alertas.Alerta;

public interface IObservado {
    void agregarObservador(IObservador observador);
    void quitarObservador(IObservador observador);
    void notificar(Alerta alerta);

    
}
