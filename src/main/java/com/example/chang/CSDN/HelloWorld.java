package com.example.chang.CSDN;

import com.example.chang.CSDN.data.User;
import com.example.chang.CSDN.web.NeoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@Slf4j
public class HelloWorld {

    @Resource
    NeoProperties properties;

    @RequestMapping("/hello")
    public String index() {
//        System.out.println("this is hello");
        log.error("error hello");
        log.info("info hello");
        return "Hello World"+properties.getDescription();
    }

    @RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public User getUser() {
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
