package com.example.proxyex2.proxy;

public class Presentation {
    IMetier metier;

    public Presentation() {
    }

    public void setMetier(IMetier metier) {
        this.metier = metier;
    }

    public void operation (int n){
        double res=metier.calcul(n);
        System.out.println("pour n ="+n+ " ---> "+ res);
        System.out.println("=================");
    }
}
