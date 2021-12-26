package com.example.backend;

import com.example.backend.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
//        Result<User> result = Result<>(StatusCode.OK);

        String token = JwtUtils.getJwtToken("123","456");

        Thread.sleep(1);
        System.out.println(JwtUtils.isSigned(token));
        System.out.println(JwtUtils.checkToken(token));
    }

}
