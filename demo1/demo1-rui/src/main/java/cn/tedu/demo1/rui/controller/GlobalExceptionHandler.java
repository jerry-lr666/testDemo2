package cn.tedu.demo1.rui.controller;

import cn.tedu.demo1.rui.service.ex.InsertException;
import cn.tedu.demo1.rui.service.ex.NameNotNullException;
import cn.tedu.demo1.rui.service.ex.ParameterValidationException;
import cn.tedu.demo1.rui.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.soap.Name;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public R handlerException(Throwable e) {
        if (e instanceof ParameterValidationException){
            return R.not(R.State.ERR_PARAMETER_INVALIDATION,e);
        }else if (e instanceof NameNotNullException){
            return R.not(R.State.ERR_NAME_NOT_NULL,e);
        }else if (e instanceof InsertException){
            return R.not(R.State.ERR_INSERT,e);
        }else{
            log.debug("unknown exception >{}",e);
            return R.not(R.State.ERR_UNKNOWN,e);
        }
    }
}
