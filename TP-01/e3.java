class e3{
    public static void charFy(char[] stringVetor, String word){         //Transforma a string em um vetor de caracteres
        for(int i=0; i<word.length(); i++){
            stringVetor[i] = word.charAt(i);
        }
    }

    public static void ciframento(char[] word, int tamanho, int KEY){   //Adiciona o valor da variavael key a cada char da string word
        for(int i=0; i<tamanho; i++)
            word[i]+=KEY;
    }

    public static void main(String [] args){
        String word;
        int teste;
        int tamanho;
        int KEY = 3;
        do{    
        word = MyIO.readLine();
            if(!(word.equals("FIM"))){
                tamanho = word.length();
                char[] wordChar = new char[tamanho];
            
                charFy(wordChar, word);
                ciframento(wordChar, tamanho, KEY);

                word = String.valueOf(wordChar);

                MyIO.println(word);
            }

        }while(!(word.equals("FIM")));
    }
}
