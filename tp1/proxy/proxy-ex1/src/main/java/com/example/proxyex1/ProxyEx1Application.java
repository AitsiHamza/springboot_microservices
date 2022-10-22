package com.example.proxyex1;

import com.example.proxyex1.proxy.Abstraction;
import com.example.proxyex1.proxy.Proxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyEx1Application {

    public static void main(String[] args) {
        Abstraction proxy=new Proxy();
        System.out.println("Lancement de l'operation");
        proxy.operation();
        System.out.println("Resultat");
    }

}
