package ej02.components;

public class Panaderia {

    private boolean bizcochoDisponible = false;
    private boolean facturaDisponible = false;


    // Sincronizamos el acceso al mostrador

    public void colocarBizcocho() throws InterruptedException{
        synchronized (this){
            while (bizcochoDisponible){
                wait();     // pongo en espera porque ya hay un bizcocho en el mostrador
            }
            bizcochoDisponible = true;
            System.out.println("Se ha producido un bizcocho!...");
            notify();
        }
    }

    public void colocarFactura() throws InterruptedException{
        synchronized (this){
            while (facturaDisponible){
                wait();     // pongo en espera porque ya hay un bizcocho en el mostrador
            }
            facturaDisponible = true;
            System.out.println("Se ha producido una factura!...");
            notify();
        }

    }


    public void comprar(int numCliente) throws InterruptedException{
        synchronized (this){
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
}
