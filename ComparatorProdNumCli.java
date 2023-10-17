package li;

import java.io.Serializable;
import java.util.Comparator;
/**
  * Comparator da classe ParProdNumClientes, que ordena por ordem decrescente de unidades.
  */
public class ComparatorProdNumCli implements Serializable,Comparator<ParProdNumClientes> {
	/**
          * Compara as unidades e o codigo de um (ParProdNumClientes com outro (ParProdNumClientes.
          * @param a ParCodigoUnidades.
          * @param b ParCodigoUnidades.
          * @return 1 se as unidades de a sao maiores que o b, 0 se as unidades de a sao menores ou iguais que b.
   	  */
	public int compare(ParProdNumClientes e1,ParProdNumClientes e2){
		if (e1.getUnidades()-e2.getUnidades()==0) return 1;
		else return (e2.getUnidades()-e1.getUnidades());
	}
}
