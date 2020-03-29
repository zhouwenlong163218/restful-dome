package com.example.restfuldome.config;

import com.example.restfuldome.common.ErrorResponseEntity;
import com.example.restfuldome.common.ExceptionType;
import com.example.restfuldome.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ErrorResponseEntity customExceptionHandler(HttpServletRequest request, final ExceptionHandler e, HttpServletResponse response){
     response.setStatus(HttpStatus.BAD_REQUEST.value());
     CustomException exception =(CustomException) e;
     return new ErrorResponseEntity(exception.getCode(),exception.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request, final RuntimeException e
    ,HttpServletResponse response){
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        RuntimeException exception = e;
        return new ErrorResponseEntity(ExceptionType.SERVER_ERROR.getCode(),
                ExceptionType.SERVER_ERROR.getMsg());
    }
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status, WebRequest request){
        if(ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
                    exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()),status);

        }
        if(ex instanceof MethodArgumentTypeMismatchException){
          MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数错误，方法："+exception.getParameter().getMethod().getName()+"，参数"+exception.getName()
            +"，信息" +exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(),"参数错误"),status);

        }
        return new ResponseEntity<>(new ErrorResponseEntity(status.value(),"参数错误"),status);
    }

}
