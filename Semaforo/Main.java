public class Main {

    public static void main(String[] args) {
        System.out.println("🎬 PREPARANDO LA ESCENA FINAL DE 'LA CAÍDA DE LA CASA BLANCA' 🎬\n");

        // 1. Crear la herramienta de sincronización (el semáforo).
        // Se inicializa en 0, forzando a que cualquier llamada a 'acquire' espere.
        Semaforo semaforo = new Semaforo(0);

        // 2. Crear el objeto que contiene la narrativa del clímax.
        Climax climax = new Climax(semaforo);

        // 3. ¡ACCIÓN! Iniciar el hilo de la película.
        climax.start();

        try {
            // El hilo main espera a que el hilo del clímax termine su ejecución.
            climax.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4. Mostrar el resultado final una vez que la simulación ha concluido.
        if (climax.isVillanoNeutralizado()) {
            System.out.println("\n🎉 DESENLACE: ¡La Casa Blanca es segura! El héroe ha ganado. 🎉");
        } else {
            System.out.println("\n😥 DESENLACE: La misión ha fracasado.");
        }
    }
}