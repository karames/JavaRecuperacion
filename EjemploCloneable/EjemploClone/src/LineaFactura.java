public class LineaFactura {
    private int numero;
    private double importe;
    private String concepto;

    public LineaFactura(int numero, String concepto, double importe) {
        super();
        this.numero = numero;
        this.concepto = concepto;
        this.importe = importe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

}
