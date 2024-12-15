package org.spring.springboot;

import org.springframework.stereotype.Component;

@Component
public class Second implements InterfaceOfSecond {

    public void developers(){

        System.out.println("Hello! Let's develop.");
    }

}
