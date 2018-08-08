package com.bmw.azure.reactive.exception;

import lombok.Data;

/**
 * @author Tongshan.Han@partner.bmw.com
 * @Description:
 * @date 2018/8/8 17:08
 */
@Data
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = -5655668680796689865L;

    private Integer code;
    private String message;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

}
