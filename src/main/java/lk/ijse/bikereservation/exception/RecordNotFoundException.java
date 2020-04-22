package lk.ijse.bikereservation.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Getter
@NoArgsConstructor
public class RecordNotFoundException extends BaseException {

    private static final String MESSAGE ="Requested Data Not Found";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    private static final int CODE = ResponseCode.RECORD_NOT_FOUND;
    private String description;

    public RecordNotFoundException(String description){
        this.description = description;
    }

}
