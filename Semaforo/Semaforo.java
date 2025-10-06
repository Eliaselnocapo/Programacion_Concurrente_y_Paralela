public class Semaforo {

    private int counter;

    public Semaforo() {
        counter = 0;
    }

    public Semaforo(int i) {
        if (i < 0) throw new IllegalArgumentException(i + " < 0");
        counter = i;
    }

    /**
     * Incrementa el contador interno, posiblemente
     * despierte a un hilo que se mantuvo esperando por
     * acquire().
     */
    public synchronized void release() {
        if (counter == 0) {
            this.notify();
        }
        counter++;
    }

    /**
     * Decrementa el contador interno,
     * bloqueandolo si el contador es cero.
     * InterruptedException pasa por this.wait().
     */
    public synchronized void acquire() throws InterruptedException {
        while (counter == 0) {
            this.wait();
        }
        counter--;
    }
}