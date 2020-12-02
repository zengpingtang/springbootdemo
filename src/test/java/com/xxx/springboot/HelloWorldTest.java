package com.xxx.springboot;

import com.xxx.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldTest {

    @Autowired
    Person person;

    @Test
    public void testPerson(){
        System.out.println(person.toString());
    }

}
