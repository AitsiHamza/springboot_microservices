package com.example.proxyex2.proxy;

import java.util.HashMap;
import java.util.Map;

public class Proxy implements IMetier {
    private IMetier metier=new IMetierImpl();
    private Map<Integer,Double> cache=new HashMap<>();

    @Override
    public double calcul(int n) {
        Double a = cache.get(n);
        if(a!=null){
            System.out.println("Resultat a partir du cache");
            return a;
        }else{
            System.out.println("Resultat a partir du metier");
            Double res=metier.calcul(n);
            cache.put(n,res);
            return res;
        }
    }
}
