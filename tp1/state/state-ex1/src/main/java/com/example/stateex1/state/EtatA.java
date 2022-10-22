package com.example.stateex1.state;

public class EtatA extends Etat {
    public EtatA(ClasseAvecEtat classeAvecEtat) {
        super(classeAvecEtat);
    }

    @Override
    public void operationEtatA() {
        System.out.println("Classe deja dans l'etat A");
    }

    @Override
    public void operationEtatB() {
        classeAvecEtat.setEtat(new EtatB(classeAvecEtat));
        System.out.println("Changement d'etat de A=>B");
    }

    @Override
    public void operationEtatC() {
        System.out.println("Impossible de passer de A=>C");
    }

    @Override
    public void doAction() {
        System.out.println("Etat courant : A");
    }
}
