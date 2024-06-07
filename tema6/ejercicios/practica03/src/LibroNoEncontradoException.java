public class LibroNoEncontradoException extends Exception {

    public LibroNoEncontradoException(String isbn) {
        super("El libro con isbn '" + isbn + "' no se ha encontrado en la biblioteca");
    }

}
