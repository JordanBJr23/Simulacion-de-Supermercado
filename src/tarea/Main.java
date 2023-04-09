
package tarea;


public class Main {

    public static void main(String[] args)  {
        

        // Crear hilos para cada cliente
        for (int i = 1; i <= 2; i++) {
            Thread hiloCliente = new Thread(new Cliente(i));
            try {
                Thread.sleep((Rand.randomNumber(300, 600)));
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            hiloCliente.start();
            
        }
     while (Thread.activeCount() != 1) {
            try {
                Thread.sleep(1000); // Esperar un segundo antes de verificar de nuevo
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
    }
        
        System.out.println("Total de productos adquiridos por los clientes: " + Cliente.getTotalProductosAdquiridos());
        System.out.println("Tiempo promedio de estancia de los clientes en el supermercado: " + Cliente.getTiempoPromedioClientes() + " segundos");
        System.out.println("Tiempo promedio de atencion de la cajera: " + Cajera.getTiempoPromedioCajera() + " milisegundos");
    }

}
