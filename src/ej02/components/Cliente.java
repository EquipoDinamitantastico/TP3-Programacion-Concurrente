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
            //Thread.sleep(1000);
            panaderia.comprar(numCliente);
            Thread.sleep((int) (200 + Math.random() * 200));  // Tiempo de compra y retirada entre 200ms y 400ms
            //Thread.sleep(300);
            System.out.println("Cliente " + numCliente + " se ha retirado del local.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
