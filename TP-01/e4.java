import java.util.Random;

class e4{
    public static char charAleatorio(){                                 //Gera um número aleatório entre 'a' e 'z' da tabela ASCII
    Random gerador = new Random();
    gerador.setSeed(4);
    char letra = (char)gerador.nextInt(27);
    letra+=97;
    return letra;
    }
    
    public static void charFy(char[] stringVetor, String word){         //Transforma a string em um vetor de caracteres
        for(int i=0; i<word.length(); i++)
            stringVetor[i] = word.charAt(i); 
    } 
    
    
    public static void main(String [] args){
    char letra[] = new char[2];
    char[] vetorAux;
    String frase;
    String fraseFinal = "";
    
    do{
        frase = MyIO.readLine();
        if(!(frase.equals("FIM"))){
            for(int i=0; i<2; i++)
                letra[i] = charAleatorio();
        
            vetorAux = new char[frase.length()+1];
            charFy(vetorAux, frase);
        
            for(int i=0; i<vetorAux.length; i++){
                if(vetorAux[i] == letra[0])
                    vetorAux[i] = letra[1];
            }
        
            vetorAux[frase.length()] = '\n';                            //Responsável pela quebra de linha entre as frases

            frase = String.valueOf(vetorAux);
            fraseFinal += frase;
        }
    }while(!(frase.equals("FIM")));


    MyIO.println(fraseFinal);
    }

}
