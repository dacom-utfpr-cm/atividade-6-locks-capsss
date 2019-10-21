/*
 * Carlos Alexandre Peron dos Santos
 *
 * Faça um programa usando Lock para simular a atualização de um contador que é acessado por múltiplas threads.
 * O contador pode diminuir e aumentar.
 */
package exercicio1;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Exercicio1 {

    public static void main(String[] args) {
        int quantasThreads = 10;
        
        ReentrantLock lock = new ReentrantLock();
        Inteiro inteiro = new Inteiro(0);
        Contador contador = new Contador(inteiro);
        
        Random r = new Random();
        
        for(int i=0; i<quantasThreads; i++){

            Thread t = new Thread(new IncrementadorDecrementador(lock, contador, r.nextInt(2)));
            t.start();
        }
    }
    
}
