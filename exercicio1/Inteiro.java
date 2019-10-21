package exercicio1;

public class Inteiro {
    int contador;
    
    public Inteiro(int valor){
        this.contador = valor;
    }
    
    public void incrementar(){
        this.contador++;
    }
    
    public int get(){
        return this.contador;
    }
}