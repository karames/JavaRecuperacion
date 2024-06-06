import java.util.ArrayList;
import java.util.List;

public class Factura implements Cloneable {

    private int numero;
    private String concepto;
    private double importe;
    private List<LineaFactura> lineas = new ArrayList<LineaFactura>();

    public Factura(int numero, String concepto, double importe) {
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public List<LineaFactura> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaFactura> lineas) {
        this.lineas = lineas;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Factura nueva = new Factura(this.numero, this.concepto, this.importe);
        return nueva;
    }

    public void addLinea(LineaFactura linea) {
        this.lineas.add(linea);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int aleatorio = (int) Math.random() * 1000;
        int result = 9 * aleatorio;
        result = prime * result + numero;
        result = prime * result + ((concepto == null) ? 0 : concepto.hashCode());
        long temp;
        temp = Double.doubleToLongBits(importe);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Factura other = (Factura) obj;
    // if (numero != other.numero)
    // return false;
    // if (concepto == null) {
    // if (other.concepto != null)
    // return false;
    // } else if (!concepto.equals(other.concepto))
    // return false;
    // if (Double.doubleToLongBits(importe) !=
    // Double.doubleToLongBits(other.importe))
    // return false;
    // return true;
    // }

}
