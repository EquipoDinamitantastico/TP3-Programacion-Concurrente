package ej02.components;

public class ProductorBizcocho extends Thread{

    private Panaderia panaderia;

    public ProductorBizcocho(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (400 + Math.random() * 200));  // Tiempo de producción entre 400ms y 600ms
                //Thread.sleep(500);
                panaderia.colocarBizcocho();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
