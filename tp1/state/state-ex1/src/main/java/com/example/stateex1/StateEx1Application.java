package com.example.stateex1;

import com.example.stateex1.state.ClasseAvecEtat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StateEx1Application {

    public static void main(String[] args) {
        ClasseAvecEtat obj = new ClasseAvecEtat();obj.doAction();
        System.out.println("------------");
        obj.operationEtatA();obj.doAction();System.out.println("------------");
        obj.operationEtatC();obj.doAction();System.out.println("------------");
        obj.operationEtatB();obj.doAction();System.out.println("------------");
        obj.operationEtatC();obj.doAction();System.out.println("------------");
        obj.operationEtatA();obj.doAction();System.out.println("------------");

    }

}
