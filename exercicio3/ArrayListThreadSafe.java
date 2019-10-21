package exercicio3;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListThreadSafe {
    ReentrantReadWriteLock lock;
    ArrayList<String> lista;
    
    public ArrayListThreadSafe(ReentrantReadWriteLock lock){
        this.lista = new ArrayList();
        this.lock = lock;
    }
    
    public void escrever(String s, int id){
        System.out.println("produtor " + id + " esperando o lock");
        lock.writeLock().lock();
        System.out.println("produtor " + id + " conseguiu o lock");
        try {
            System.out.println("produtor " + id + " produziu: " + s);
            lista.add(s);
        } finally {
            System.out.println("produtor " + id + " liberando o lock");
            lock.writeLock().unlock();
        }
    }
    
    public void ler(int id){
        System.out.println("leitor " + id + " esperando o lock");
        lock.readLock().lock();
        System.out.println("leitor " + id + " conseguiu o lock");
        try {
            System.out.println("leitor " + id + " leu: " + lista);
        } finally {
            System.out.println("leitor " + id + " liberando o lock");
            lock. readLock().unlock();
        }
    }
}
