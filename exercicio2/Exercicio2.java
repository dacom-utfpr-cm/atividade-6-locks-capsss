/*
 * Carlos Alexandre Peron dos Santos
 * 
 * Crie uma classe SharedFifoQueue e use Conditions para controlar se a fila está vazia ou cheia.
 * Teste usando threads produtoras e consumidoras.
 */
package exercicio2;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio2 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        int tamanho = 3;
        SharedFifoQueue fila = new SharedFifoQueue(tamanho, lock);
        
        Thread t;
        
        //criando um consumidor -> fila vazia, vai ficar esperando
        t = new Thread(new Consumidor(fila));
        t.start();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //criando 5 produtores -> 1 deles vai ficar esperando
        for(int i=0; i<5; i++){
            t = new Thread(new Produtor(fila));
            t.start();
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //criando 4 consumidores -> vai ficar tudo certo
        for(int i=0; i<4; i++){
            t = new Thread(new Consumidor(fila));
            t.start();
        }
    }
    
}
