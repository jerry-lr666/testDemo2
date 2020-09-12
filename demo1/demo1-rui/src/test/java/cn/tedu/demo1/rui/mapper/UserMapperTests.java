package cn.tedu.demo1.rui.mapper;

import cn.tedu.demo1.rui.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class UserMapperTests {


    @Autowired
    DataSource dataSource;
    @Autowired
    MessageMapper messageMapper;

    @Test
    void contextLoads() {
        log.debug("UserMapperTests.context");
    }

    @Test
    void getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.debug("connection > {}", connection);
    }
    @Test
    void insert(){
        Message message=new Message();
        message.setName("李玲");
        message.setPassword("123456");
        int row=messageMapper.insert(message);
        log.debug("row: >>>{}",row);
    }

}
