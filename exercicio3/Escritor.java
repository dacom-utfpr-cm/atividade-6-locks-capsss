package exercicio3;

public class Escritor implements Runnable{
    String s;
    ArrayListThreadSafe lista;
    
    public Escritor(String s, ArrayListThreadSafe lista){
        this.s = s;
        this.lista = lista;
    }

    @Override
    public void run() {
        lista.escrever(s, (int) Thread.currentThread().getId());
    }
    
}