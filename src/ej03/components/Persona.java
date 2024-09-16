package ej03.components;

public class Persona extends Thread{

    private Zoologico zoologico;
    private int Id;

    public Persona(Zoologico zoologico, int id) {
        this.zoologico = zoologico;
        Id = id;
    }

    @Override
    public void run(){
        try {
            System.out.println("Persona (" + Id + ") llegando al Zoologico...");
            zoologico.entradaSalida(Id, "Entrar");

            // permanece en el zoo
            System.out.println("Persona (" + Id + ") Dentro del Zoologico...");
            Thread.sleep((int) (400 + Math.random() * 300));

            zoologico.entradaSalida(Id, "Salir");
            System.out.println("Persona (" + Id + ") Salio..." );

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
