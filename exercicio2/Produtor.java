package exercicio2;

public class Produtor implements Runnable{
    SharedFifoQueue fila;
    
    public Produtor(SharedFifoQueue fila){
        this.fila = fila;
    }

    @Override
    public void run() {
        fila.produzir(9, (int) Thread.currentThread().getId());
    }
    
}
