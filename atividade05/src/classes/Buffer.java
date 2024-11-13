package classes;

public class Buffer {
    private Integer valor = null;

    public synchronized void produzir(int novoValor) throws InterruptedException {
        while (valor != null) {
            wait(); // Espera até que o buffer esteja vazio
        }
        valor = novoValor;
        System.out.println("Produzido: " + valor);
        notify(); // Notifica o consumidor de que um novo valor foi produzido
    }

    public synchronized int consumir() throws InterruptedException {
        while (valor == null) {
            wait(); // Espera até que o buffer tenha algo a consumir
        }
        int valorConsumido = valor;
        valor = null;
        System.out.println("Consumido: " + valorConsumido);
        notify(); // Notifica o produtor de que o buffer está vazio
        return valorConsumido;
    }
}
