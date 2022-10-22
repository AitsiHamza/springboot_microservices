package com.example.stateex1.state;

public class EtatC extends Etat {

        public EtatC(ClasseAvecEtat classeAvecEtat) {
                super(classeAvecEtat);
        }

        @Override
        public void operationEtatA() {
                System.out.println("Changement d'etat de C=>A");
                classeAvecEtat.setEtat(new EtatA(classeAvecEtat));
        }

        @Override
        public void operationEtatB() {
                System.out.println("Changement d'etat de C=>B");
                classeAvecEtat.setEtat(new EtatB(classeAvecEtat));
        }

        @Override
        public void operationEtatC() {
                System.out.println("Classe deja dans l'etat C");
        }

        @Override
        public void doAction() {
                System.out.println("Etat courant : B");
        }
}
