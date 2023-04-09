package tarea;


public class Cliente implements Runnable {

    private int id;
    private static int totalProductosAdquiridos = 0;
    private static long tiempoTotalClientes = 0;

    public Cliente(int id) {
        this.id = id;
    }

    public static synchronized void addProductosAdquiridos(int numProductos) {
        totalProductosAdquiridos += numProductos;
    }

    public static int getTotalProductosAdquiridos() {
        return totalProductosAdquiridos;
    }

    public static long getTiempoPromedioClientes() {
        return tiempoTotalClientes / 100;
    }

    @Override
    public void run() {
        try {
            // Simular llegada del cliente
            System.out.println("El cliente " + id + " a llegado al supermercado");
            long tiempoDeLlegada = System.currentTimeMillis();

            // Simular búsqueda de productos
            int numPasillos = Rand.randomNumber(8, 13);
            int numProductos = 0;
            for (int i = 1; i <= numPasillos; i++) {
                numProductos = Rand.randomNumber(0, 6);
                System.out.println("El cliente " + id + " esta en el pasillo " + i + " y eligio " + numProductos + " productos");
                for (int j = 0; j < numProductos; j++) {
                    Thread.sleep(Rand.randomNumber(200, 800));
                    addProductosAdquiridos(numProductos);
                }

            }

            // Simular espera en la caja
            System.out.println("El cliente " + id + " esta en la fila" );
            Cajera.atenderCliente(numProductos, id);

            // Registrar tiempo del cliente
            tiempoTotalClientes += System.currentTimeMillis() - tiempoDeLlegada;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
