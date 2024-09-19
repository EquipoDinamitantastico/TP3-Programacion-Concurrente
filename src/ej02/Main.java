package ej02;

import ej02.components.Cliente;
import ej02.components.Panaderia;
import ej02.components.ProductorBizcocho;
import ej02.components.ProductorFactura;

public class Main {

    public static void main(String[] args) {

        Panaderia panaderia = new Panaderia();

        // Creamos los productores de bizcochos y facturas
        new ProductorFactura(panaderia).start();
        new ProductorBizcocho(panaderia).start();

        // Creamos Clientes y los inciamos para que consuman
        for (int i=1; i<=10; i++){
            new Cliente(panaderia, i).start();
            try{
                Thread.sleep((int) (800 + Math.random() * 700));  // Tiempo de llegada entre 800ms y 1500ms
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
