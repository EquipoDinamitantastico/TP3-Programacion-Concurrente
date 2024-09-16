package ej03.components;

public class Zoologico {

    private boolean pasilloDisponible = true;

    // Metodo a sincronizar
    public void entradaSalida(int IdPersona, String msj) throws InterruptedException{
        synchronized (this) {
            // Mientras el pasillo esté ocupado, el hilo espera
            if (!pasilloDisponible) {
                System.out.println("La persona (" + IdPersona + ") esta esperando por " + msj);
                wait();  // Espera hasta que el pasillo esté disponible
            }
            // El pasillo ahora está ocupado
            pasilloDisponible = false;
            mostrarAccion(IdPersona, msj);
        }
        // usa el pasillo
        Thread.sleep(50);

        synchronized (this) {
            // Libera el pasillo
            pasilloDisponible = true;
            notifyAll();  // Notifica a las otras personas que el pasillo está disponible
        }
    }


    private boolean mostrarAccion(int Id, String msj){
        if (msj.equals("Entrar")){
            System.out.println("La persona (" + Id + ") esta entrando por el pasillo");
            return false;
        }
        System.out.println("La persona (" + Id + ") esta saliendo por el pasillo");
        return false;
    }
}
