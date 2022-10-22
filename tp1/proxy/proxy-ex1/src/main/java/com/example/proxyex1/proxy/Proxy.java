package com.example.proxyex1.proxy;

public class Proxy implements Abstraction {
    private Implementation implementation;
    @Override
    public void operation() {
        System.out.println("\tAvant l'implementation");
        implementation=new Implementation();
        implementation.operation();
        System.out.println("\tApres l'implementation");
    }
}
