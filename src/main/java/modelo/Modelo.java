package modelo;


public class Modelo{
    private String text;
    private String Abusivo;
    private String Odio;
    private String Ninguno;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAbusivo() {
        return Abusivo;
    }

    public void setAbusivo(String Abusivo) {
        this.Abusivo = Abusivo;
    }

    public String getOdio() {
        return Odio;
    }

    public void setOdio(String Odio) {
        this.Odio = Odio;
    }

    public String getNinguno() {
        return Ninguno;
    }

    public void setNinguno(String Ninguno) {
        this.Ninguno = Ninguno;
    }
    
}
