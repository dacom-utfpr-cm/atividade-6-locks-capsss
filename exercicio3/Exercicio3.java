/*
 * Carlos Alexandre Peron dos Santos
 * 
 * Faça uma classe ArrayListThreadSafe usando ReadWriteLock. Teste usando threads que realizam leitura e escrita para essa estrutura.
 */
package exercicio3;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Exercicio3 {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
        ArrayListThreadSafe lista = new ArrayListThreadSafe(lock);
        
        Integer cont = 0;
        Thread t;
        
        //criando 1 escritor
        t = new Thread(new Escritor(cont.toString(), lista));
        cont++;
        t.start();
        
        //criando 20 leitores e 10 escritores
        for(int i=0; i<30; i++){
            if(i%3==0){
                t = new Thread(new Escritor(cont.toString(), lista));
                t.start();
                cont++;
            } else {
                t = new Thread(new Leitor(lista));
                t.start();
            }
        }
    }
    
}
