import java.io.*;
import java.net.*;

public class e8{
    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
        // nothing to see here

        }

        return resp;
    }


    /*
    *
    * A proxima funcao retorna o numero de consoantes encontradas no texto e, tambem atribui ao vetor vogalSemAcento a quantidade de vogais sem acentos na string recebida por parametro, 
    * estando na sua respectiva ordem.
    *
    */
    public static int vSemAcentoCons(String conteudo, int[] vogalSemAcento, int consoantes){
        for(int i=0; i<conteudo.length(); i++){
            switch (conteudo.charAt(i)){
                case 'a':
                ++vogalSemAcento[0];
                break;
                case 'e':
                ++vogalSemAcento[1];
                break;
                case 'i':
                ++vogalSemAcento[2];
                break;
                case 'o':
                ++vogalSemAcento[3];
                break;
                case 'u':
                ++vogalSemAcento[4];
                default:
                if(conteudo.charAt(i)>='b' && conteudo.charAt(i)<='z')
                ++consoantes;
                break;
            }
        }
        return consoantes;
    }
    


    /*
    *
    * A proxima atribui aos vetores vogalComAcento e tableBr a quantidade de vogais com acentos na string recebida como parametro, estando na sua respectiva ordem.
    *
    */
    public static void vComAcentoAndTableBr(String conteudo, int[] vogalComAcento, int[] tableBr){
        for(int i=0; i<conteudo.length(); i++){
            switch (conteudo.charAt(i)){
                case '�':
                ++vogalComAcento[0];
                break;
                case '�':
                ++vogalComAcento[1];
                break;
                case '�':
                ++vogalComAcento[2];
                break;
                case '�':
                ++vogalComAcento[3];
                break;
                case '�':
                ++vogalComAcento[4];
                break;
                case '�':
                ++vogalComAcento[5];
                break;
                case '�':
                ++vogalComAcento[6];
                break;
                case '�':
                ++vogalComAcento[7];
                break;
                case '�':
                ++vogalComAcento[8];
                break;
                case '�':
                ++vogalComAcento[9];
                break;
                case '�':
                ++vogalComAcento[10];
                break;
                case '�':
                ++vogalComAcento[11];
                break;
                case '�':
                ++vogalComAcento[12];
                break;
                case '�':
                ++vogalComAcento[13];
                break;
                case '�':
                ++vogalComAcento[14];
                break;
                case '�':
                ++vogalComAcento[15];
                break;
                case '�':
                ++vogalComAcento[16];
                break;
                case '<':
                if(conteudo.charAt(i+1) == 'b'){
                    if(conteudo.charAt(i+2) == 'r'){
                        if(conteudo.charAt(i+3) == '>')
                        ++tableBr[0];
                    }
                }
                else if(conteudo.charAt(i+1) == 't'){
                    if(conteudo.charAt(i+2) == 'a'){
                        if(conteudo.charAt(i+3) == 'b'){
                            if(conteudo.charAt(i+4) == 'l'){
                                if(conteudo.charAt(i+5) == 'e'){
                                    if(conteudo.charAt(i+6) == '>')
                                    ++tableBr[1];
                                }
                            }
                        }
                    }
                }
                default:
                break;
            }
        }
    }

    public static void main(String [] args) throws IOException{
        String nomeSite, url, aux, conteudo="";
        int[] vogalSemAcento = new int[5];
        int[] vogalComAcento = new int[17];
        int[] tableBr = new int[2];
        int consoantes = 0;
        do{
            nomeSite = MyIO.readLine();
            if(!(nomeSite.charAt(0) == 'F' && nomeSite.charAt(1) == 'I' && nomeSite.charAt(2) == 'M')){
                url = MyIO.readLine();
                
                conteudo = getHtml(url);

                consoantes = vSemAcentoCons(conteudo, vogalSemAcento, consoantes);
                vComAcentoAndTableBr(conteudo, vogalComAcento, tableBr);
                System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) �(%d) consoante(%d) <br>(%d) <table>(%d) %s\n", vogalSemAcento[0], vogalSemAcento[1], vogalSemAcento[2], vogalSemAcento[3], vogalSemAcento[4], vogalComAcento[0], vogalComAcento[1], vogalComAcento[2], vogalComAcento[3], vogalComAcento[4], vogalComAcento[5], vogalComAcento[6], vogalComAcento[7], vogalComAcento[8], vogalComAcento[9], vogalComAcento[10], vogalComAcento[11], vogalComAcento[12], vogalComAcento[13], vogalComAcento[14], vogalComAcento[15], vogalComAcento[16], consoantes, tableBr[0], tableBr[1], nomeSite);
            }
        }while(!(nomeSite.charAt(0) == 'F' && nomeSite.charAt(1) == 'I' && nomeSite.charAt(2) == 'M'));
    }

}