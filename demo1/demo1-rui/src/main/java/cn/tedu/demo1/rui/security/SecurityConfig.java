package cn.tedu.demo1.rui.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

   //拦截器配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登陆页面的网址
        String loginPageUrl="/login.html";
        //处理登陆请求的URL
        String loginProcessingUrl="/login";
        //登录失败后的URL
        String loginFailureUrl="/login.html";
        //登陆成功后的URL
        String loginSuccessUrl="/index.html";
        //退出登录的的URL
        String logoutUrl="/logout";
        //退出登录成功后的URL
        String logoutSuccessUrl="/login.html?logout";
        //准备白名单，是不需要登录就可以访问的路径

        String[] antMatchers={
                loginPageUrl,
                "/register.html",
                "/api/v1/register",
                "/index.html",
                "/bootstrap3/**"
        };
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(antMatchers).permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage(loginPageUrl)
                .loginProcessingUrl(loginProcessingUrl)
                .failureUrl(loginFailureUrl)
                .defaultSuccessUrl(loginSuccessUrl)
                .and().logout()
                .logoutUrl(logoutUrl)
                .logoutSuccessUrl(logoutSuccessUrl);
    }
}
