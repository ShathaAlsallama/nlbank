package nl.novi.nlbank.exeption;


public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {

        super();

    }

    public RecordNotFoundException(String message) {

        super(message);

    }

}
