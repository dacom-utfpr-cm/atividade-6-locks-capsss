package exercicio2;

public class Consumidor implements Runnable{
    SharedFifoQueue fila;
    
    public Consumidor(SharedFifoQueue fila){
        this.fila = fila;
    }

    @Override
    public void run() {
        int lixo = fila.consumir((int) Thread.currentThread().getId());
    }
}
