package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Modelo;
import service.Servicio;

@Named(value = "textoC")
@SessionScoped
public class TextoC implements Serializable {

    private Modelo modelo;
    private Servicio servicio;

    public TextoC() {
        modelo = new Modelo();
        servicio = new Servicio();
    }

    public void text() {
        try {
            Servicio.abuso(modelo);
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

}
