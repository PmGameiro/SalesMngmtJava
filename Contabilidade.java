package li;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe Contabilidade que associa um produto e as suas informações monetárias;
 * 
 */ 
public class Contabilidade
{
	private HashMap<String,Cont> contabilidade;
    /**
     * Cria um contabilidade vazio.
     */
    public Contabilidade() {
        this.contabilidade=new HashMap<>();
    }
    /**
     * Cria um contabilidade que é uma copia do contabilidade recebido.
     * @param e contabilidade que vai ser copiado.
    */
    public Contabilidade(Contabilidade a) {
        this.contabilidade = a.getContabilidade();
    }
    /**
     * Retorna um map com os codigos dos clientes com as compras de cada um
     * @return map codigos de clientes e compras de cada um.
     */
    public HashMap<String,Cont> getContabilidade() {
        HashMap<String,Cont> l= new HashMap<>();
        Set<Map.Entry<String,Cont>> m = this.contabilidade.entrySet();
        Iterator<Map.Entry<String,Cont>> i = m.iterator();
        while(i.hasNext()) {
                Map.Entry<String,Cont> p=i.next();
                l.put(p.getKey(),p.getValue().clone());
        }
        return l;
    }
    /**
      * Retorna uma string representativa da contabilidade.
      * @return String representativa da contabilidade.
      */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Set<Map.Entry<String,Cont>> m = this.contabilidade.entrySet();
        Iterator<Map.Entry<String,Cont>> i = m.iterator();
        while(i.hasNext()) {
                Map.Entry<String,Cont> p=i.next();
                builder.append(p.getValue().toString()+"\n");
        }
        System.out.println(contabilidade.get("LA3373"));
        return builder.toString();
    } 
   /**
     * Procura se o produto existe.
     * @param produto codigo do produto.
     * @return boolean que da true se existe o produto e false se não.
     */
    public boolean procuraProduto (String produto){
        return this.contabilidade.containsKey(produto);
    }
   /**
     * Retorna uma copia deste contabilidade.
     * @return copia deste contabilidade.
     */
    public Contabilidade clone() {
        return new Contabilidade(this);
    }
    /**
     * Insere na contabilidade uma compra efetuada.
     * @param prod codigo do produto.
     * @param preco preco do produto.
     * @param unidades quantidade do produto comprado.
     * @param mes mes em que foi comprado.
     */
    public void insereContabilidade(Compra n){
          Cont conta = this.contabilidade.get(n.getProduto());
          try{
               if(n.getTag().equals("N")) conta.adicionaNoMes(n.getProduto(),n.getMes(),n.getUnidades(),0,n.getPreco());
               else conta.adicionaNoMes(n.getProduto(),n.getMes(),0,n.getUnidades(),n.getPreco());
          }
          catch(NullPointerException e){
                if(n.getTag().equals("N")) this.contabilidade.put(n.getProduto(),new Cont(n.getProduto(),n.getMes(),n.getUnidades(),0,n.getUnidades()*n.getPreco(),0));
                else this.contabilidade.put(n.getProduto(),new Cont(n.getProduto(),n.getMes(),0,n.getUnidades(),0,n.getUnidades()*n.getPreco()));
          }
    }
}