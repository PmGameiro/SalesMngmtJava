package li;

import java.util.TreeSet;
/**
 * Classe ParClienteFacturacao, guarda a infroma��o relativa a actividade de um Cliente em real��o a um dado produto;
 * 
 */ 
public class ParClienteFacturacao {
    String cliente;
    int nvezes;
    float factoracao;
     /**
     *Construtor parametrizado;
     *@param nvezes n�mero de unidades que o cliente comprou do produto;
     *@param factoracao quanto o cliente gastou neste produto;
     *@param cli c�digo do Cliente;
     */
    public ParClienteFacturacao (int nvezes,float factoracao, String cli){
        this.cliente=cli;
        this.nvezes=nvezes;
        this.factoracao=factoracao;
    }
    /**
    *Construtor de c�pia;
    *@param e objecto que vai ser copiado;
    */
    public ParClienteFacturacao (ParClienteFacturacao e){
        this.cliente=e.getCliente();
        this.nvezes=e.getNVezes();
        this.factoracao=e.getFactoracao();
    }
    /**
    *Retorna o c�digo do cliente;
    *@return devole o c�digo do cliente;
    */
    public String getCliente(){return this.cliente;}
    /**
    *Retorna o n�mero de unidades que o cliente comprou do produto;
    *@return n�mero de unidades que o cliente comprou do produto;
    */
    public int getNVezes(){return this.nvezes;}
    /**
    *Devolve quanto o cliente gastou com este produto;
    *@return quando o cliente gastou com este produto;
    */
    public float getFactoracao(){return this.factoracao;}
    /**
    *Adiciona ao total gasto no produto, uma nova compra;
    *@param factoracao quanto se gastou na nova compra;
    */
    public void addFactoracao(float factoracao){this.factoracao += factoracao;}
    /**
    *Adiciona ao total de unidades compradas, uma nova compra;
    *@param unidades unidades compradas;
    */
    public void addNvezes(int unidades){this.nvezes += unidades;}
    /**
    *Vai verificar se o Cliente j� comprou este produto ou n�o;
    *@param clientes Clientes que compraram este produto;
    *@return booleano, indicando true se o cliente j� comprou este produto e false em caso contr�rio;
    */
    public boolean checkClient(TreeSet<ParClienteFacturacao> clientes){
        for(ParClienteFacturacao a: clientes){
            if(a.getCliente().equals(this.cliente)) return true;
        }
        return false;
    }
    /**
    *Gera uma String com a informa��o toda do objecto;
    *@return String com a informa��o do objecto;
    */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Cliente "+cliente);
        builder.append(" comprou "+nvezes);
        builder.append(" unidades do produto    Total facturado: "+factora��o);
        return builder.toString();
    }
    /**
    * Cria uma c�pia do objecto;
    *@return C�pia do Objecto;
    */
    public ParClienteFacturacao clone(){
        return new ParClienteFacturacao(this);
    }
}
