package org.spring.springboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Second_part2 implements InterfaceOfSecond {

    public void developers(){

        System.out.println("Hello! Let's develop something unique");
    }

}
