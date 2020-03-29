package com.example.restfuldome.exception;

import com.example.restfuldome.common.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {
    protected Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected String message;
public CustomException(ExceptionType type){
    this.code = type.getCode();
    this.message = type.getMsg();
}


}
