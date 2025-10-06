public class Climax extends Thread {

    private Semaforo semaforoOportunidad;
    private boolean villanoNeutralizado = false;

    public Climax(Semaforo semaforo) {
        this.semaforoOportunidad = semaforo;
    }

    @Override
    public void run() {
        try {
            // --- INICIO DEL CLÍMAX ---
            System.out.println("😠 El villano Stenz tiene el control de la Oficina Oval. Se siente invencible.");
            Thread.sleep(1500);

            System.out.println("🦸‍♂️ El héroe John Cale está afuera, buscando una oportunidad para entrar...");

            // --- PUNTO DE INFLEXIÓN ---
            System.out.println("... Stenz, en un exceso de confianza, se distrae por un momento.");
            System.out.println("¡Es la apertura que Cale necesitaba!");
            
            // El 'release' simula la oportunidad que el héroe va a aprovechar.
            // Esto incrementa el contador del semáforo de 0 a 1.
            semaforoOportunidad.release();

            // --- CONFRONTACIÓN ---
            // El 'acquire' funciona de inmediato porque el contador ahora es 1.
            semaforoOportunidad.acquire();
            System.out.println("💥 ¡John Cale irrumpe en la oficina! La pelea final ha comenzado.");
            Thread.sleep(2000); // Pausa para dar dramatismo a la pelea.

            // --- DESENLACE ---
            System.out.println("💪 Tras una brutal batalla, Cale neutraliza a Stenz.");
            this.villanoNeutralizado = true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isVillanoNeutralizado() {
        return villanoNeutralizado;
    }
}