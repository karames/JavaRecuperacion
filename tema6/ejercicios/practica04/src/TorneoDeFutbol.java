import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TorneoDeFutbol extends EventoDeportivo {

    private List<Equipo> equipos;

    public TorneoDeFutbol(String nombre, LocalDate fecha, String lugar) {
        super(nombre, fecha, lugar);
        this.equipos = new ArrayList<>();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void inscribirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    @Override
    public ArrayList<Participante> obtenerGanador() {
        ArrayList<Participante> ganadores = new ArrayList<>();
        Equipo ganador = null;
        int maxPuntos = 0;
        for (Equipo e : equipos) {
            if (e.getPuntos() > maxPuntos) {
                maxPuntos = e.getPuntos();
                ganador = e;
            }
        }
        // recorremos los jugadores del equipo ganador
        for (Participante p : ganador.getJugadores()) {
            ganadores.add(p);
        }
        return ganadores;
    }

    @Override
    public void mostrarGanador() {

        System.out.println("Los ganadores del torneo de fútbol han sido:");
        for (Participante p : obtenerGanador()) {
            System.out.println(p.getNombre() + " " + p.getApellido());
        }
    }

    @Override
    public ArrayList<Participante> getParticipantes() {
        ArrayList<Participante> participantesTorneo = new ArrayList<>();
        for (Equipo equipo : equipos) {
            for (Participante p : equipo.getJugadores()) {
                participantesTorneo.add(p);
            }
        }
        return participantesTorneo;
    }
}
