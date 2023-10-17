package li;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestao test = new Gestao();
        Scanner s=new Scanner (System.in);
        int v=0;
        while(v==0){
            System.out.println("Menu:\n\t1.Consultas estatasticas;\n\t2.Consultas interactivas;\n\t3.Sair;");
            v=s.nextInt();
            while(v<0 || v>3) {
                s=new Scanner (System.in);
                System.out.println("Por favor insira uma opcao de 1 ou 2");
                v=s.nextInt();
            }
            switch (v) {
                case 1:
                    v=0;
                    while(v==0){
                        s=new Scanner (System.in);
                        System.out.println("Consultas estatasticas:\n\t1.Ler do objecto;\n\t2.Inserir ficheiros;\n\t3.Voltar");
                        v=s.nextInt();
                        switch (v) {
                            case 1: 
                                v=0;
                                break;
                            case 2:
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
                        System.out.println("Consultas interactivas:\n\t1.Lista ordenada com os codigos dos produtos nunca comprados e respectivo total;\n\t2.Lista ordenada com os codigos dos clientes que nunca compraram e seu total;\n\t3.Dado um mes valido, determina o numero total de compras e o total de clientes distintos que as realizam;\n\t4.Dado um codigo de cliente, determina, para cada mes, quantas compras fez,quantos produtos distintos comprou e quanto gastou;\n\t5.Dado o codigo de um produto existente, determina, mes a mes, quantas vezes foi comprado, por quantos clientes diferentes e o total facturado;\n\t6.Dado o codigo de um produto existente, determina, mes a mes, quantas vezes foi comprado em modo N e em modo P e respectivas facturacoes;\n\t7.Dado o codigo de um cliente determina a lista de codigos de produtos que mais comprou;\n\t8.Determina o conjunto dos X produtos mais vendidos em todo o ano, indicando o numero total de distintos clientes que o compraram;\n\t9.Determina os X clientes que compraram um maior numero de diferentes produtos;\n\t10.Dado um codigo de um produto, determina o conjunto dos X clientes que mais o compraram\n\t11.Voltar;");
                        v=s.nextInt();
                        switch (v) {
                            case 1: 
                                v=0;
                                break;
                            case 2:
                                v=0;
                                break;
                            case 3:
                                v=0;
                                break;
                            case 4:
                                v=0;
                                break;
                            case 5:
                                v=0;
                                break;
                            case 6:
                                v=0;
                                break;
                            case 7:
                                v=0;
                                break;
                            case 9:
                                v=0;
                                break;
                            case 10:
                                v=0;
                                break;
                            case 11:
                                v=1;
                                break;
                            }
                    }
                    v=0;
                    break;
                case 3:
                    s.close();
                	break;
                    
                    //Guarda o estado do objecto e sai do sistema;
            }
        }
    }
}
