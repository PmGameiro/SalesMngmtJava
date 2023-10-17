 

import java.util.TreeSet;
/**
 * Classe CatalogoClientes onde estão guardados todos os códigos dos Clientes
 * 
 */ 


public class CatalogoClientes {
    TreeSet<String> clientes;
    /**
     * Construtor Vazio;
     */
    public CatalogoClientes() {
        this.clientes = new TreeSet<>();
    }
    /**
     * Construtor de cópia;
     * @param a Catálogo de Clientes fornecido para cópia;
     */
    public CatalogoClientes(CatalogoClientes a) {
        this.clientes = a.getClientes();
    }
    /**
     * Construtor parametrizado;
     * @param cli Todos os códigos de Clientes a seram inseridos no catálogo;
     */
    public CatalogoClientes(TreeSet<String> cli) {
        for(String h: cli){
         this.clientes.add(h);
        }
    }
    /**
     * Vai inserir um cliente no catálogo;
     * @param cli Código do cliente a ser inserido;
     */
    public void insereCliente(String cli) {
        this.clientes.add(cli);
    }
    /**
     * Vai procurar se o cliente já existe no catálogo;
     * @param cli código do cliente;
     * @return true se existir e false caso o código não exista;
     */
    public boolean procura(String cli){
        return this.clientes.contains(cli);
    }
    /**
     * Devolve uma cópia do Catálogo de Clientes;
     * @return cópia do catálogo de Clientes;
     */
    public TreeSet<String> getClientes() {
            TreeSet<String> arvore = new TreeSet<>();
            for (String b : clientes) {
                arvore.add(b);
            }
        return arvore;
    }
    /**
    *Cria uma cópia do objecto;
    *@return de uma cópia do objecto;
    */
    public CatalogoClientes clone(){
        return new CatalogoClientes(this);
    }
    /**
     * Vai pegar no Catálogo e comprimi-lo todo para uma String;
     * @return String que contem todos os clientes contidos no catálogo;
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(String e: clientes){
            builder.append(e);
            builder.append("\n");
        }
        return builder.toString();
    }
}
