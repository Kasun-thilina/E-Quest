package lk.ijse.bikereservation.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Chalodya
 * @since 2019/08
 **/
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity handleCustomExceptions(BaseException e, WebRequest request){
        return new ResponseEntity<>(new ErrorDetail(e,request),e.getStatus());

    }
}
