package cn.tedu.demo1.rui.service;

import cn.tedu.demo1.rui.model.Message;
import cn.tedu.demo1.rui.service.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
@Slf4j
public class UserServiceTests {

    @Autowired
    IMessageService iMessageService;

    @Test
    void insertMessage(){
        try {
        Message message=new Message();
        message.setName("admin");
        message.setPassword("123456");
        iMessageService.insertMessage(message);
        log.debug("register student > OK.");
    } catch (
           ServiceException e) {
        log.debug("register student > not.");
        log.debug("cause : {}", e.getClass());
    }
    }
    @Test
    void login() {
        String username = "admin";
        UserDetails userDetails = iMessageService.login(username);
        log.debug("login, user details={}", userDetails);
    }
}
