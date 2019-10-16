package models;

public class Partido {
    private String local;
    private String visitante;
    private String division;
    private String resultado;
    private String fecha;

    public Partido(String local, String visitante, String division, String resultado, String fecha) {
        this.local = local;
        this.visitante = visitante;
        this.division = division;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return "Partido [local=" + local + ", visitante=" + visitante + ", division=" + division + " , resultado=" + resultado + ", Fecha=" + fecha + "]";
    }
}








