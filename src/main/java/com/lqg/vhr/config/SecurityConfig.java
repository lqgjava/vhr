package com.lqg.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lqg.vhr.model.Hr;
import com.lqg.vhr.model.RespBean;
import com.lqg.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : 李清钢
 * @date : 2020-03-19 14:17
 * Spring Security配置类
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //要有一个configure方法吧hrService整进来
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    //配置登录成功或者登录失败向前端传送json数据
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //剩下的其他请求都是登录之后就能访问的
                .anyRequest().authenticated()
                .and()
                //表单登录
                .formLogin()
                //修改默认登录的username
                .usernameParameter("username")
                //修改默认登录的password
                .passwordParameter("password")
                //处理表单登录的url路径
                .loginProcessingUrl("/doLogin")
                //默认看到的登录页面，如果是前后端分离的话，就不用配置登录页面
                .loginPage("/login")
                //登录成功的处理
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        //如果登录成功就返回一段json
                        resp.setContentType("application/json;charset=utf-8");
                        //这是往出写的
                        PrintWriter out = resp.getWriter();
                        //登录成功的hr对象
                        Hr hr = (Hr)authentication.getPrincipal();
                        hr.setPassword(null);
                        RespBean ok = RespBean.ok("登录成功！", hr);
                        //把hr写成字符串
                        String s = new ObjectMapper().writeValueAsString(ok);
                        //把字符串写出去
                        out.write(s);
                        out.flush();
                        out.close();


                    }
                })
                //登录失败的处理
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
                        //如果登录成功就返回一段json
                        resp.setContentType("application/json;charset=utf-8");
                        //这是往出写的
                        PrintWriter out = resp.getWriter();
                        RespBean respBean = RespBean.error("登录失败！");
                        if(exception instanceof LockedException){
                            respBean.setMsg("账户被锁定，请联系管理员！");
                        }else if (exception instanceof CredentialsExpiredException){
                            respBean.setMsg("密码过期，请联系管理员！");
                        }else if (exception instanceof AccountExpiredException){
                            respBean.setMsg("账户过期，请联系管理员！");
                        }else if (exception instanceof DisabledException){
                            respBean.setMsg("账户被禁用，请联系管理员！");
                        }else if (exception instanceof BadCredentialsException){
                            respBean.setMsg("用户名或者密码输入错误，请重新输入！");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                //跟登录相关的接口就能直接访问
                .permitAll()
                .and()
                .logout()
                //注销成功后的回调
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功！")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                //关闭csrf攻击
                .csrf().disable();

    }

}
