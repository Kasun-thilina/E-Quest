package lk.ijse.bikereservation.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Getter
@Setter
public class ResourcesNotFoundException extends Exception {

    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourcesNotFoundException(String resourceName, String fieldName, Object fieldValue){
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
