public class App {

    public static void main(String[] args) {

        Factura f = new Factura(1, "cliente", 500);
        LineaFactura linea1 = new LineaFactura(1, "pantalla", 200);
        LineaFactura linea2 = new LineaFactura(2, "cpu", 300);
        f.addLinea(linea1);
        f.addLinea(linea2);

        try {
            // Factura nueva = (Factura) f.clone();

            // nueva.setNumero(2);

            System.out.println(f.getNumero());
            System.out.println(f.getConcepto());
            System.out.println(f.getImporte());
            for (LineaFactura lf : f.getLineas()) {
                System.out.println(lf.getNumero());
                System.out.println(lf.getConcepto());
                System.out.println(lf.getImporte());
            }

            System.out.println("****************");
            Factura nueva = (Factura) f.clone();
            nueva.setNumero(2);
            // para cambia hascode
            // nueva.setConcepto("gonzalo");
            System.out.println(nueva.getNumero());
            System.out.println(nueva.getConcepto());
            System.out.println(nueva.getImporte());
            for (LineaFactura lf : nueva.getLineas()) {
                System.out.println(lf.getNumero());
                System.out.println(lf.getConcepto());
                System.out.println(lf.getImporte());
            }

            System.out.println("****************");

            System.out.println("comparar hascode ");
            if (f.hashCode() == nueva.hashCode()) {
                System.out.println("Los objetos tienen el mismo código hash: " + f.hashCode());
            } else {
                System.out.println("Los objetos NO tienen el mismo código hash");
                System.out.println("Código hash objeto 1: " + f.hashCode());
                System.out.println("Código hash objeto 2: " + nueva.hashCode());
            }
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
