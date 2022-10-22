package com.example.proxyex2.proxy;

public class ProxySecurity implements IMetier {
    Proxy proxy=new Proxy();
    private String key;

    public ProxySecurity(String key) {
        this.key = key;
    }

    @Override
    public double calcul(int n) {
        if(key.equals("123")) {
            return proxy.calcul(n);
        }else{
            throw new RuntimeException("Not authorized");
        }
    }
}
