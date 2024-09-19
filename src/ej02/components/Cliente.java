package ej02.components;

public class Cliente extends Thread{

    private Panaderia panaderia;
    private int numCliente;

    public Cliente(Panaderia panaderia, int numCliente){
        this.panaderia = panaderia;
        this.numCliente = numCliente;
    }

    public void run(){
        try {
            panaderia.comprar(numCliente);
            System.out.println("Cliente " + numCliente + " se ha retirado del local.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
