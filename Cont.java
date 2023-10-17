package li;

import java.util.ArrayList;
/**
 * Classe cont, guarda os dados monetários de um dado Produto; 
 * 
 */  
public class Cont
{
	private String codigo;
	private ArrayList<Facturacao> meses;
    /**
      * Cria um cont vazio.
      */
    public Cont (){
        int i;
        this.codigo="";
        Facturacao m = new Facturacao();
        this.meses = new ArrayList<>();
        for(i=0;i<12;i++){
           meses.add(m.clone());
        }
    }
    /**
      * Retorna uma Faturacao, recebendo um mes.
      * @param mes mes.
      * @param Faturacao com a venda desse mes do produto.
     */
    public Facturacao getFacturacaoMensal(int mes){
        return this.meses.get(mes-1).clone();
    }
    /**
      * Cria um cont que com os parametros recebidos.
      * @param codigo cogido do produto.
      * @param meses ArrayList que vai ter as vendas em cada mes do produto.
      */
    public Cont (String codigo, ArrayList<Facturacao> meses ){
        this.codigo=codigo;
        for(Facturacao a : meses){
            this.meses.add(a.clone());
        }
    }
   /**
     * Cria um cont com os parametros recebidos.
     * @param codigo codigo do produto.
     * @param mes mes.
     * @param vendasN numero de vendas normais.
     * @param vendasP numero de vendas em promocao.
     * @param facturacaoN faturacao normal.
     * @param facturacaoP faturacao promocional.
     */
    public Cont (String codigo, int mes, int vendasN, int vendasP, double facturacaoN, double facturacaoP ){
        this.codigo=codigo;
        Facturacao m = new Facturacao();
        this.meses = new ArrayList<>();
        int i;
        for(i=0;i<12;i++){
           if(i==(mes-1)){
                meses.add(new Facturacao(vendasN, vendasP, facturacaoN, facturacaoP));
           }
           meses.add(m.clone());
        }
    }
    /**
      * Cria um cont que é uma copia do cont recebido.
      * @param e cont que vai ser copiado.
     */
    public Cont (Cont a){
        this.codigo=a.getCodigo();
        this.meses=a.getFacturacao();
    }
    /**
      * Adiciona as vendas e a faturacao no mes dado.
      * @param codigo codigo do produto.
      * @param mes mes.
      * @param vendasN numero de vendas normais.
      * @param vendasP numero de vendas em promocao.
      * @param preco preco do produto.
      */
    public void adicionaNoMes(String produto,int mes,int vendasN, int vendasP, float preco){
        if(vendasN==0){
            this.meses.get(mes-1).addVendasP(vendasP);
            this.meses.get(mes-1).addFacturacaoP(vendasP,preco);
        }
        else{
            this.meses.get(mes-1).addVendasN(vendasN);
            this.meses.get(mes-1).addFacturacaoN(vendasN,preco);
        }
    }
    /**
      * Retorna um ArrayList com a faturacao do produdo em cada mes.
      * @param ArrayList com os meses todos com a susa faturacao.
      */
    public ArrayList<Facturacao> getFacturacao(){
        ArrayList<Facturacao> novo = new ArrayList<>();
        for(Facturacao e: this.meses){
            novo.add(e.clone());
        }
        return novo;
    }
    /**
      * Retorna o codigo do produto
      * @return String com o codigo do produto.
      */
    public String getCodigo(){
        return this.codigo;
    }
    /**
      * Retorna uma string representativa da contabilidade.
      * @return String representativa da contabilidade.
      */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Produto: ");
        builder.append(codigo);
        int i=1;
        for(Facturacao e :meses){
           builder.append("\nMes "+ i+"\n");
           builder.append(e.toString()); 
           i++;
           if(i==13) break;
        }
        return builder.toString();
    }
    /**
      * Retorna uma copia deste cont.
      * @return copia deste cont.
      */
    public Cont clone(){
        return new Cont(this);
    }
}