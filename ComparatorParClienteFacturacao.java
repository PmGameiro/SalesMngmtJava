package li;

import java.util.Comparator;
import java.io.Serializable;
/**
  * Comparator da classe ParClienteFacturacao, que ordena por ordem decrescente de nvezes, caso sejam iguais ordena por ordem decrescente também o cliente.
  */
public class ComparatorParClienteFacturacao implements Comparator<ParClienteFacturacao>, Serializable{
   /**
   *Compara as unidades e o codigo de um ParClienteFacturacao com outro ParClienteFactoracao;
   *@param a objecto a que vai ser comparado com b;
   *@param b objecto b que vai ser comparado com a;
   *@return vai devolver 1 se b tiver mais unidades vendidas que a, caso tenham o mesmo número vai comparar o código do cliente de a com o cliente de b, se a tiver mais unidades devolve -1;
   */
	public int compare (ParClienteFacturacao a, ParClienteFacturacao b){
	       if(a.getNVezes()<b.getNVezes()) return 1;
	       else{
	           if(a.getNVezes()==b.getNVezes()){
	               return a.getCliente().compareTo(b.getCliente());
	           }
	           else return -1;
	       }
	    }
}