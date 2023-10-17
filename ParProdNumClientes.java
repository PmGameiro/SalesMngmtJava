package li;

/**
 * Classe ParProdNumCliente, guarda um código do Produto, os Clientes que compraram esse produto e o total unidades compradas
 * 
 */ 
import java.util.Arrays;
import java.util.TreeSet;

public class ParProdNumClientes {
	private String produto;
	private TreeSet<String> clientes;
	private int unidades;
	/**
      	  * Retorna o codigo do produto.
      	  * @return codigo do produto.
      	  */
	public String getProduto() {
		return produto;
	}
	/**
      	  * Retorna o um conjunto com os clientes.
      	  * @return conjunto com os clientes.
      	  */
	public TreeSet<String> getClientes() {
		TreeSet<String> novo= new TreeSet<>();
		for (String e: this.clientes)
			novo.add(e);
		return novo;
	}
        /**
          * Vai trocar o codigo.
          * @param produto codigo de produto.
          */
	public void setProduto(String produto) {
		this.produto = produto;
	}
        /**
          * Vai adicionar conjunto clientes o cliente que recebeu.
          * @param cliente cliente.
          */
	public void addCliente(String cliente) {
		this.clientes.add(cliente);
	}
	/**
	  * Cria um ParProdNumCliente vazio
	  */
	public ParProdNumClientes() {
		produto="";
		clientes=new TreeSet<>(); 
		unidades=0;
	}
	/**
	  * Gera um codigo.
	  * @return o codigo gerado.
	  */
	public int hashCode() {
        return Arrays.hashCode(new Object[]{produto,clientes,unidades});
        }
	/**
          * Cria um ParCodigoUnidades com os parametros recebidos.
          * @param produto codigo de produto.
          * @param cliente codigo de cliente.
          * @param unidades unidades.
          */
	public ParProdNumClientes(String produto,String cliente, int unidades) {
		this.produto = produto;
		this.clientes = new TreeSet<>();
		this.clientes.add(cliente);
		this.unidades=unidades;
	}
	/**
          * Cria um ParProdNumClientesque é uma copia do ParProdNumClientesrecebido.
          * @param e ParProdNumClientesque vai ser copiado.
      	  */
	public ParProdNumClientes(ParProdNumClientes e) {
		this.produto = e.getProduto();
		this.clientes = e.getClientes();
		this.unidades=e.getUnidades();
	}
	/**
          * Retorna as unidades.
          * @return int com as unidades.
          */
	public int getUnidades() {
		return this.unidades;
	}
	/**
          * Vai adicionar as unidades ao parametro recebido.
          * @param unidades unidades;
          */
	public void addUnidades(int unidades){
		this.unidades+=unidades;
	}
	/**
          * Vai trocar as unidades.
          * @param unidades unidades.
          */
	public void setUnidades(int unidades) {
		this.unidades=unidades;
	}
        /**
          * Retorna uma copia deste ParProdNumClientes.
          * @return copia deste ParProdNumClientes.
          */
	public ParProdNumClientes clone() {
		return new ParProdNumClientes(this);
	}
	/**
          * Retorna uma string representativa do ParCodigoUnidades.
          * @return String representativa da ParCodigoUnidades.
          */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto: ");
		builder.append(produto);
		builder.append("  Unidades vendidas: ");
		builder.append(unidades);
		builder.append("  Num. de clientes: ");
		builder.append(clientes.size());
		
		return builder.toString();
	}
	/**
    	  * Compara o objeto dado com este conjunto para a igualdade.
     	  * @param obj object ParProdNumClientes.
    	  * @retun     true se o objeto for igual e false se não for.
          */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParProdNumClientes other = (ParProdNumClientes) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (clientes.size()==other.getClientes().size())
			return false;
		if (produto == null) {
			if (other.getProduto() != null)
				return false;
		} else if (!produto.equals(other.getProduto()))
			return false;
		if (unidades != other.getUnidades())
			return false;
		return true;
	}
}
