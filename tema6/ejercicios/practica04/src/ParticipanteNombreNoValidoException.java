public class ParticipanteNombreNoValidoException extends Exception {

    public ParticipanteNombreNoValidoException() {
        super("El nombre del participante no es válido");
    }

    public ParticipanteNombreNoValidoException(String message) {
        super(message);
    }
}
