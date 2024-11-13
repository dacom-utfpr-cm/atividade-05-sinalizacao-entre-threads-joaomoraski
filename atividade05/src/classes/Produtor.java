package classes;

public class Produtor extends Thread {
    private final Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int valorProduzido = (int) (Math.random() * 100);
                buffer.produzir(valorProduzido);
                Thread.sleep((int) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
