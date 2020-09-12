package cn.tedu.demo1.rui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tedu.demo1.rui.mapper")
public class Demo1RuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1RuiApplication.class, args);
    }

}
