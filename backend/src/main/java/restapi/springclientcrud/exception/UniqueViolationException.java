package restapi.springclientcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UniqueViolationException extends RuntimeException {

    public UniqueViolationException(String exception) {
        super(exception);
    }
}
