package li;

import java.util.ArrayList;
import java.lang.System;
import java.util.TreeSet;
import java.util.Scanner;
import java.lang.String;
import java.io.*;

public class MainTeste {
	
	public static void paginas(ArrayList<?extends Object> t){
		int inicio=0;
	    int fim=15;
	    int k;
	    int Tpaginas;
	    if((t.size()%15)==0) Tpaginas=t.size()/15;
        else Tpaginas= (t.size()/15)+1;
	    Scanner ss= new Scanner(System.in);
	    Scanner p= new Scanner(System.in);
	    String b="s";
	    String l="";
	    while(inicio<fim && inicio<t.size()) {
	    	System.out.println(t.get(inicio).toString());
            inicio++;
        }
        if (!(inicio<15)) {
        	System.out.println("\t\tPagina [1/"+Tpaginas+"]");
            System.out.println("Deseja continuar? [s/n]");
            b=ss.nextLine();
            while(b.equals("s")) {
            	ss=new Scanner(System.in);
            	System.out.println("Deseja passar para a proxima pagina, regredir ou saltar para uma pagina? [p/r/s]");
            	l=ss.nextLine();
            	if (l.equals("p")){
            		if (fim>t.size()+15) System.out.println("Nao e possivel progredir pois esta no fim");
            		else {
            			inicio=fim;
		                fim+=15;
		                for(int i=inicio;(i<fim && i<t.size());i++) {
		                	//if (t.get(inicio) == null) break;
		                	System.out.println(t.get(i).toString());
		                }
		                inicio=fim;
		                System.out.println("\t\tPagina ["+(fim/15)+"/"+Tpaginas+"]");
		                System.out.println("Deseja continuar? [s/n]");
		                b=ss.nextLine();
            		}
            	}
            	else if (l.equals("r")){
            		if (inicio-30<0) System.out.println("Nao e possivel regredir pois esta no incio");
            		else {
            			inicio-=30;
            			fim-=15;
            			for(int i=inicio;(i<fim && i<t.size());i++) {
		                	//if (t.get(inicio) == null) break;
		                	System.out.println(t.get(i).toString());
		                }
            			inicio=fim;
	            		System.out.println("\t\tPagina ["+(fim/15)+"/"+Tpaginas+"]");
		                System.out.println("Deseja continuar? [s/n]");
		                b=ss.nextLine();
            		}
            	}
            	else {
            		//s= new Scanner(System.in);
            		System.out.println("Para que pagina deseja saltar?");
            		k=p.nextInt();
            		while(k*15>(t.size()+15) || k<0){
            			System.out.println("Pagina nao valida, por favor volte a inserir");
            			k=p.nextInt();
            		}
            		inicio=(k-1)*15;
	                fim=k*15;
	                for(int i=inicio;(i<fim && i<t.size());i++) {
	                	//if (t.get(inicio) == null) break;
	                	System.out.println(t.get(i).toString());
	                }
	                inicio=fim;
	                System.out.println("\t\tPagina ["+(fim/15)+"/"+Tpaginas+"]");
                    System.out.println("Deseja continuar? [s/n]");
                    b=ss.nextLine();
                    
            	}
            	
            }
        }
        else System.out.println("");
	}
	
