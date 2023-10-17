package li;

import java.util.HashMap;
import java.lang.String;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

/**
 * Classe Compras que associa um cliente e as suas compras;
 * 
 */ 

public class Compras {
    private HashMap<String,ComprasDoCliente> compras;
    /**
     * Construtor Vazio;
     */
    public Compras() {
        this.compras=new HashMap<>();
    }
    /**
     * Contrutor de Cópia;
     * @param a objecto de cópia;
     */
    public Compras(Compras a) {
        this.compras = a.getCompras();
    }
    /**
     * Retorna uma cópia das compras;
     * @return cópia das compras;
     */
    public HashMap<String,ComprasDoCliente> getCompras() {
        HashMap<String,ComprasDoCliente> l= new HashMap<>();
        Set<Map.Entry<String,ComprasDoCliente>> m = this.compras.entrySet();
        Iterator<Map.Entry<String,ComprasDoCliente>> i = m.iterator();
        while(i.hasNext()) {
                Map.Entry<String,ComprasDoCliente> p=i.next();
                l.put(p.getKey(),p.getValue().clone());
        }
        return l;
    }
    /**
     * Vai averiguar se um cliente existe;
     * @param produto código do cliente;
     * @return booleano, indicado true se o cliente existe;
     */
    public boolean procuraCliente (String produto){
        return this.compras.containsKey(produto);
    }   
    /**
     * Cria o clone do objecto
     * @return a cópia do objecto;
     */
    public Compras clone() {
        return new Compras(this);
    }
    /**
     * Adiciona uma compra;
     * @param prod código do produto;
     * @param preco preço do produto;
     * @param unidades numero de unidades compradas;
     * @param tag tipo da compra;
     * @param cli código do cliente
     * @param mes mes em que foi feita a compra;
     */
    public void insereCompra(Compra a){
        try {  
            this.compras.get(a.getCliente()).addCompra(a.clone());
        }
        catch(NullPointerException e) {
            this.compras.put(a.getCliente(),new ComprasDoCliente(a.clone()));
        }
    }
    /**
     * Vai gerar uma String com as informações todas do objecto;
     * @return string com as informações do objecto;
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Set<Map.Entry<String,ComprasDoCliente>> m = this.compras.entrySet();
        Iterator<Map.Entry<String,ComprasDoCliente>> i = m.iterator();
        while(i.hasNext()) {
                Map.Entry<String,ComprasDoCliente> p=i.next();
                builder.append(p.getValue().toString()+"\n");
        }
        return builder.toString();
    }   
}