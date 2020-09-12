package cn.tedu.demo1.rui.security;

import cn.tedu.demo1.rui.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import netscape.security.UserDialogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Configuration
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IMessageService iMessageService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("name >>>>{}",username);
        return iMessageService.login(username);
    }


}
