package li;

import java.util.Comparator;
import java.io.Serializable;
/**
  * Comparator da classe ParCodigoUnidades que ordena por ordem decrescente de nvezes, caso sejam iguais ordena por ordem decrescente também o cliente.
  */
public class ComparatorParCodigoUnidades implements Comparator<ParCodigoUnidades>, Serializable{
   /**
     * Compara as unidades e o codigo de um ParCodigoUnidades com outro ParCodigoUnidades.
     * @param a ParCodigoUnidades.
     * @param b ParCodigoUnidades.
     * @return 1 se as unidades de a sao maiores que o b, 0 se as unidades de a sao menores que b, caso sejam iguais compara com o codigo.
     */
   public int compare (ParCodigoUnidades a, ParCodigoUnidades b){
       if(a.getUnidades()<b.getUnidades()) return 1;
       else{
           if(a.getUnidades()==b.getUnidades()){
               return a.getCodigo().compareTo(b.getCodigo());
           }
           else return -1;
       }
    }
}