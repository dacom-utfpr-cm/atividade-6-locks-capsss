package exercicio1;

import java.util.concurrent.locks.ReentrantLock;

public class IncrementadorDecrementador implements Runnable{
    ReentrantLock lock;
    int tipo;
    Contador contador;
    
    public IncrementadorDecrementador(ReentrantLock lock, Contador contador, int tipo){
        this.lock = lock;
        this.tipo = tipo;
        this.contador = contador;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " criada, esperando o lock");
        
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId() + " conseguiu o lock, atualizando contador");

            if(tipo == 0){
                System.out.println(Thread.currentThread().getId() + " decrementou: " + contador.decrementar());
            } else {
                System.out.println(Thread.currentThread().getId() + " incrementou: " + contador.incrementar());
            }

            System.out.println(Thread.currentThread().getId() + " terminou, liberando o lock");
        
        } finally {
            lock.unlock();
        }
    }
    
    
}
