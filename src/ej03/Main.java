package ej03;

import ej03.components.Persona;
import ej03.components.Zoologico;

public class Main {

    public static void main(String[] args) {

        Zoologico zoo = new Zoologico();

        for (int i=1; true; i++){
            new Persona(zoo, i).start();
            try {
                Thread.sleep((int) (100 + Math.random() * 100));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
