import classes.Buffer;
import classes.Consumidor;
import classes.Produtor;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        produtor.start();
        consumidor.start();
    }
}