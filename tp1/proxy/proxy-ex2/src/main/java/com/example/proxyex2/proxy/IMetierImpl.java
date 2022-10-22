package com.example.proxyex2.proxy;

public class IMetierImpl implements IMetier {
    @Override
    public double calcul(int n) {
        return n*n;
    }
}
