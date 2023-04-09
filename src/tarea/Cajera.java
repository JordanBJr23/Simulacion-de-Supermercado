package tarea;

import java.util.concurrent.Semaphore;

public class Cajera {

    private static long tiempoTotalCajera = 0;
    private static Semaphore semaforo = new Semaphore(1);

    public static long getTiempoPromedioCajera() {
        return tiempoTotalCajera / 100;
    }

    public static void atenderCliente(int numProductos , int id) {
        long tiempoInicioAtencion = System.currentTimeMillis();
        try {
            semaforo.acquire();
            System.out.println("Cajera atendiendo al Cliente " + id);
            for (int i = 0; i < numProductos; i++) {
                Thread.sleep(Rand.randomNumber(20, 80));
            }
            tiempoTotalCajera += System.currentTimeMillis() - tiempoInicioAtencion;
            System.out.println("Cliente " + id + " ha sido atendido");
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            semaforo.release();
        }
    }

}
