import java.util.regex.Pattern;

public class Conexion {

    String ip, puertaEnlace, dns1, dns2;

    public Conexion(String ip, String puertaEnlace, String dns1, String dns2) {
        this.ip = ip;
        this.puertaEnlace = puertaEnlace;
        this.dns1 = dns1;
        this.dns2 = dns2;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuertaEnlace() {
        return puertaEnlace;
    }

    public void setPuertaEnlace(String puertaEnlace) {
        this.puertaEnlace = puertaEnlace;
    }

    public String getDns1() {
        return dns1;
    }

    public void setDns1(String dns1) {
        this.dns1 = dns1;
    }

    public String getDns2() {
        return dns2;
    }

    public void setDns2(String dns2) {
        this.dns2 = dns2;
    }

    public static boolean isIpValida(String ip) {

        String regex = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";
        String regex = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";

        return true;
    }

    @Override
    public String toString() {
        return "Conexion [ip=" + ip + ", puertaEnlace=" + puertaEnlace + ", dns1=" + dns1 + ", dns2=" + dns2 + "]";
    }

}
