package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.entidades.Entidad;
import ar.edu.unahur.obj2.observer.riesgos.RiesgoPromedio;

public class CentralMonitoreoTest {
    private CentralMonitoreo central ;
    private Entidad e1; 
    private Entidad e2;
    
    
    @BeforeEach
    void setUp(){
        central = new CentralMonitoreo(); 
        e1 = new Entidad("e1");
        e2 = new Entidad("e2");
        central.agregarObservador(e1);
        central.agregarObservador(e2);

    }


    @Test
    void dadoElSetUp_alAgregarAlertas_SeVerificaCorrectamenteLasAlertasRecibidasYElRiego(){
        setUp();
        central.emitirAlerta("calor",6);
        central.emitirAlerta("lluvia", 8);

        assertEquals(2, e1.getAlertasRegistradas().size());
        assertEquals(2, e2.getAlertasRegistradas().size());
        assertEquals(10, e1.calcularRiesgo());
        assertEquals(10, e2.calcularRiesgo());
    }

    @Test
    @DisplayName("dadoElSetup_alCambiarElComportamientoYAgregarAlertas_SeVerificaCorrectamenteLasAlertasRecibidasYElRiesgo")
    void test2(){
        setUp();
        
        e1.cambiarComportamiento(new RiesgoPromedio());
        central.emitirAlerta("calor",6);
        central.emitirAlerta("lluvia", 8);

        assertEquals(2, e1.getAlertasRegistradas().size());
        assertEquals(2, e2.getAlertasRegistradas().size());

        assertEquals(7, e1.calcularRiesgo());
        assertEquals(10, e2.calcularRiesgo());
    }



    @Test
    void dadoElSetup_alAgregarAlertasQuitarUnaEntidadYAgregaNuevaAlerta_SeerificaCorrectamenteLasAlertasRecibidasYElRiego(){
        setUp();
        central.emitirAlerta("calor", 6);
        central.emitirAlerta("lluvia", 8);
        central.quitarObservador(e1);
        central.emitirAlerta("granizo", 7);

        assertEquals(2, e1.getAlertasRegistradas().size());
        assertEquals(3, e2.getAlertasRegistradas().size());
        assertEquals(10, e1.calcularRiesgo());
        assertEquals(7, e2.calcularRiesgo());
        assertEquals(5, central.cantidadNotificacionesEnviadas());
    }

}
