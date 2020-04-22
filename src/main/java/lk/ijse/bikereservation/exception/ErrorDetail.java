package lk.ijse.bikereservation.exception;

import lombok.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {
    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorDetail(BaseException ex, WebRequest request){
        this.timestamp=new Date();
        this.status=ex.getCode();
        this.error=ex.getDescription();
        this.message=ex.getMessage();
        this.path=((ServletWebRequest)request).getRequest().getRequestURI();
    }
}
