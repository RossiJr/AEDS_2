import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ordenacao {
	public static void swap(Integer elemento1, Integer elemento2, List<Serie> lista) {									// Realiza a troca de elementos
		Serie aux = lista.get(elemento1);
		lista.set(elemento1, lista.get(elemento2));
		lista.set(elemento2, aux);
	}
	
	public static List<Serie> selectionSort(List<Serie> lista) {														//	Ordena o Array pelo método de ordenação de seleção
		List<Serie> listaSerie = lista;
		
		for (int i = 0; i < (listaSerie.size() - 1); i++) {
			int menor = i;
			for (int j = (i + 1); j < listaSerie.size(); j++){
				if (lista.get(menor).getPaisOrigem().compareTo(lista.get(j).getPaisOrigem()) > 0){
					menor = j;
				}
				else if (lista.get(menor).getPaisOrigem().compareTo(lista.get(j).getPaisOrigem()) == 0) {
					if(lista.get(menor).getNome().compareTo(lista.get(j).getNome()) > 0)
						menor = j;
				}
			}
			swap(menor, i, listaSerie);
		}
      
      return listaSerie;
   }
}

/*
*
*/

class Leitura{
	public static String justInt(String line){																			// Retorna apenas a parte inteira da linha
        String resp = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ 
                resp += line.charAt(i);
            } else {
                i = line.length();
            }
        }
        return resp; 
    }
	public static String removeTags(String line){																		// Remove as tags html da linha						
        String newline = "";
        int i = 0;
        while(i < line.length()){
    
        if(line.charAt(i) == '<'){
        i++;
        while(line.charAt(i) != '>') i++;
        } else {
        newline += line.charAt(i);
        }
        i++;
    
    
    
        }
        newline = newline.replaceAll("&nbsp;", "");
        newline = newline.replaceAll("&#160;", "");
        newline = newline.trim(); 
    
    
        newline = newline.replaceAll("(lista de episódios)" , "");
        newline = newline.replaceAll("(Lista de episódios)" , "");
        newline = newline.replaceAll("(até o momento)" , "");
    
        return newline;
    }
	public static String searchName(String fileName){																		// Retorna o nome da série
        String resp = "";
        for(int i = 0; i < fileName.length(); i++){
            if(fileName.charAt(i)  == '_'){ 
                resp += ' ';
            } else { 
                resp += fileName.charAt(i);
            }
        }
        return resp.substring(0, resp.length()-5); 
    }
	
	public static Serie ler(String nomeArquivo) throws IOException{															// Lê um arquivo html e retorna um objeto do tipo Serie com as informações do arquivo 
		String nome;
	    String formato;
	    String duracao;
	    String paisOrigem;
	    String idiomaOriginal;
	    String emissoraTV;
	    String transmissao;
	    String nmrTemp;
	    String nmrEps;
		
        
        FileReader fileReader = new FileReader("/tmp/series/" + nomeArquivo); 

        BufferedReader br = new BufferedReader(fileReader); 
        
        nome = searchName(nomeArquivo);
        
        while(!br.readLine().contains("Formato"));
        formato = removeTags(br.readLine());

        while(!br.readLine().contains("Duração"));
        duracao = removeTags(br.readLine());

        while(!br.readLine().contains("País de origem"));
        paisOrigem = removeTags(br.readLine());

        while(!br.readLine().contains("Idioma original"));
        idiomaOriginal = removeTags(br.readLine());

        while(!br.readLine().contains("Emissora de televisão"));
        emissoraTV = removeTags(br.readLine());

        while(!br.readLine().contains("Transmissão original"));
        transmissao = removeTags(br.readLine());

        while(!br.readLine().contains("N.º de temporadas"));
        nmrTemp = justInt(removeTags(br.readLine()));

        while(!br.readLine().contains("N.º de episódios"));
        nmrEps = justInt(removeTags(br.readLine()));
        
        br.close();         
        return new Serie(nome, formato, duracao, paisOrigem, idiomaOriginal, emissoraTV, transmissao, nmrTemp, nmrEps);
    }
}

class Serie{
	private String nome;
    private String formato;
    private String duracao;
    private String paisOrigem;
    private String idiomaOriginal;
    private String emissoraTV;
    private String transmissao;
    private String nmrTemp;
    private String nmrEps;
    
    public Serie(String nome, String formato, String duracao, String paisOrigem, String idiomaOriginal,
    		String emissoraTV, String transmissao, String nmrTemp, String nmrEps) {
    	this.nome = nome;
    	this.formato = formato;
    	this.duracao = duracao;
    	this.paisOrigem = paisOrigem;
    	this.idiomaOriginal = idiomaOriginal;
    	this.emissoraTV = emissoraTV;
    	this.transmissao = transmissao;
    	this.nmrEps = nmrEps;
    	this.nmrTemp = nmrTemp;
    }
    
    public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getDuracao() {
		return this.duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}
	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}
	public String getEmissoraTV() {
		return emissoraTV;
	}
	public void setEmissoraTV(String emissoraTV) {
		this.emissoraTV = emissoraTV;
	}
	public String getTransmissao() {
		return transmissao;
	}
	public void setTransmissao(String transmissao) {
		this.transmissao = transmissao;
	}
	public String getNmrTemp() {
		return nmrTemp;
	}
	public void setNmrTemp(String nmrTemp) {
		this.nmrTemp = nmrTemp;
	}
	public String getNmrEps() {
		return nmrEps;
	}
	public void setNmrEps(String nmrEps) {
		this.nmrEps = nmrEps;
	}

	public String paraString() {
		return this.nome + " " + this.formato + " " + this.duracao + " " + this.paisOrigem + " " + this.idiomaOriginal + " " + this.emissoraTV + " " + this.transmissao + " " + this.nmrTemp + " " + this.nmrEps;
	}
    
}

public class Exercicio1 {
	
	public static void main(String[] args) throws IOException {
		String path;
		String serieHtml;
		List<Serie> listaSeries = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		do {
			serieHtml = sc.nextLine();
			if(!serieHtml.equals("FIM")) {				
				listaSeries.add(Leitura.ler(serieHtml));
			}
		}while(!serieHtml.equals("FIM"));
		
		listaSeries = Ordenacao.selectionSort(listaSeries);
		
		for (Serie s : listaSeries)
			System.out.println(s.paraString());
		
		sc.close();
	}

}