    public static void main(String[] args) {
        Gestao test = new Gestao();
        Scanner s=new Scanner (System.in);
        Scanner p=new Scanner (System.in);
        int v=0;
        int inteiro;
        String escolha="";
        String cliente="";
        String produto="";
        String fichCliente="FichClientes.txt";
        String fichProduto="FichProdutos.txt";
        String fichCompras="Compras.txt";
        ArrayList<Compra> comprasInvalidas=null;
        System.out.println("Hipermercado:\n\t1.Ler do objecto;\n\t2.Inserir ficheiros;\n");
        v=p.nextInt();
        while(v<0 || v>2) {
            s=new Scanner (System.in);
            System.out.println("Por favor insira uma opcao de 1 a 2");
            v=p.nextInt();
        }
        if(v==1){
        	int y=0;
        	while(y==0){
	            try{
	            	String fileInput="hipermercado.obj";
	            	System.out.println("Deseja carregar o objeto predefenido (hipermercado.obj)? [s/n]");
	                escolha=s.nextLine();
	                if (!escolha.equals("s")) {
	                	System.out.println("Qual o nome do objeto que deseja carregar?");
	                	fileInput=s.nextLine();
	                	}
	                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileInput));
	                test=(Gestao) ois.readObject();
	                ObjectInputStream ci = new ObjectInputStream(new FileInputStream("comprasInvalidas.obj"));
	                comprasInvalidas= (ArrayList<Compra>) ci.readObject();
	                ois.close();
	                ci.close();
	                y=1;
	            }
	            catch(FileNotFoundException e) {
	            	System.out.println("Nao existe um objecto com esse nome");
	            	y=0;
	            }
	            catch(IOException e) {
	            	System.out.println(e);
	            	System.exit(0);
	            }
	            catch(ClassNotFoundException e) {
	            	System.out.println(e);
	            	System.exit(0);
	            }
        	}
        }
        else{
        	System.out.println("Nao existe um objecto com esse nome");
        	fichProduto=s.nextLine();
        	System.out.println("Nao existe um objecto com esse nome");
        	fichCliente=s.nextLine();
        	System.out.println("Nao existe um objecto com esse nome");
        	fichCompras=s.nextLine();
        	test.leituraClientes(fichCliente);
        	test.leituraProdutos(fichProduto);
        	comprasInvalidas=test.leituraCompras(fichCompras);
        }
        while(v==0){
            s=new Scanner (System.in);
            System.out.println("Consultas:\n\t1.Consultas estat�sticas\n\t2.Consultas interactivas:;\n\t3.Voltar");
            v=p.nextInt();
            switch (v) {
                case 1:
                    v=0;
                    while(v==0){
                        s=new Scanner (System.in);
                        System.out.println("Consultas estat�sticas:\n\t1.Informa��o do ficheiro;\n\t2.Informa��o sobre estruturas;\n\t3.Voltar");
                        v=p.nextInt();
                        switch (v) {
                            case 1:
                            	System.out.println("Ficheiro dos Produtos: "+fichProduto);
                            	System.out.println("Ficheiro dos Clientes: "+fichCliente);
                            	System.out.println("Ficheiro das Compras: "+fichCompras);
                                System.out.println("Numero total de produtos: "+test.totalProdutos());
                                System.out.println("Numero total de diferentes produtos comprados: " +test.totalDifProdComp());
                                System.out.println("Numero total de n�o comprados: " +(test.totalProdutos()-test.totalDifProdComp()));
                                System.out.println("Numero total de clientes: " +test.totalClientes());
                                System.out.println("Numero total de clientes que realizaram compras: " +test.totalComprasRealizadas());
                                System.out.println("Numero total de clientes que nada compraram: " +(test.totalClientes()-test.totalComprasRealizadas()));
                                System.out.println("Numero total de compras de valor total zero: "+test.comprasZero());
                                System.out.println("Numero total de compras invalidas: "+comprasInvalidas.size());
                                System.out.format("Facturacao total : %.2f\n",test.faturacaoTotal());
                                v=0;
                                break;
                            case 2:
                                int i;
                                int a=0;
                                ArrayList<Integer> compraspormes = test.numComprasAnual();
                                ArrayList<Integer> numClientesCompraram = test.clientesCompraramAnual();
                                ArrayList<Double> facturacaoAnual = test.faturacaoAnual();
                                System.out.println("  ----------------------------------------------------------------------");
                                System.out.println(" |\tMes\t|   NumCompras  |  NumProdutos  |\tFacturacao\t|");
                                System.out.println("  ----------------------------------------------------------------------");
                                for(i=0;i<12;i++) {
                                	System.out.format(" |\t"+(i+1)+"\t|\t%d\t|\t%d\t|\t%.2f\t|\n",compraspormes.get(i),numClientesCompraram.get(i),facturacaoAnual.get(i));
                                	a+=compraspormes.get(i);
                                }
                                System.out.println("  ----------------------------------------------------------------------");
                                System.out.format(" |   Total\t|\t%d\t|\t%d\t|      %.2f\t|\n",a,test.totalComprasRealizadas(),test.faturacaoTotal());
                                System.out.println("  ----------------------------------------------------------------------");
                                PrintWriter ci= new PrintWriter(new BufferedWriter(new FileWriter("comprasInvalidas.txt")));
                                v=0;
                                break;
                            case 3:
                                v=1;
                                break;
                        }
                    }
                    v=0;
                    break;
                case 2:
                    v=0;
                    while(v==0){
                        s=new Scanner (System.in);
                        p=new Scanner (System.in);
                        System.out.println("Consultas interactivas:\n\t1.Lista ordenada com os c�digos dos produtos nunca comprados e respectivo total;\n\t2.Lista ordenada com os codigos dos clientes que nunca compraram e seu total;\n\t3.Dado um mes valido, determina o numero total de compras e o total de clientes distintos que as realizam;\n\t4.Dado um codigo de cliente, determina, para cada mes, quantas compras fez,quantos produtos distintos comprou e quanto gastou;\n\t5.Dado o codigo de um produto existente, determina, mes a mes, quantas vezes foi comprado, por quantos clientes diferentes e o total facturado;\n\t6.Dado o codigo de um produto existente, determina, mes a mes, quantas vezes foi comprado em modo N e em modo P e respectivas facturacoes;\n\t7.Dado o codigo de um cliente determina a lista de codigos de produtos que mais comprou;\n\t8.Determina o conjunto dos X produtos mais vendidos em todo o ano, indicando o numero total de distintos clientes que o compraram;\n\t9.Determina os X clientes que compraram um maior numero de diferentes produtos;\n\t10.Dado um codigo de um produto, determina o conjunto dos X clientes que mais o compraram\n\t11.Voltar;");
                        v=p.nextInt();
                        switch (v) {
                            case 1:
                            	ArrayList<String> produtosNaoComprados= new ArrayList<>(test.produtosNaoComprados());
    		                	System.out.println("Nao foram comprados "+produtosNaoComprados.size()+" produtos");
    		                	paginas(produtosNaoComprados);
                                v=0;
                                break;
                            case 2:
                            	ArrayList<String> clientesSemCompras= new ArrayList<>(test.clientesNuncaCompraram());
                            	if (clientesSemCompras.size()==0) System.out.println("Todos os clientes efeturam compras");
                            	else {
                            		System.out.println(clientesSemCompras.size()+" clientes nao efetuaram compras");
        		                	paginas(clientesSemCompras);
                            	}
                                v=0;
                                break;
                            case 3:
                            	System.out.println("Para que mes deseja ver?");
                                inteiro=p.nextInt();
                                System.out.println("No mes "+inteiro+" "+test.totalClientesMensal(inteiro)+" clientes efetuaram "+test.totalComprasMensal(inteiro)+" compras\n");
                                v=0;
                                break;
                            case 4:
                            	double totalFaturado=0;
                            	System.out.println("Introduza o Codigo de Cliente:");
                            	cliente=s.nextLine();
                            	ArrayList<Integer> qCompras = test.quantasCompras(cliente);
                            	ArrayList<Integer> qProdCompras = test.quantosProdComprou(cliente);
                            	ArrayList<Double> gastos = test.gastosMensais(cliente);
                            	System.out.println("  --------------------#"+cliente+"#-----------------------------------");
                            	System.out.println(" |\tMes\t|   NumCompras  |  NumProdutos  |     Gastos\t|");
                            	System.out.println("  --------------------------------------------------------------");
                                for(int i=0;i<12;i++) {
                                	System.out.format(" |\t"+(i+1)+"\t|\t%d\t|\t%d\t|\t%.2f\t|\n",qCompras.get(i),qProdCompras.get(i),gastos.get(i));
                                	totalFaturado+=test.gastosMensais(cliente).get(i);
                                }
                                System.out.println("  --------------------------------------------------------------");
                                System.out.format(" |\tTotal faturado no ano: %.2f\t\t\t\t|\n",totalFaturado);
                                System.out.println("  --------------------------------------------------------------");
                                v=0;
                                break;
                            case 5:
                            	System.out.println("Introduza o Codigo do produto:");
                            	produto=s.nextLine();
                            	ArrayList<Integer> numCompras = test.numCompras(produto);
                            	ArrayList<Integer> numClientes = test.ClientesCompraram(produto);
                            	ArrayList<Double> totalFaturacao = test.totalFaturado(produto);
                            	System.out.println("  --------------------#"+produto+"#----------------------------------");
                            	System.out.println(" |\tMes\t|   NumCompras  |  NumProdutos  | TotalFaturado\t|");
                            	System.out.println("  --------------------------------------------------------------");
                                for(int i=0;i<12;i++)  System.out.format(" |\t"+(i+1)+"\t|\t%d\t|\t%d\t|\t%.2f\t|\n",numCompras.get(i),numClientes.get(i),totalFaturacao.get(i));
                                System.out.println("  --------------------------------------------------------------");
                                v=0;
                                break;
                            case 6:
                            	System.out.println("Introduza o Codigo do produto:");
                            	produto=s.nextLine();
                            	ArrayList<Facturacao> nn= test.quantasVezes(produto);
                            	System.out.println("  --------------------#"+produto+"#--------------------------------------------------");
                            	System.out.println(" |\tMes\t|    VendasN\t|  FacturacaoN\t|    VendasP\t|  FacturacaoP\t|");
                            	System.out.println("  ------------------------------------------------------------------------------");
                                for(int i=0;i<12;i++)  System.out.format(" |\t"+(i+1)+"\t|\t%d\t|\t%.2f\t|\t%d\t|\t%.2f\t|\n",nn.get(i).getVendasN(),nn.get(i).getFacturacaoN(),nn.get(i).getVendasP(),nn.get(i).getFacturacaoP());
                                System.out.println("  ------------------------------------------------------------------------------");
                                v=0;
                                break;
                            case 7:
                                System.out.println("Introduza o Codigo de Cliente:");
                                cliente=s.nextLine();
                                paginas(test.listaProdutosMaisComprados(cliente));
                                v=0;
                                break;
                            case 8:
                            	System.out.println("Quantos produtos deseja ver: ");
                                inteiro=p.nextInt();
                            	paginas(test.produtosMaisVendidos(inteiro));
                                v=0;
                                break;
                            case 9:
                            	System.out.println("Quantos clientes deseja ver: ");
                                inteiro=p.nextInt();
                                paginas(test.NumProdDiferentesPorCli(inteiro));
                                v=0;
                                break;
                            case 10:
                            	//s=new Scanner (System.in);
                                System.out.println("Introduza o Codigo do produto:");
                                produto=s.nextLine();
                                System.out.println("Quantos clientes deseja ver?:");
                                inteiro=p.nextInt();
                                paginas(test.xclientes(produto, inteiro));
                                v=0;
                                break;
                            case 11:
                            	try{
                	            	String fileOutput="hipermercado.obj";
                	            	System.out.println("Deseja guardar o objeto com nome predefenido (hipermercado.obj)? [s/n]");
                	                escolha=s.nextLine();
                	                if (!escolha.equals("s")) {
                	                	System.out.println("Qual o nome do obecto a guardar?");
                	                	fileOutput=s.nextLine();
                	                	}
                	                ObjectOutput ois = new ObjectOutputStream(new FileOutputStream(fileOutput));
                	                ObjectOutput ci = new ObjectOutputStream(new FileOutputStream("comprasInvalidas.obj"));
                	                ois.writeObject(test);
                	                ci.writeObject(comprasInvalidas);
                	                ci.flush();
                	                ci.close();
                	                ois.flush();
                	                ois.close();
                	            }
                	            catch(IOException e) {
                	            	System.out.println(e);
                	            	System.exit(0);
                	            }
                            	v=0;
                            	break;
                            case 12:
                            	try{
            	                	System.out.println("Qual o nome do objeto que deseja carregar?");
            	                	String fileInput=s.nextLine();
                	                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileInput));
                	                test=(Gestao) ois.readObject();
                	                ObjectInputStream ci = new ObjectInputStream(new FileInputStream("comprasInvalidas.obj"));
                	                ois.close();
                	            }
                	            catch(FileNotFoundException e) {
                	            	System.out.println("Nao existe um objecto com esse nome!");
                	            }
                	            catch(IOException e) {
                	            	System.out.println(e);
                	            	System.exit(0);
                	            }
                	            catch(ClassNotFoundException e) {
                	            	System.out.println(e);
                	            	System.exit(0);
                	            }
                            	v=0;
                            	break;
                            case 13:
                            	System.out.println("Qual o nome do ficheiro compras que deseja ler?");
                            	fichCompras=s.nextLine();
                            	test.leituraCompras(fichCompras);
                            	v=0;
                            	break;
                            case 14:
                                v=1;
                                break;
                            }
                    }
                    v=0;
                    break;
                case 3:
                    break;
                    //Guarda o estado do objecto e sai do sistema;
            }
        }
        s.close();
        p.close();
    }
}
  //test.leituraProdutos();
        //test.leituraClientes();
        //test.leituraCompras();
        //System.out.println("Tempo"+a.print());
        //test.listaMaisCompradaProdutos("AT499");
        //test.NumProdDiferentesPorCli();
        //test.faturacaoTotal();
        //prod.insereP(novoP);
        //cli.insereC(novoC);
        //comp.insereComp(novoCompras);
        //conta.insereConta(novoCompras);
        /*test01 = comp.getCompras();
            for (Compra a: test01) {
                System.out.println(a.getCodigo());
            }*/