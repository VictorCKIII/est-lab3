import javax.swing.event.ChangeEvent;

public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    // public void removeInicio (){
    //     if (inicio != null)
    //         inicio = inicio.getProximo();
    // }

    // public void removeFim (){
    //     if (inicio == null){
    //         return;
    //     }
    //     if (inicio.getProximo() == null){
    //         inicio = null;
    //     }
    //     removeFim(inicio);
    // }

    // public void removeFim (No n){
    //     No proximo = n.getProximo();
    //     if (proximo.getProximo() == null){
    //         n.setProximo(null);
    //         return;
    //     } else{
    //         removeFim(proximo);
    //     }
    // }

    // public void insereInicio (int valor){
    //     if(inicio == null){
    //         inicio = new No(valor);
    //         return;
    //     }
    //     No n = new No(valor);
    //     n.setProximo(inicio);
    //     inicio = n;

    // }

    // public void insereFim (int valor){
    //     if(inicio == null){
    //         inicio = new No(valor);
    //         return;
    //     }
    //     insere(inicio, valor);
    // }

    // public boolean procura (int valor){
    //     if (inicio == null){
    //         return false;
    //     } else {
    //         return procura(inicio, valor);
    //     }
    // }

    // public boolean procura (No n, int valor){
    //     if (n.getValor() == valor){
    //         return true;
    //     } else if (n.getProximo() == null){
    //         return false;
    //     } else {
    //         return procura(n.getProximo(), valor);
    //     }
    // }
    // public void insere (No n, int valor){
    //     if (n.getProximo() == null){
    //         No novo = new No(valor);
    //         n.setProximo(novo);
    //     } else {
    //         insere(n.getProximo(), valor);
    //     }
    // }

    // public void remover(int valor){
    //     if (inicio == null){
    //         return;
    //     }
    //     if (inicio.getValor() == valor){
    //         inicio = inicio.getProximo();
    //         return;
    //     }
    //     remover(inicio, valor);
    // }

    // public void remover(No n, int valor){
    //     No proximo = n.getProximo();
    //     if (proximo == null){
    //         return;
    //     }
    //     if (proximo.getValor() == valor){
    //         n.setProximo(proximo.getProximo());
    //     } else{
    //         remover(proximo, valor);
    //     }
    // }

    // public static void main(String[] args) {
    //     for (int i = 0; i < 100; i++) {
    //         System.out.println(i);
    //         if (i == 50){
    //             break;
    //         }
    //     }
    //     System.out.println("fim");
    // }

    @Override
    public boolean insert(int chave) {
        if (inicio == null) {
            inicio = new No(chave);
            inicio.setProximo(null);
            return true;
            
        } else {
            insertElse(inicio, chave);
            return true;
        }
    }
    public boolean insertElse(No novo,int chave){
        if(novo.getProximo() == null){
            No no = new No(chave);
            novo.setProximo(no);
            return true;
        }
        else{
            insertElse(novo.getProximo(), chave);
        }
        return false;

    }


    @Override
    public boolean delete(int chave) {
        if(inicio.getValor()==chave){
            inicio=inicio.getProximo();
            return true;
        }
        else{
             
             return deleteElse(inicio, chave);
             

        }
        
        
    }

    public boolean deleteElse(No delete, int chave) {
        No exclui = delete.getProximo();
        if(exclui.getValor() == chave){
            delete.setProximo(exclui.getProximo());
            return true;
            
        }
         else {
            return deleteElse(delete.getProximo(), chave);
        }
    }
    @Override
    public boolean search(int chave) {
        if(inicio == null){
            return false;
        }
        else{
          return searchElse(inicio, chave);
        }   
    }
    public boolean searchElse(No novo, int chave){
        if(novo == null){
            return false;
        }
        if(novo.getValor()== chave){
            return true;
        }
        else{
            return searchElse(novo.getProximo(), chave);
        }
    }
    @Override
    public int minimum() {
        if(inicio == null){
            return 0;
        }
        else{
            int menor = inicio.getValor();
            if(inicio.getProximo() == null){
                return menor;
            }
            else{
                return minimumElse(inicio,menor);
            }

        }

    }
    public int minimumElse(No no,int menor)
    {   int save = menor;
        if(no.getProximo() == null){
            return menor;
        }

        if(no.getProximo().getValor() < save ){
            save=no.getProximo().getValor();
        
        }
        
            
            return minimumElse(no.getProximo(),save); 
    }

    @Override
    public int maximum() {
        if(inicio == null){
            return 0;
        }
        else{
            int maior = inicio.getValor();
            if(inicio.getProximo() == null){
                return maior;
            }
            else{
                return maximumElse(inicio,maior);
            }

        }
    }
    public int maximumElse(No no , int maior){
        {   int save = maior;
            if(no.getProximo()== null){
                return save;
            }
            else if(no.getProximo().getValor() > save ){ 
                 save=no.getProximo().getValor();
            
            }
                return maximumElse(no.getProximo(),save); 
        }
    }
    @Override
    public int sucessor(int chave) {
        if(inicio == null){
            return 0;
        }
        else if(inicio.getValor() == chave){
            return inicio.getProximo().getValor();
        }
        else{
            return sucessorElse(inicio, chave);
        }
    }
    public int sucessorElse(No no, int chave){
        if(no.getProximo() == null){
            return 0;
        }
        else if(no.getValor() == chave){  
            return no.getProximo().getValor();

        }
            return sucessorElse(no.getProximo(), chave);
        
    }

    @Override
    public int prodessor(int chave) {
        if(inicio == null || inicio.getValor() == chave){
            return -1;
        }
        else if(inicio.getProximo().getValor() == chave){
            return inicio.getValor();
        }
        else{
            return prodessorElse(inicio, chave);
        }

        }
    public int prodessorElse(No no, int chave){
        if(no.getProximo() == null){
            return no.getValor();
        }
        else if(no.getProximo().getValor() == chave){
            return no.getValor();
        }
            return prodessorElse(no.getProximo(), chave);
    }
    
    
    public static void main(String[] args) {
        ListaLigada list = new ListaLigada();
        System.out.println(list.insert(1));
        System.out.println(list.insert(2));
        System.out.println(list.insert(3));
        System.out.println(list.search(4));
        //System.out.println(list.delete(3));
        System.out.println(list.search(3));
        System.out.println(list.minimum());
        System.out.println(list.maximum());
        System.out.println(list.sucessor(2));
        System.out.println(list.prodessor(1));

    }
}
