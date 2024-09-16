package ej02.components;

public class ProductorFactura extends Thread{

    private Panaderia panaderia;

    public ProductorFactura(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (1000 + Math.random() * 300));  // Tiempo de producción entre 400ms y 600ms
                //Thread.sleep(500);
                panaderia.colocarFactura();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
