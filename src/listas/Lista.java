 package listas;

/**
 *
 * @author vick08bv
 */
public class Lista {
    
    
    private Casilla primero;
    private int longitud;
    

    public Lista() {
        
        this.primero = null;
        this.longitud = 0;
        
    }
    
    
    public void inserta(Casilla elemento, int pos){
    
        if (elemento == null){
            return;
        }
        
        if(this.isVacia()){
            
            if(pos == 1){
            
                this.primero = elemento;
                this.longitud++;
            
            } else {
        
                return;
        
            }
            
        }
            
        if(pos > this.getLongitud() || pos < 1){
        
            return;
        
        }
        
        Casilla aux = this.primero;
        
        for (int i = 1; i < pos - 1; i++){
        
            aux = aux.getSig();
        
        }
        
        elemento.setSig(aux.getSig());
        aux.setSig(elemento);
        this.longitud++;
            
    }

    public void suprime(int pos){
    
        if(this.isVacia()){
    
            System.out.println("La lista está vacía");
            return;
            
        }
        
        if(pos > this.longitud || pos < 1){
        
            System.out.println("Posición errónea");
            return;
            
        }
        
        Casilla aux = this.primero;
        
        for (int i = 1; i < pos - 2; i++){
        
            aux = aux.getSig();
        
        }
        
        aux.setSig(aux.getSig().getSig());
    
    }
    
    public int localiza(char caracter){
        
        if(this.isVacia()){
        
            return -1;

            
        }
        
        int indice = 1;
        
        Casilla aux = this.primero;
        
        while(aux != null && aux.getInfo()!= caracter){
        
            aux = aux.getSig();
            indice++;
        
        }

        if(aux == null){
        
            return -1;
            
        } else {
            
            return indice;
            
        }   
        
    }
    
    public int recupera(char caracter){
        
        if(this.isVacia()){
        
            return -1;

            
        }
        
        int indice = 1;
        
        Casilla aux = this.primero;
        
        while(aux != null && aux.getInfo()!= caracter){
        
            aux = aux.getSig();
            indice++;
        
        }

        if(aux == null){
        
            return -1;
            
        } else {
            
            return indice;
            
        }   
        
    }
    
    
    public void anula(){
    
        this.primero = null;
    
    }
    
    
    public int getLongitud(){
    
        return this.longitud;
    
    }
    
    
    public boolean isVacia(){
    
        return this.primero == null;
    
    }
    

    @Override
    public String toString(){
    
        Casilla aux = this.primero;
        
        String salida = "";
            
        while(aux != null){
            
            salida += aux.getInfo();
            aux = aux.getSig();
            
        }
        
        if ("".equals(salida)){
        
            return "Es vacia";
    
        }
    
        return salida;
        
    }

    
    
    
}
