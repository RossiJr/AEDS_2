import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class Leitura{
	public int justInt(String line){
        String resp = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ 
                resp += line.charAt(i);
            } else { 
                i = line.length();
            }
        }
        return Integer.parseInt(resp);
    }
	public String removeTags(String line){
        String resp = "";
        int i = 0;
        while(i < line.length()){ //enquanto i for menor que o tamanho da String linha
            if(line.charAt(i) == '<'){ // é testado para verificar se o contador i ainda está dentro das tags
                i++;
                while(line.charAt(i) != '>') i++; //ao encontrar o sinal de fechamento das tags o laço de repetição é encerrado
            } else if(line.charAt(i) == '&'){ //mesmo tratamento de cima mas para outras exceções presentes em alguns outros arquivos
                i++;
                while(line.charAt(i) != ';') i++;
            } else { //o que estiver fora das tags é concatenado a String resp a ser retornada
                resp += line.charAt(i);
            }
            i++;
        }
        //System.out.println(resp);
        return resp;
    }
	public Serie ler(String nomeArquivo) throws IOException{
		String nome;
	    String formato;
	    String duracao;
	    String paisOrigem;
	    String idiomaOriginal;
	    String emissoraTV;
	    String transmissao;
	    int nmrTemp;
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
		if(nome.equals("Breaking Bad"))
		br.readLine();
        nmrTemp = justInt(removeTags(br.readLine()));
        
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
    private int nmrTemp;
    private String nmrEps;
    
    public Serie(String nome, String formato, String duracao, String paisOrigem, String idiomaOriginal,
    		String emissoraTV, String transmissao, int nmrTemp, String nmrEps) {
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
	public int getNmrTemp() {
		return nmrTemp;
	}
	public void setNmrTemp(int nmrTemp) {
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

class FilaCircular{
	private int qtdElementos = 0;
	private int posicao = 0;
	private Serie[] arrFila = new Serie[qtdElementos];
	
	
	public static void copiarArray(Serie[] arrNormal, Serie[] arrAux) {
		for(int i=0; i<arrNormal.length; i++) {
			arrAux[i] = arrNormal[i];
		}
	}
	public int media() {
		double mediaValor=0;
		for(int i=0; i<arrFila.length; i++)
			mediaValor += arrFila[i].getNmrTemp();
		
		return (int) (mediaValor/qtdElementos+ 0.5);
	}
	
	public int getQtdElementos() {
		return qtdElementos;
	}
	public void setQtdElementos(int qtdElementos) {
		this.qtdElementos = qtdElementos;
	}
	public Serie[] getArrLista() {
		return arrFila;
	}
	public void setArrLista(Serie[] arrLista) {
		this.arrFila = arrLista;
	}
	
	public int inserir(Serie s) {
		Serie[] arrayAux = new Serie[qtdElementos];
		copiarArray(arrFila, arrayAux);
		
		
		if (qtdElementos < 5) 
			qtdElementos++;
		arrFila = new Serie[qtdElementos];
		
		if (qtdElementos == 5) {
			if(posicao == 5) {
				for(int i=1; i<qtdElementos; i++) 
					arrFila[i-1] = arrayAux[i];
				arrFila[4] = s;
			}
			else {
				copiarArray(arrayAux, arrFila);
				arrFila[4] = s;
				posicao++;
			}
		}
		else {
			copiarArray(arrayAux, arrFila);
			if(posicao==0) {
				arrFila[0] = s;
				posicao++;
			}
			else {
				arrFila[posicao] = s;
				posicao++;
			}
			
 		}
		
		return media();	
	}
	public void remover() {
		Serie[] arrayAux = new Serie[qtdElementos];
		copiarArray(arrFila, arrayAux);
		qtdElementos--;
		arrFila = new Serie[qtdElementos];
		for(int i=1; i<qtdElementos+1; i++)
			arrFila[i-1] = arrayAux[i];
		
		posicao--;
	}
	
	public void show() {
		for(int i=0; i<qtdElementos; i++)
			System.out.println(arrFila[i].paraString());
	}

	
	
}


class ExFilaCircular {
	public static void processarComando(FilaCircular filaCircular, String linhaComando, Leitura objLeitura) throws IOException{
		linhaComando = linhaComando.replace('\n', '\0');
		switch(linhaComando.charAt(0)) {
		case 'I':
			System.out.println(filaCircular.inserir(objLeitura.ler("/tmp/series/" + linhaComando.substring(2))));
			break;
		case 'R':
			filaCircular.remover();
			break;
		}


	}
	public static void main(String[] args) throws IOException {
		Leitura objLeitura = new Leitura();
		FilaCircular filaCircular = new FilaCircular();
		Scanner sc = new Scanner(System.in);
		
		StringBuilder caminho;
		String nome;
		do {
			nome = sc.nextLine();
			if(!nome.equals("FIM")) {
				caminho = new StringBuilder("/tmp/series/");
				caminho.append(nome);
				System.out.println(filaCircular.inserir(objLeitura.ler(caminho.toString())));
			}
			else
				break;
		}while(true);
		
		int nmrComandos = sc.nextInt();
		String comando = sc.nextLine();
		for(int i=0; i<nmrComandos; i++) {
			comando = sc.nextLine();
			processarComando(filaCircular, comando, objLeitura);
		}
						
	}

}
