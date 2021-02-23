package com.jubo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    MyService mySrv;
    @Test
    public void testAdd() {
        int num = mySrv.add(2,6);
        assert num == 8;

        System.out.println("hello");
    }

}
