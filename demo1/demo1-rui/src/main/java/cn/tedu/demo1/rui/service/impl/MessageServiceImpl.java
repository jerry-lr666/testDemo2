package cn.tedu.demo1.rui.service.impl;

import cn.tedu.demo1.rui.model.Message;
import cn.tedu.demo1.rui.mapper.MessageMapper;
import cn.tedu.demo1.rui.security.UserInfo;
import cn.tedu.demo1.rui.service.IMessageService;
import cn.tedu.demo1.rui.service.ex.InsertException;
import cn.tedu.demo1.rui.service.ex.NameNotNullException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.authenticator.SingleSignOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-08-30
 */
@Slf4j
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Autowired
    private MessageMapper mapper;

    //密码加密
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Override
    public void insertMessage(Message message) {
        //判断账户是否存在
        QueryWrapper<Message> nameQueryWrapper=new QueryWrapper<>();
        nameQueryWrapper.eq("name",message.getName());
        Message message1=mapper.selectOne(nameQueryWrapper);
        log.debug("message1>>>>{}",message1);
        if (message1 != null) {
            throw new NameNotNullException("注册失败:账户已存在...");
        }
        String rawPassword=encode(message.getPassword());
        message.setPassword(rawPassword);
        int row=mapper.insert(message);
        if (row!=1) {
            throw new InsertException("注册失败:系统繁忙,请重试");
        }
    }

    @Override
    public UserDetails login(String name) {
        QueryWrapper<Message> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name);
        Message message=mapper.selectOne(queryWrapper);
        if(message==null){
            return null;
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .builder()
                .username(message.getName())
                .password(message.getPassword())
                .authorities("test")
                .build();
        return userDetails;
    }

    private String encode(String rawPassword){
        String encodePassword=passwordEncoder.encode(rawPassword);
        encodePassword="{bcrypt}"+encodePassword;
        return encodePassword;
    }

}
