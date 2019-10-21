package exercicio1;

public class Contador {
    Inteiro contador;
    
    public Contador(Inteiro contador){
       this.contador = contador;
    }
    
    public int incrementar(){
        return ++this.contador.contador;
    }
    
    public int decrementar(){
        return --this.contador.contador;
    }
}
