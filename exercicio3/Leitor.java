package exercicio3;

public class Leitor implements Runnable{
    ArrayListThreadSafe lista;
    
    public Leitor(ArrayListThreadSafe lista){
        this.lista = lista;
    }

    @Override
    public void run() {
        lista.ler((int) Thread.currentThread().getId());
    }
    
}
