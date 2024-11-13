package classes;

public class Buffer {
    private Integer valor = null;

    public synchronized void produzir(int novoValor) throws InterruptedException {
        while (valor != null) wait();

        valor = novoValor;
        System.out.println("Produzido: " + valor);
        notify();
    }

    public synchronized int consumir() throws InterruptedException {
        while (valor == null) wait();
        int valorConsumido = valor;
        valor = null;
        System.out.println("Consumido: " + valorConsumido);
        notify();
        return valorConsumido;
    }
}
