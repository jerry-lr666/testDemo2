package cn.tedu.demo1.rui.service;

import cn.tedu.demo1.rui.model.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-08-30
 */
public interface IMessageService extends IService<Message> {

    /**
     * 注册用户
     * @param message
     */
    void insertMessage(Message message );

    /**
     * 用根据用户名获取用户详情，将应用于Spring-Security验证登录
     * @param name 根据用户名获取用户信息
     * @return
     */
    UserDetails login(String name);
}
