 

import java.util.TreeSet;
/**
 * Catalogo de Produtos onde estão guardados todos os códigos dos Produtos existentes
 * 
 */ 
public class CatalogoProdutos {
    TreeSet<String> produtos;
/**
 * Construtor vazio;
 */
    public CatalogoProdutos() {
        this.produtos = new TreeSet<>();
    }
/**
 * Construtor de Cópia
 * @param a Catalogo de Produtos;
 */
    public CatalogoProdutos(CatalogoProdutos a) {
        this.produtos = a.getProdutos();
    }
/**
 * Construtor parametrizado
 * @param prod conjunto onde estão contido os códigos dos produtos;
 */
    public CatalogoProdutos(TreeSet<String> prod) {
        for(String q: prod){
            this.produtos.add(q);
        }
    }
    /**
     * Vai insererir um produto no Catalogo;
     * @param prod código do produto;
     */
    public void insereProduto(String prod) {
        this.produtos.add(prod);
    }
    /**
     * Procura se o produto dado já existe no catalogo;
     * @param prod Código do produto;
     * @return true se existir e false caso não exista;
     */
    public boolean procura (String prod){
        return this.produtos.contains(prod);
    }
    /**
     * Retorna uma copia do catalogo de Produtos;
     * @return cópida do catalogo de produtos;
     */
    public TreeSet<String> getProdutos() {
            TreeSet<String> arvore = new TreeSet<>();
            for (String b : produtos) {
                arvore.add(b);
            }
        return arvore;
    }
    /**
    *Devolve uma cópia do objecto;
    *@return de uma cópia do objecto;
    */
    public CatalogoProdutos clone(){
        return new CatalogoProdutos(this);
    }
    /**
     * Pega em todos os produtos contidos no catálogo e transforma-os numa string gigante contendo os produtos todos;
     * @return String com os elementos todos do catálogo;
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(String e: produtos){
            builder.append(e);
            builder.append("\n");
        }
        return builder.toString();
    }
}
