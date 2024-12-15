package org.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class First {

//We need obj of First but First is dependent on Second so the comp will connect this two
      @Autowired
      @Qualifier("second_part2")             //field injection, when we need to connect the two class automatically we use this
      private InterfaceOfSecond sec;         //here second is an instant variable

//    public First( Second second) {          //this is Constructor injection
//        this.second = second;
//    }
//    @Autowired                                   //Setter injection
//    public void setSecond(Second second) {
//        this.second = second;
//    }

    public void coders(){

        System.out.println("Hello! let's start.");

        sec.developers();
    }

}
