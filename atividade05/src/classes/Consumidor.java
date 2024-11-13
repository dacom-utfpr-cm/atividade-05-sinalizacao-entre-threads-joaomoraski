package classes;

public class Consumidor extends Thread {
    private final Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consumir();
                Thread.sleep((int) (Math.random() * 1000)); // Simula tempo aleatório de consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
