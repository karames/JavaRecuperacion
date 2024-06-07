public class TestValidarIP {
    public static void main(String[] args) throws Exception {
        String ip = "192.168.1.109";
        String puertaEnlace = "192.168.1.1";
        String dns1 = "8.8.8.8";
        String dns2 = "4.4.4.4";

        System.out.println(Conexion.isIpValida(ip));
    }
}
