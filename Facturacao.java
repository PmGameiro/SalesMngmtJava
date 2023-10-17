package li;

import java.util.Arrays;
/**
 * Classe Facturacao, guarda a informação monetária e estatistica de um Produto;
 * 
 */ 
public class Facturacao {
	private int vendasN;
	private int vendasP;
	private double facturacaoN;
	private double facturacaoP;
    /**
      * Cria um Facturacao vazio.
      */	
    public Facturacao(){
       this.vendasN=0;
       this.vendasP=0;
       this.facturacaoN=0;
       this.facturacaoP=0;
    }
    /**
      * Cria uma facturacao com os parametros recebidos.
      * @param vendasN numero de vendas normais.
      * @param vendasP numero de vendas em promocao.
      * @param facturacaoN faturacao normal.
      * @param facturacaoP faturacao promocional.
      */
    public Facturacao(int vendasN, int vendasP, double facturacaoN, double facturacaoP){
       this.vendasN=vendasN;
       this.vendasP=vendasP;
       this.facturacaoN=facturacaoN;
       this.facturacaoP=facturacaoP;
    }
    /**
      * Cria uma faturacao que é uma copia da faturacao recebida.
      * @param e facturacao que vai ser copiado.
      */
    public Facturacao( Facturacao e){
       this.vendasN=e.getVendasN();
       this.vendasP=e.getVendasP();
       this.facturacaoN=e.getFacturacaoN();
       this.facturacaoP=e.getFacturacaoP();
    }
    /**
      * Retorna as vendasN.
      * @return o numero de vendasN.
      */
   public int getVendasN(){
       return this.vendasN;
    }
    /**
      * Retorna as vendasP.
      * @return o numero de vendasP.
      */
    public int getVendasP(){
       return this.vendasP;
    }
    /**
      * Retorna a faturacaoN.
      * @return a faturacaoN.
      */
    public double getFacturacaoN(){
       return this.facturacaoN;
    }
    /**
      * Retorna a faturacaoP.
      * @return a faturacaoP.
      */
    public double getFacturacaoP(){
       return this.facturacaoP;
    }
    /**
      * Aumenta o vendasN somando o parametro recebido.
      * @param vendasN numero de vendasN.
      */
    public void addVendasN(int vendasN){
       this.vendasN+= vendasN;
    }
    /**
      * Aumenta o vendasP somando o parametro recebido.
      * @param vendasP numero de vendasP.
      */
    public void addVendasP(int vendasP){
       this.vendasP+= vendasP;
    }
    /**
      * Aumenta a faturacaoN somando o parametro recebido.
      * @param vendasN numero de vendasN.
      * @param preco preco.
      */
    public void addFacturacaoN(int vendasN, float preco){
       this.facturacaoN+= vendasN*preco;
    }
    /**
      * Aumenta a facturacao somando o parametro recebido.
      * @param vendasP numero de vendasN.
      * @param preco preco.
      */
    public void addFacturacaoP(int vendasP, float preco){
       this.facturacaoP+= vendasP*preco;
    }
    /**
      * Gera um codigo.
      * @return o codigo gerado.
      */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{vendasN,vendasP,facturacaoN,facturacaoP});
    }
    /**
      * Retorna uma string representativa da contabilidade.
      * @return String representativa da contabilidade.
      */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("VendasN: ");
        builder.append(vendasN);
        builder.append("\tVendasP: ");
        builder.append(vendasP);
        builder.append("\tFacturacaoN: ");
        builder.append(facturacaoN);
        builder.append("\tFacturacaoP: ");
        builder.append(facturacaoP);
        return builder.toString();
    }
    /**
      * Retorna uma copia desta faturacao.
      * @return copia desta faturacao.
      */
    public Facturacao clone() {
        return new Facturacao(this);
    }
    /**
      * Troca o valor das vendasN pelo parametro recebido.
      * @param vendasN numero de vendasN.
      */
    public void setVendasN(int vendasN) {
	this.vendasN = vendasN;
    }
    /**
      * Troca o valor das vendasP pelo parametro recebido.
      * @param vendasP numero de vendasP.
      */
    public void setVendasP(int vendasP) {
	this.vendasP = vendasP;
    }
    /**
      * Troca o valor da facturacaoN pelo parametro recebido.
      * @param facturacaoN numero de facturacaoN. 
      */
    public void setFacturacaoN(double facturacaoN) {
	this.facturacaoN = facturacaoN;
    }
    /**
      * Troca o valor da facturacaoP pelo parametro recebido.
      * @param facturacaoP numero de facturacaoP. 
      */
    public void setFacturacaoP(double facturacaoP) {
	this.facturacaoP = facturacaoP;
    }
}