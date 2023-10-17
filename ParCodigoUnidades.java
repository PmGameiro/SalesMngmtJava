package li;

/**
 * Classe ParCodigoUnidades, guarda a infromação relativa a um dado código e as suas unidades;
 * 
 */ 
public class ParCodigoUnidades{
    String codigo;
    int unidades;
    /**
      * Cria um ParCodigoUnidades com os parametros recebidos.
      * @param codigo codigo.
      * @param unidades unidades.
      */
    public ParCodigoUnidades (String codigo,int unidades){
        this.codigo=codigo;
        this.unidades=unidades;
    }
    /**
      * Cria um ParCodigoUnidades que é uma copia do ParCodigoUnidades recebido.
      * @param e ParCodigoUnidades que vai ser copiado.
      */
    public ParCodigoUnidades (ParCodigoUnidades e){
        this.codigo=e.getCodigo();
        this.unidades=e.getUnidades();
    }
    /**
      * Retorna o codigo.
      * @return String com o codigo.
      */
    public String getCodigo(){return this.codigo;}
    /**
      * Retorna as unidades.
      * @return int com as unidades.
      */
    public int getUnidades(){return this.unidades;}
    /**
      * Vai trocar as unidades.
      * @param unidades unidades.
      */
    public void setUnidades(int unidades){this.unidades = unidades;}
    /**
      * Vai trocar o codigo.
      * @param String com o codigo.
      */
    public void setCodigo(String codigo){this.codigo = codigo;}
    /**
      * Vai adicionar as unidades ao parametro recebido.
      * @param unidades unidades;
      */
    public void addUnidades(int unidades){this.unidades += unidades;}
    /**
      * Retorna uma string representativa do ParCodigoUnidades.
      * @return String representativa da ParCodigoUnidades.
      */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("codigo: "+codigo);
        builder.append("     Unidades: "+unidades);
        return builder.toString();
    }
    /**
      * Retorna uma copia deste ParCodigoUnidades.
      * @return copia deste ParCodigoUnidades.
      */
    public ParCodigoUnidades clone(){
        return new ParCodigoUnidades(this);
    }
}