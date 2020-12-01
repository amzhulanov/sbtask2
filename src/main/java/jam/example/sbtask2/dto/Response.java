package jam.example.sbtask2.dto;

/**
 * Сущность для возврата кода ошибок в JSON
 *
 * @author JAM
 */
public class Response {
    private String message;

    public Response() {
    }

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
