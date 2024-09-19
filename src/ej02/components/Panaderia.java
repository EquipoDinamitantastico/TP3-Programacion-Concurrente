package ej02.components;

public class Panaderia {

    private boolean bizcochoDisponible = false;
    private boolean facturaDisponible = false;

    private final Object lockBizcocho = new Object();  // Monitor para bizcochos
    private final Object lockFactura = new Object();   // Monitor para facturas

    // Colocar Bizcochos
    public void colocarBizcocho() throws InterruptedException {
        synchronized (lockBizcocho) {
            while (bizcochoDisponible) {
                lockBizcocho.wait();     // Pongo en espera porque ya hay un bizcocho en el mostrador
            }
            bizcochoDisponible = true;
            System.out.println("Se ha producido un bizcocho!...");
            lockBizcocho.notify();       // Notificar al siguiente consumidor de bizcocho
        }
    }

    // Colocar Facturas
    public void colocarFactura() throws InterruptedException {
        synchronized (lockFactura) {
            while (facturaDisponible) {
                lockFactura.wait();     // Pongo en espera porque ya hay una factura en el mostrador
            }
            facturaDisponible = true;
            System.out.println("Se ha producido una factura!...");
            lockFactura.notify();       // Notificar al siguiente consumidor de factura
        }
    }

    // Comprar
    public void comprar(int numCliente) throws InterruptedException {
        synchronized (lockBizcocho) {
            while (!bizcochoDisponible) {
                System.out.println("Cliente (" + numCliente + ") está esperando un bizcocho...");
                lockBizcocho.wait();    // El cliente espera si no hay bizcocho
            }
            bizcochoDisponible = false;
            System.out.println("Cliente (" + numCliente + ") ha tomado un bizcocho");
            lockBizcocho.notify();      // Permitir que se produzcan más bizcochos
        }

        synchronized (lockFactura) {
            while (!facturaDisponible) {
                System.out.println("Cliente (" + numCliente + ") está esperando una factura...");
                lockFactura.wait();     // El cliente espera si no hay factura
            }
            facturaDisponible = false;
            System.out.println("Cliente (" + numCliente + ") ha tomado una factura");
            lockFactura.notify();       // Permitir que se produzcan más facturas
        }

        // tiempo de compra
        Thread.sleep((int) (200 + Math.random() * 200));
        System.out.println("Cliente (" + numCliente + ") ha comprado bizcocho y factura");
    }
}
