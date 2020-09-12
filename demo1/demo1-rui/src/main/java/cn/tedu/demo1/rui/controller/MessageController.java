package cn.tedu.demo1.rui.controller;


import cn.tedu.demo1.rui.model.Message;
import cn.tedu.demo1.rui.service.IMessageService;
import cn.tedu.demo1.rui.service.ex.ParameterValidationException;
import cn.tedu.demo1.rui.vo.R;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tedu.cn
 * @since 2020-08-30
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MessageController {
   // http://localhost:8080/api/v1/register?name=root&password=123456
    @Autowired
    private IMessageService iMessageService;
    @RequestMapping("/register")
    public R insertName(@Validated Message message, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
        String errorMessage=bindingResult.getFieldError().getDefaultMessage();
        log.debug("validation has error:{}",errorMessage);
        throw new ParameterValidationException(errorMessage);
    }
    iMessageService.insertMessage(message);
    return R.ok();
    }


}
