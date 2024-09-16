package ej02.components;

public class Panaderia {

    private boolean bizcochoDisponible = false;
    private boolean facturaDisponible = false;


    // Sincronizamos el acceso al mostrador

    public synchronized void colocarBizcocho() throws InterruptedException{
        while (bizcochoDisponible){
            wait();     // pongo en espera porque ya hay un bizcocho en el mostrador
        }
        bizcochoDisponible = true;
        System.out.println("Se ha producido un bizcocho!...");
        notify();
    }

    public synchronized void colocarFactura() throws InterruptedException{
        while (facturaDisponible){
            wait();     // pongo en espera porque ya hay un bizcocho en el mostrador
        }
        facturaDisponible = true;
        System.out.println("Se ha producido una factura!...");
        notify();
    }


    public synchronized void comprar(int numCliente) throws InterruptedException{
        while (!bizcochoDisponible || !facturaDisponible){
            System.out.println("Cliente (" + numCliente + ") Esta esperando...");
            wait();
        }

        bizcochoDisponible = false;
        facturaDisponible = false;

        System.out.println("Cliente (" + numCliente + ") ha comprado bizcocho y factura");
        notify();
    }
}
