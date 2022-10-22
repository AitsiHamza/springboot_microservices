package com.example.stateex1.state;

public class EtatB extends Etat {

    public EtatB(ClasseAvecEtat classeAvecEtat) {
        super(classeAvecEtat);
    }

    @Override
    public void operationEtatA() {
        System.out.println("Impossible de passer de A=>C");
    }

    @Override
    public void operationEtatB() {
        System.out.println("Classe deja dans l'etat B");
    }

    @Override
    public void operationEtatC() {
        classeAvecEtat.setEtat(new EtatC(classeAvecEtat));
        System.out.println("Changement d'etat de B=>C");
    }

    @Override
    public void doAction() {
        System.out.println("Etat courant : B");
    }
}
