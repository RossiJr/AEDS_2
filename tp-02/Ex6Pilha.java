import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class Leitura{
	public String removeTags(String line){
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
	public Serie ler(String nomeArquivo) throws IOException{
		String nome;
	    String formato;
	    String duracao;
	    String paisOrigem;
	    String idiomaOriginal;
	    String emissoraTV;
	    String transmissao;
	    String nmrTemp;
	    String nmrEps;
		
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo));

        BufferedReader br = new BufferedReader(isr);

        while(!br.readLine().contains("infobox_v2"));
        br.readLine();
        nome = removeTags(br.readLine());

        while(!br.readLine().contains("Formato"));
        formato = removeTags(br.readLine());

        while(!br.readLine().contains("Duração"));
        duracao = removeTags(br.readLine());

        while(!br.readLine().contains("País de origem"));
        paisOrigem = removeTags(br.readLine());

        while(!br.readLine().contains("Idioma original"));
        idiomaOriginal = removeTags(br.readLine());

        while(!br.readLine().contains("Emissora de televisão original"));
        emissoraTV = removeTags(br.readLine());

        while(!br.readLine().contains("Transmissão original"));
        transmissao = removeTags(br.readLine());

        br.readLine();
        br.readLine();
        br.readLine();
        nmrTemp = removeTags(br.readLine());

        br.readLine();
        br.readLine();
        br.readLine();
        nmrEps = removeTags(br.readLine());


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

class Pilha{
	private int qtdElementos = 0;
	private Serie[] arrPilha = new Serie[qtdElementos];
	
	
	public static void copiarArray(Serie[] arrNormal, Serie[] arrAux) {
		for(int i=0; i<arrNormal.length; i++) {
			arrAux[i] = arrNormal[i];
		}
	}
	
	public int getQtdElementos() {
		return qtdElementos;
	}
	public void setQtdElementos(int qtdElementos) {
		this.qtdElementos = qtdElementos;
	}
	public Serie[] getArrLista() {
		return arrPilha;
	}
	public void setArrLista(Serie[] arrLista) {
		this.arrPilha = arrLista;
	}
	
	public void empilhar(Serie s) {
		Serie[] arrayAux = new Serie[arrPilha.length];
		copiarArray(arrPilha, arrayAux);
		qtdElementos++;
		arrPilha = new Serie[qtdElementos];
		copiarArray(arrayAux, arrPilha);
		arrPilha[arrPilha.length-1] = s;
				
	}
	public void show() {
		for(int i=qtdElementos-1; i>=0; i--)
			System.out.println(arrPilha[i].paraString());
	}

	public Serie desempilhar() {
		int i;
		Serie[] arrayAux = new Serie[qtdElementos];
		qtdElementos--;
		copiarArray(arrPilha, arrayAux);
		arrPilha = new Serie[qtdElementos];
		for(i=0; i<qtdElementos; i++)
			arrPilha[i] = arrayAux[i];
		
		return arrayAux[i];
	}
	
	
}


class Ex6Pilha {
	public static void processarComando(Pilha pilha, String linhaComando, Leitura objLeitura) throws IOException{
		linhaComando = linhaComando.replace('\n', '\0');
		switch(linhaComando.charAt(0)) {
		case 'I':
			pilha.empilhar(objLeitura.ler("/tmp/series/" + linhaComando.substring(2)));
			break;
		case 'R':
			System.out.println("(R) " + pilha.desempilhar().getNome());
			break;
		}


	}
	public static void main(String[] args) throws IOException {
		Leitura objLeitura = new Leitura();
		Pilha pilha = new Pilha();
		Scanner sc = new Scanner(System.in);
		
		StringBuilder caminho;
		String nome;
		do {
			nome = sc.nextLine();
			if(!nome.equals("FIM")) {
				caminho = new StringBuilder("/tmp/series/");
				caminho.append(nome);
				pilha.empilhar(objLeitura.ler(caminho.toString()));
			}
			else
				break;
		}while(true);
		
		int nmrComandos = sc.nextInt();
		String comando = sc.nextLine();
		for(int i=0; i<nmrComandos; i++) {
			comando = sc.nextLine();
			processarComando(pilha, comando, objLeitura);
		}
		
		
		pilha.show();
		
	}

}

