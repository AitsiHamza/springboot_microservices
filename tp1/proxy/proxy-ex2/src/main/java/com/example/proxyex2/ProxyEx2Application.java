package com.example.proxyex2;

import com.example.proxyex2.proxy.Presentation;
import com.example.proxyex2.proxy.ProxySecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyEx2Application {

    public static void main(String[] args) {
        Presentation presentation=new Presentation();
        presentation.setMetier(new ProxySecurity("123"));
        presentation.operation(120);
        presentation.operation(100);
        presentation.operation(100);
        System.out.println("**********************");
        System.out.println("Another connection: ");
        Presentation presentation2=new Presentation();
        presentation2.setMetier(new ProxySecurity("1234"));
        presentation2.operation(1);
    }

}
