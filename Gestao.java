package li;

import java.io.FileReader;
import java.io.IOException;
import java.lang.System;
import java.lang.String;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.*;
/**
  * Classe Gestora do hipermercado.
  */
public class Gestao {
    private CatalogoClientes catalogoClientes;
    private CatalogoProdutos catalogoProdutos;
    private Contabilidade contabilidade;
    private Compras compras;
    
    
    public Gestao (){
        this.catalogoClientes = new CatalogoClientes();
        this.catalogoProdutos = new CatalogoProdutos();
        this.contabilidade = new Contabilidade();
        this.compras = new Compras();
    }
    /**
      * Retorna as compras.
      */
    public Compras getCompras() {
    	return this.compras.clone();
    }
    /**
      * Retorna a contabilidade.
      */
    public Contabilidade getContabilidade() {
    	return this.contabilidade.clone();
    }
    /**
      * Retorna o catalogo com os clientes.
      */
    public CatalogoClientes getCatalogoClientes() {
    	return this.catalogoClientes.clone();    	
    }
    /**
      * Retorna o catalogo com os produtos.
      */
    public CatalogoProdutos getCatalogoProdutos() {
    	return this.catalogoProdutos.clone();    	
    }
    /**
      * Le os produtos do ficheiro e insere no catalogo dos produtos.
      * @param fich nome do ficheiro.
      */
    public void leituraProdutos(String fich) {
        BufferedReader reader = null;
        try {
            File file = new File(fich);
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                catalogoProdutos.insereProduto(line);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }
    /**
      * Le os clientes do ficheiro e insere no catalogo dos clientes.
      * @param fich nome do ficheiro.
      */
    public void leituraClientes(String fich) {
        BufferedReader reader = null;
        try {
            File file = new File(fich);
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                catalogoClientes.insereCliente(line);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }
    /**
      * Le as compras do ficheiro e insere no catalogo das compras e da contabilidade.
      * @param fich nome do ficheiro.
      */  	
    public ArrayList<Compra> leituraCompras(String fich) {
        int j;
        ArrayList<Compra> comprasInvalidas= new ArrayList<>();
        String help=""; 
        String prod="";
        String cli="";
        float preco=0;
        int unidades=0;
        String tag="";
        int mes=0;
        BufferedReader reader = null;
        try {
            File file = new File(fich);
            reader = new BufferedReader(new FileReader(file));
            while ((help = reader.readLine()) != null) {
                j=1;
                for(String part: help.split(" ",6)){
                    switch (j){
                        case 1:
                            prod=part;
                            break;
                        case 2:
                            preco=Float.parseFloat(part);
                            break;
                        case 3:
                            unidades=Integer.parseInt(part);
                            break;
                        case 4:
                            tag=part;
                            break;
                        case 5:
                            cli=part;
                            break;
                        case 6:
                            mes=Integer.parseInt(part);
                            Compra novo = new Compra(prod,preco,unidades,tag,cli,mes);
                            if(!this.catalogoProdutos.procura(prod) || preco<0 || unidades<0 || !this.catalogoClientes.procura(cli) ||mes<1 || mes >12) comprasInvalidas.add(novo);
                            else{
                                compras.insereCompra(novo);
                                contabilidade.insereContabilidade(novo);
                            }
                            break;
                    }
                    j++;
                }
            }
            //System.out.println(i);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
                System.exit(0);
            }
        }
        return comprasInvalidas;
    }
    /**
      * Devolve um conjunto com os produtos que nunca foram comprados.
      * @return conjunto com os produtos que nunca foram comprados.
      */
    public TreeSet<String> produtosNaoComprados() {
    	TreeSet<String> naoComprados = new TreeSet<>();
    	for (String e : catalogoProdutos.getProdutos()) {
    		if (!contabilidade.procuraProduto(e)) naoComprados.add(e);
    	}
    	return naoComprados;
    }
    /**
      * Devolve um conjunto com os clientes que nada compraram.
      * @return conjunto com os clientes que nada compraram.
      */
    public TreeSet<String> clientesNuncaCompraram() {
    	TreeSet<String> nuncaCompraram = new TreeSet<>();
    	for (String e : catalogoClientes.getClientes()) {
    		if (!compras.procuraCliente(e)) nuncaCompraram.add(e);
    	}
    	return nuncaCompraram;
    }
    /**
      * Retorna uma lista que vai conter de mes a mes quantas vezes um produto foi comprado em modo N e P e respectivas facturacaoes.
      * @param produto codigo de produto.
      * @return lista que vai conter de mes a mes quantas vezes um produto foi comprado em modo N e P e respectivas facturacaoes.
      */
    public ArrayList<Facturacao> quantasVezes(String produto) {
    	ArrayList<Facturacao> res=new ArrayList<>();
    	for(int i=0;i<12;i++) {
    		res.add(new Facturacao());
    	}
    	for(ComprasDoCliente e: this.compras.getCompras().values()){
    		for(Compra a: e.getCompras()) {
    			if (a.getProduto().equals(produto)) {
    				if(a.getTag().equals("N")) {
    					res.get(a.getMes()-1).addFacturacaoN(a.getUnidades(), a.getPreco());
    					res.get(a.getMes()-1).addVendasN(1);
    				}
    				else {
    					res.get(a.getMes()-1).addFacturacaoP(a.getUnidades(), a.getPreco());
    					res.get(a.getMes()-1).addVendasP(1);
    				}
    			}
    		}
    	}
    	return res;
    }
    /**
      * Retorna uma lista com os produtos mais vendidos em todo o ano.
      * @param produto codigo de produto.
      * @return lista com os produtos mais vendidos em todo o ano.
      */
    public ArrayList <ParProdNumClientes> produtosMaisVendidos(int x) {
    	int t=0;
    	ArrayList <ParProdNumClientes> novo = new ArrayList<>();
    	TreeSet<ParProdNumClientes> ordenados= new TreeSet<>(new ComparatorProdNumCli());
    	TreeMap<String,ParProdNumClientes> n= new TreeMap<>();
    	for(ComprasDoCliente e :this.compras.getCompras().values()){
	    	for(Compra a: e.getCompras()){
	    		t=0;
    			if(n.containsKey(a.getProduto())){
    				n.get(a.getProduto()).addUnidades(a.getUnidades());
    				n.get(a.getProduto()).addCliente(a.getCliente());
    				t=1;
	    		}
	    		if(t==0) n.put(a.getProduto(),new ParProdNumClientes(a.getProduto(),a.getCliente(),a.getUnidades()));
	    	}
    	}
    	for(ParProdNumClientes p: n.values()){
    		ordenados.add(p.clone());
    	}
    	int h=0;
    	for(ParProdNumClientes a: ordenados){
    		novo.add(a);
    		h++;
    		if (h==x) break;
    	}
    	return novo;
    }
    /**
      * Retorna a faturacao total da contabilidade.
      */
    public double faturacaoTotal (){
        double faturacaototal=0;
        for(Cont a : this.contabilidade.getContabilidade().values()){
            for(Facturacao b : a.getFacturacao()){
                faturacaototal += b.getFacturacaoN()+b.getFacturacaoP();
            }
        }
        return faturacaototal;
    }
    /**
      * Retorna o total de produtos.
      */
    public int totalProdutos (){return this.catalogoProdutos.getProdutos().size();}
    /**
      * Retorna o total de clientes.
      */
    public int totalClientes (){return this.catalogoClientes.getClientes().size();}
    /**
      * Retorna o numero de produtos diferentes comprados.
      */
    public int totalDifProdComp (){return this.contabilidade.getContabilidade().size();}
    /**
      * Retorna o numero de produtos diferentes comprados.
      */
    public int totalComprasRealizadas (){return this.compras.getCompras().size();}
    /**
      * Retorna o numero de compras que foram oferecidas.
      */
    public int comprasZero() {
        int zero=0;
        for(ComprasDoCliente e : this.compras.getCompras().values()){
            for(Compra a : e.getCompras()){
                if(a.getPreco()==0) zero++;
            }
        }
        return zero;
    }
    /**
      * Procura no compras os códigos de clientes que mais produtos diferentes compraram e quantos.
      * @return ArrayList com os clientes e o numero de produtos diferentes ordenados.
      */
    public  ArrayList<ParCodigoUnidades> NumProdDiferentesPorCli(int x){
        int p=0;
        TreeSet<ParCodigoUnidades> clinumeros = new TreeSet<>(new ComparatorParCodigoUnidades());
        ArrayList<ParCodigoUnidades> codigounidades = new ArrayList<>();
        for(ComprasDoCliente e :this.compras.getCompras().values()){
            TreeSet<String> produtos = new TreeSet<>();
            for(Compra a : e.getCompras()){
                produtos.add(a.getProduto().clone());
            }
            clinumeros.add(new ParCodigoUnidades(e.getCliente(),produtos.size()));
        }
        for(ParCodigoUnidades d : clinumeros){
            codigounidades.add(d.clone());
            p++;
            if(x==p) break;
        }
        return codigounidades;
    }
    /**
      * Através de um codido de cliente e um numero vai procurar nas suas compras os produtos que mais comprou, ordenando.
      * @param cliente codigo de um cliente.
      * @param x numero para saber quantos elementos retornar.
      * @return ArrayList com o produto e o numero de unidades, ordenando.
      */
    public ArrayList<ParCodigoUnidades> listaProdutosMaisComprados(String cliente){
          TreeSet<ParCodigoUnidades> produtos = new TreeSet<>(new ComparatorParCodigoUnidades());
          ArrayList<ParCodigoUnidades> codigounidades = new ArrayList<>();
          int ajuda=0;
          for(Compra a : this.compras.getCompras().get(cliente).getCompras()){
              for(ParCodigoUnidades b : produtos){
                  if(b.getCodigo().equals(a.getProduto())){
                      b.addUnidades(a.getUnidades());
                      ajuda=1;
                      break;
                  }
              }
              if(ajuda==0) produtos.add(new ParCodigoUnidades(a.getProduto(),a.getUnidades()));
          }
          for(ParCodigoUnidades d : produtos){
              codigounidades.add(d.clone());
          }
          return codigounidades;
    }
    /**
      * Retorna lista com o numero de compras de um produto nos 12 meses.
      * @param produto codigo de produto.
      * @return lista com o numero de compras de um produto nos 12 meses.
      */
    public ArrayList<Integer> numCompras(String produto){
    	int t;
    	ArrayList<Integer> n = new ArrayList<>();
    	for(int i=0;i<12;i++) n.add(0);
    	for (ComprasDoCliente a: this.compras.getCompras().values())
    		for (Compra b: a.getCompras())
    			if(b.getProduto().equals(produto)) {
    				t=n.get(b.getMes()-1);
    				t++;
    				n.set(b.getMes()-1, t);
    			}
    	return n;
    }
    /**
      * Retorna lista com o numero de compras dos 12 meses.
      * @return lista com o numero de compras dos 12 meses.
      */
    public ArrayList<Integer> numComprasAnual(){
    	int t;
    	ArrayList<Integer> n = new ArrayList<>();
    	for(int i=0;i<12;i++) n.add(0);
    	for (ComprasDoCliente a: this.compras.getCompras().values())
    		for (Compra b: a.getCompras()){
				t=(n.get(b.getMes()-1))+1;
				n.set(b.getMes()-1, t);
    		}
    	return n;
    }
    /**
      * Retorna lista com o numero de clientes que compraram um determinado produto.
      * @return produto codigo de produto.
      */
    public ArrayList<Integer> ClientesCompraram(String produto){
    	ArrayList<Integer> n = new ArrayList<>();
    	ArrayList<TreeSet<String>> clientes = new ArrayList<>(12);
    	for(int i=0;i<12;i++) clientes.add(new TreeSet<String>());
    	for (ComprasDoCliente a: this.compras.getCompras().values())
    		for (Compra b: a.getCompras())
    			if(b.getProduto().equals(produto)) {
    				clientes.get(b.getMes()-1).add(b.getCliente());
    			}
    	for(int i=0;i<12;i++) n.add(clientes.get(i).size());
    	return n;
    }
    /**
      */
    public ArrayList<Integer> clientesCompraramAnual(){
    	ArrayList<Integer> n = new ArrayList<>();
    	ArrayList<TreeSet<String>> clientes = new ArrayList<>(12);
    	for(int i=0;i<12;i++) clientes.add(new TreeSet<String>());
    	for (ComprasDoCliente a: this.compras.getCompras().values())
    		for (Compra b: a.getCompras())
				clientes.get(b.getMes()-1).add(b.getCliente());
    	for(int i=0;i<12;i++) n.add(clientes.get(i).size());
    	return n;
    }
    /**
      * Retorna lista com o numero de produtos que um dado cliente comprou em cada mes.
      * @return lista com o numero de produtos que um dado cliente comprou em cada mes.
      */
    public ArrayList<Integer> quantosProdComprou(String cliente){
    	ArrayList<Integer> n = new ArrayList<>();
    	ArrayList<TreeSet<String>> produtos = new ArrayList<>(12);
    	for(int i=0;i<12;i++) produtos.add(new TreeSet<String>());
    	ComprasDoCliente c = this.compras.getCompras().get(cliente);
    	if (c!=null){
    		for(Compra b: c.getCompras()){
    			produtos.get(b.getMes()-1).add(b.getProduto());
    		}
    	}
    	for(int i=0;i<12;i++) n.add(produtos.get(i).size());
    	return n;
    }
    /**
      * Retorna o numero de compras num dado mes.
      * @param mes mes.
      * @return o numero de compras nesse mes.
      */
    public int totalComprasMensal(int mes) {
    	int n=0;
    	for (ComprasDoCliente a: this.compras.getCompras().values())
    		for (Compra b: a.getCompras())
    			if(b.getMes()==mes) n++;
    	return n;
    }
    /**
      * Retorna o numero de clientes que comprou num dado mes.
      * @param mes mes.
      * @return o numero de clientes que comprou nesse mes.
      */
    public int totalClientesMensal(int mes){
    	TreeSet<String> clientes=new TreeSet<>();
    	for (ComprasDoCliente a: this.compras.getCompras().values())
    		for (Compra b: a.getCompras())
    			if(b.getMes()==mes) clientes.add(b.getCliente());
    	return clientes.size();
    }
    /**
      * Retorna lista com o numero de gastos de um dado cliente gastou em cada mes.
      * @param cliente codigo de cliente.
      * @return lista com os gastos mensais de cada mes de um dado cliente.
      */
    public ArrayList<Double> gastosMensais(String cliente) {
    	double t;
    	ArrayList<Double> n = new ArrayList<>();
    	for(int i=0;i<12;i++){
    		n.add(0.0);
    	}
    	ComprasDoCliente c = this.compras.getCompras().get(cliente);
    	if (c!=null){
    		for(Compra b: c.getCompras()){
    			t=n.get(b.getMes()-1);
				t+=b.getPreco()*b.getUnidades();
				n.set(b.getMes()-1, t);
    		}
    	}
    	return n;
    }
    /**
      * Retorna lista com o numero de compras de um dado cliente em cada mes.
      * @param cliente codigo de cliente.
      * @return lista com o numero de compras de um dado cliente em cada mes.
      */
    public ArrayList<Integer> quantasCompras(String cliente) {
    	int t;
    	ArrayList<Integer> n = new ArrayList<>();
    	for(int i=0;i<12;i++){
    		n.add(0);
    	}
    	ComprasDoCliente c = this.compras.getCompras().get(cliente);
    	if (c!=null){
    		for(Compra b: c.getCompras()){
    			t=n.get(b.getMes()-1);
				t++;
				n.set(b.getMes()-1, t);
    		}
    	}
    	return n;
    }
    /**
      * Retorna lista com o numero de faturacao de um dado produto em cada mes.
      * @param produto codigo de produto.
      * @return lista com com o numero de faturacao de um dado produto em cada mes.
      */
    public ArrayList<Double> totalFaturado(String produto){
    	ArrayList<Double> n = new ArrayList<>();
    	Cont m = this.contabilidade.getContabilidade().get(produto);
    	if (m!=null) {
    		for(int i=0;i<12;i++){
    			Facturacao s = m.getFacturacao().get(i);
    			n.add(s.getFacturacaoN()+s.getFacturacaoP());
    		}
    	}
    	return n;
    }
    /**
      * Retorna a faturacao de um mes.
      * @param mes mes.
      * @return a faturacao desse mes.
      */
    public double faturacaoMensal(int mes){
        double i=0;
        for(Cont a : this.contabilidade.getContabilidade().values()){
            i+=a.getFacturacaoMensal(mes).getFacturacaoN()+a.getFacturacaoMensal(mes).getFacturacaoP();
        }
        return i;
    }
    /**
      * Retorna a faturacao de cada mes.
      * @return faturacao de cada mes.
      */
    public ArrayList<Double> faturacaoAnual(){
        double i=0;
        ArrayList<Double> novo = new ArrayList<>();
        for(int f=0;f<12;f++) novo.add(0.0);
        for(Cont a : this.contabilidade.getContabilidade().values()){
        	int p=0;
        	for(Facturacao b: a.getFacturacao()){
	            i=novo.get(p);
	        	i+=b.getFacturacaoN()+b.getFacturacaoP();
	        	novo.set(p, i);
	        	p++;
	        	if(p==12) break;
        	}
        }
        return novo;
    }
    /**
      * Retorna a lista de clientes que compraram um dado produto e a sua faturacao.
      * @param produto codigo de produto.
      * @param x quantos clientes quer.
      * @return a lista de clientes que compraram um dado produto e a sua faturacao.
      */
    public ArrayList<ParClienteFacturacao> xclientes(String produto , int x){
        int i=0;
        TreeMap<String,ParClienteFacturacao> novo= new TreeMap<>();
        TreeSet<ParClienteFacturacao> l= new TreeSet<>(new ComparatorParClienteFacturacao());
        ArrayList<ParClienteFacturacao> l2= new ArrayList<>();
        for(ComprasDoCliente a: this.compras.getCompras().values()){
            for(Compra b: a.getCompras()){
                if(b.getProduto().equals(produto)){
                    if(novo.containsKey(a.getCliente())){
                     novo.get(a.getCliente()).addNvezes(b.getUnidades());
                     novo.get(a.getCliente()).addFactoração(b.getUnidades()*b.getPreco());
                   }
                   else{
                    novo.put(a.getCliente(), new ParClienteFacturacao(b.getUnidades(),(b.getUnidades()*b.getPreco()), a.getCliente()));
                   }
                 }
         }
       }
       for(ParClienteFacturacao a: novo.values()){
           l.add(a.clone());
         }
         for(ParClienteFacturacao a: l){
             if(i==x)break;
             l2.add(a);
             i++;
         }
      return l2;
    }
    
}
