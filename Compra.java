/**
 * Classe compra, guarda os dados de uma Compra válida;
 * 
 */  

public class Compra {
    private String produto;
    private float preco;
    private int unidades;
    private String tag;
    private String cliente;
    private int mes;
    /**
     * contrutor Vazio;
     */
    public Compra() {
        this.produto = "";
        this.preco = 0;
        this.unidades = 0;
        this.mes = 0;
        this.tag="";
        this.cliente="";
    }
    /**
     * Construtor Parametrizado;
     * @param produto código do produto;
     * @param preco preco do produto;
     * @param unidades unidades compradas;
     * @param tag tipo de compra(Normal ou Promoçao);
     * @param cliente código do cliente;
     * @param mes mes em que foi feita a compra;
     */
    public Compra(String produto, float preco,int unidades, String tag, String cliente, int mes){
        this.produto = produto;
        this.preco = preco;
        this.unidades = unidades;
        this.mes = mes;
        this.tag=tag;
        this.cliente=cliente;
    }
    /**
     * Construtor de cópia;
     * @param e Compra a ser copiada;
     */
    public Compra(Compra e) {
        this.produto = e.getProduto();
        this.preco = e.getPreco();
        this.unidades = e.getUnidades();
        this.mes = e.getMes();
        this.tag=e.getTag();
        this.cliente=e.getCliente();
    }
    /**
     * Retorna o tipo da compra;
     * @return o tipo da compra;
     */
    public String getTag(){ return this.tag;}
    /**
     * Retorna o preço do produto comprado;
     * @return o preço do produto comprado;
     */
    public float getPreco(){ return this.preco;}
    /**
     * Retorna o mes em que a compra foi feita;
     * @return mes em que foi feita a compra;
     */
    public int getMes(){ return this.mes;}
    /**
     * Retorna o numero de unidades compradas;
     * @return o numero de unidades compradas;
     */
    public int getUnidades(){ return this.unidades;}
    /**
     * Retorna o código do produto que foi comprado;
     * @return o código do produto comprado;
     */
    public String getProduto() { return this.produto;}
    /**
     * Retorna o código do cliente que fez a compra;
     * @retturn o código do cliente que fez a compra;
     */
    public String getCliente() { return this.cliente;}
    
    //public void setMes (int mes){ this.mes= mes;}
    /**
     * Retorna o código hash do objecto;
     * @return o código hash gerado para o objecto;
     */
    public int hashCode() {
        return this.produto.hashCode()+this.cliente.hashCode()+this.unidades+this.mes+this.tag.hashCode();
    }
    /**
     * Vai verificar se o mês dado é igual ao mês do objecto;
     * @param mes dado como parametro;
     * @return true se forem iguais false se n forem;
     */
    public boolean procuraProdComp(int mes){
        return this.mes==mes;
    }
    /**
     * Retorna o objecto na forma de String
     * @return string que contem a informação toda do objecto;
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(produto);
        builder.append("  "+preco+"€");
        builder.append("  "+unidades);
        builder.append("  "+tag);
        builder.append("  "+cliente);
        builder.append("  "+mes);
        return builder.toString();
    }
    /**
     * Faz o clone do objecto;
     * @return do clone do objecto;
     */
    public Compra clone() {
        return new Compra(this);
    }
}
