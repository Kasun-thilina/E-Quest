package lk.ijse.bikereservation.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Getter
public class DataNotFoundException extends BaseException {

    private static final String MESSAGE ="Missing Data ";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    private static final int CODE = ResponseCode.DATA_NOT_FOUNT;

    public DataNotFoundException(){
        super(MESSAGE,"",STATUS,CODE);
    }

    public DataNotFoundException(String description){
        super(MESSAGE,description,STATUS,CODE);
    }

}
