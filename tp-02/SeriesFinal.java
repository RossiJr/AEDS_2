import java.io.*;
import java.util.*;

class SeriesTeste{
    private static String nome;
    private static String formato;
    private static String duracao;
    private static String paisOrigem;
    private static String idiomaOriginal;
    private static String emissoraTV;
    private static String transmissao;
    private static int nmrTemp;
    private static int nmrEps;

    public static String removerTags(String linha){                     //Remove as tags da linha
        String linhaSemTag = "";
        int i=0;
        while(i<linha.length()){
            if(linha.charAt(i) == '<'){
                i++;
                while(linha.charAt(i) != '>')
                i++;
            }
            else
            linhaSemTag += linha.charAt(i);
            i++;
        }
        return linhaSemTag;
    }
    public static String apenasLetras(String str){                      //Considera apenas determinadas letras e espaco
        String resultado = "";
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i) >= 97 && str.charAt(i) <= 122) || (str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 128 && str.charAt(i) <= 235) || (str.charAt(i) == ' '))
            resultado+=str.charAt(i);
        }
        return resultado;
    }

    public static int toInteiro(String str){                            //Retorna apenas a parte inteira de uma string no formato Int
        String numero = "";
        for(int i=0; i<str.length(); i++){
            if(((int)str.charAt(i) >= 48) && ((int)str.charAt(i) <= 57))
            numero+=str.charAt(i);
        }
        return Integer.parseInt(numero);
    }

    public void ler(String nomeArquivo) throws IOException{             //Le um documento
        InputStreamReader arquivo = new InputStreamReader(new FileInputStream("/tmp/series/" + nomeArquivo));
        BufferedReader bf = new BufferedReader(arquivo);

        while(!bf.readLine().contains("infobox_v2"));
        bf.readLine();
        this.nome = removerTags(bf.readLine());

        while(!bf.readLine().contains("Formato"));
        this.formato = removerTags(bf.readLine());

        while(!bf.readLine().contains("Duração"));
        this.duracao = removerTags(bf.readLine());
        
        while(!bf.readLine().contains("País de origem"));
        this.paisOrigem = apenasLetras(removerTags(bf.readLine()));

        while(!bf.readLine().contains("Idioma original"));
        this.idiomaOriginal = removerTags(bf.readLine());

        while(!bf.readLine().contains("Emissora de televisão"));
        this.emissoraTV = removerTags(bf.readLine());

        while(!bf.readLine().contains("Transmissão original"));
        this.transmissao = removerTags(bf.readLine());

        while(!bf.readLine().contains("N.º de temporadas"));
        String temps = removerTags(bf.readLine());
        this.nmrTemp = toInteiro(temps);

        while(!bf.readLine().contains("N.º de episódios"));
        String eps = removerTags(bf.readLine());
        this.nmrEps = toInteiro(eps);

        System.out.println(this.nome + " " + this.formato + " " + this.duracao + " " + this.paisOrigem + " " + this.idiomaOriginal + " " + this.emissoraTV + " " + this.transmissao + " " + String.valueOf(this.nmrTemp) + " " + String.valueOf(this.nmrEps));
        bf.close();
    }
}
public class SeriesFinal{
    public static void main(String[] args) throws IOException{
        SeriesTeste s1 = new SeriesTeste();
        Scanner sc = new Scanner(System.in);
        String path;

        do{
            path = sc.nextLine();
            if(!(path.charAt(0) == 'F' && path.charAt(1) == 'I' && path.charAt(2) == 'M')){
                try{
                    s1.ler(path);
                }
                catch (Exception e){}
            }
        }while(!(path.charAt(0) == 'F' && path.charAt(1) == 'I' && path.charAt(2) == 'M'));
    }
}