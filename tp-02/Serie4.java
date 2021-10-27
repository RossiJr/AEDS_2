import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Serie{
   private String nomeHtml;
    
   public Serie(String nomeHtml){
       this.nomeHtml = nomeHtml;
   }

   public String getNomeHtml(){
       return nomeHtml;
   }
}


class Serie4 {
	public static void swap(List<Serie> series, int pos1, int pos2){
		Serie temp = series.get(pos1);
		series.set(pos1, series.get(pos2));
        series.set(pos2, temp);
	}
	/*
    * Efetua uma pesquisa binaria para encontrar cada termo da lista "nomeInput" na lista de objetos "listaObj". Quando a variavel "html" for true, a pesquisa sera
    * com um nome .html - Quando for false, um nome sem .html e com espacos.
    */
    public static int comparacao(String nomeInput, List<Serie> listaObj){
        boolean boo = false;
        int comparacoes = 0;
        	int low = 0;
        	int high = listaObj.size()-1;
        	int mid;
        	comparacoes++;
        	while(low <= high){
        		comparacoes++;
    			mid=(low + high) / 2;
    			if(nomeInput.compareTo(listaObj.get(mid).getNomeHtml()) > 0) {
    				comparacoes++;
    				low = mid + 1;
    			}
    			else if(nomeInput.compareTo(listaObj.get(mid).getNomeHtml()) < 0) {
    				comparacoes+=2;
    				high = mid - 1;
    			}
    			else if (nomeInput.compareTo(listaObj.get(mid).getNomeHtml()) == 0) {
    				comparacoes+=3;
    				boo = true;
    				break;
    			}
        	}
	        if(boo)
            System.out.println("SIM");
            else
            System.out.println("N" + (char)195 + "O");
            boo = false;
        return comparacoes+1;
    }
    public static int ordernar(List<Serie> listaSerie) {
        int j, i, contador=0;
    	Serie key;
    	 contador++;
        for (j = 1; j < listaSerie.size(); j++){
        	contador++;
        	key = listaSerie.get(j);
        	contador++;
        	for (i = j - 1; (i >= 0) && (listaSerie.get(i).getNomeHtml().compareTo(key.getNomeHtml()) > 0); i--){
        		contador++;
        		swap(listaSerie, i+1, i);
        	}
            	listaSerie.set(i+1, key);
    	}
        return contador+1;
    }
    public static String limparNome(String nome) {
    	nome = nome.replace('_', ' ');
    	nome = nome.substring(0, nome.length()-5);
    	
    	return nome;
    }
	public static void main(String[] args) throws IOException{
		long inicio = System.currentTimeMillis(); 
		BufferedWriter bf = new BufferedWriter(new FileWriter("matricula_binaria.txt"));
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

        comparacoes+=ordernar(listaObj);
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
