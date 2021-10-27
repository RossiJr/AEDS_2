/*package br.com.exerciciosTP2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class Serie{
//    private String nome;
//    
//    public Serie(String nome){
//        this.nome = nome;
//    }
//
//    public String getNome(){
//        return nome;
//    }
//}

class Quest3{
    /*
    *
    *	Efetua uma busca pela lista, retornando 
    * 
    *//*
    public static int comparacao(String nomeInput, List<Serie> listaObj){
        int comparacoes = 0;
    	boolean boo = false;
        for(int j=0; j<listaObj.size(); j++){
        	comparacoes++;
            if(listaObj.get(j).getNome().equals(nomeInput)){
            	comparacoes++;
                boo = true;
                break;
            }
        }
        comparacoes++;
        if(boo)
        System.out.println("SIM");
        else
        System.out.println("N"+(char)195+"O");
        boo = false;
        return comparacoes+1;
    }*/
    /*
     * Trata a string nome, retirando o .html do final e substituindo '_' por ' '
     *//*
    public static String limparNome(String nome) {
    	nome = nome.replace('_', ' ');
    	nome = nome.substring(0, nome.length()-5);
    	
    	return nome;
    }
    public static void main(String[] args) throws IOException{
		long inicio = System.currentTimeMillis(); 
		BufferedWriter bf = new BufferedWriter(new FileWriter("matricula_sequencial.txt"));
		Scanner sc = new Scanner(System.in);
        
		String nome;
        List<Serie> listaObj = new ArrayList<>();
        
           bf.write("738483\t");
        int comparacoes = 0;
        do{
            nome = sc.nextLine();
            nome = nome.replace("\n", "\0");
            comparacoes++;
            if(!nome.equals("FIM"))
                listaObj.add(new Serie(limparNome(nome)));
            else
            break;
        }while(true);

        do{
            nome = sc.nextLine();
            nome = nome.replace("\n", "\0");
            comparacoes++;
            if(!nome.equals("FIM"))
                comparacoes += comparacao(nome, listaObj);
            else
            break;
        }while(true);

        
        long fim  = System.currentTimeMillis();
        bf.write(Long.toString(fim-inicio)+"\t");
        bf.write(Integer.toString(comparacoes));
        sc.close();
        bf.close();
	}

	
}
*/