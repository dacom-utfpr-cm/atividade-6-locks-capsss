package exercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SharedFifoQueue {
    int fila[];
    int cont;
    ReentrantLock lock;
    Condition filaCheia;
    Condition filaVazia;
 
    
    public SharedFifoQueue(int tamanhoFila, ReentrantLock lock){
        this.fila = new int[tamanhoFila];
        this.cont = 0;
        this.lock = lock;
        this.filaCheia = lock.newCondition();
        this.filaVazia = lock.newCondition();
    }
    
    public void produzir(int valor, int id){
        System.out.println("produtor: " + id + " esperando o lock");
        lock.lock();
        System.out.println("produtor: " + id + " conseguiu o lock");
        try {
            while(cont == (fila.length) ){
                try {
                    System.out.println("produtor: " + id + " esperando um lugar livre na fila");
                    filaCheia.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SharedFifoQueue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fila[cont++] = valor;
            System.out.println("produtor: " + id + " produziu, sinalizando que a fila nao esta vazia...");
            filaVazia.signal();
        
        } finally {
            System.out.println("produtor: " + id + " liberando o lock");
            lock.unlock();
        }
        
        
    }
    
    public int consumir(int id){
        int retornar = 0;
        System.out.println("consumidor: " + id + " esperando o lock");
        lock.lock();
        System.out.println("consumidor: " + id + " conseguiu o lock");
        try {
            while(cont == 0){
                try {
                    System.out.println("consumidor: " + id + " esperando ter algo na fila");
                    filaVazia.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SharedFifoQueue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            retornar = fila[--cont];
            System.out.println("consumidor: " + id + " consumiu, sinalizando que a fila nao esta cheia...");
            filaCheia.signal();
        
        } finally {
            System.out.println("consumidor: " + id + " liberando o lock");
            lock.unlock();
        }

        return retornar;
    }
}
