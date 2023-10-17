 

import java.util.ArrayList;
/**
  * Classe com as compras que um dado cliente efectou.
  */
public class ComprasDoCliente {
    private String cliente;
    private ArrayList<Compra> compras;
    /**
     * Contrutor Vazio;
     */
    public ComprasDoCliente() {
        this.cliente = "";
        this.compras = new ArrayList<>();
    }
    /**
     * Construtor de Cópia
     * @param a objecto que vai ser copiado;
     */
    public ComprasDoCliente(ComprasDoCliente a) {
        this.cliente = a.getCliente();
        this.compras = a.getCompras();
    }
    /**
     * Retorna o código do cliente;
     * @return código do cliente;
     */
    public String getCliente() {return this.cliente;}
    /**
     * Devolve uma cópia das compras feitas;
     * @return de uma cópia das Compras;
     */
    public ArrayList<Compra> getCompras() {
        ArrayList<Compra> novo = new ArrayList<>();
        for (Compra p : compras) {
            novo.add(p.clone());
        }
        return novo;
    }
    /**
     * Contrutor Parametrizado;
     * @param a Compra efetuada
     */
    public ComprasDoCliente(Compra a){
        this.cliente=a.getCliente();
        this.compras = new ArrayList<>();
        this.compras.add(a.clone());
    }
    /**
     * Adiciona uma compra feita pelo cliente;
     * @param x compra feita pelo cliente;
     */
    public void addCompra(Compra x){
        this.compras.add(x.clone());
    }
    /**
     * Alteração do código do cliente;
     * @param k código para o qual o cliente vai ser alterado;
     */
    public void setcliente(String k) {
        this.cliente = k;
    }
    /**
     * Clone do Objecto;
     * @return cópia do objecto;
     */
    public ComprasDoCliente clone() {
        return new ComprasDoCliente(this);
    }
    /**
     * Transfere a informação toda do objecto para um String;
     * @return string contendo a informação do objecto;
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("cliente: ");
        builder.append(cliente);
        for(Compra e : compras){
            builder.append(e.toString()+"\n");
        }
        return builder.toString();
    }
}