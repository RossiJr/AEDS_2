class e1{
    public static void charFy(char[] stringVetor, String word){         //Transforma a string em um vetor de caracteres
        for(int i=0; i<word.length(); i++){
            stringVetor[i] = word.charAt(i);
        }
     }
    public static void inversao(char[] palavraNormal, char[] palavraInvertida, int tamanho){ //Inverte a string original
        --tamanho;
        for(int i=0; i<palavraNormal.length; i++, tamanho--){
            palavraInvertida[i] = palavraNormal[tamanho];    
        }
    }
    public static boolean teste(char palavraNormal, char palavraInvertida){     //testa para palavra caractere difente
        if(palavraNormal == palavraInvertida){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String [] args){
        String word;
        char[] auxWord;
        int tamanho;
        char[] word2;

        do{
        word = MyIO.readLine();
        if(!(word.equals("FIM"))){
            auxWord = new char[word.length()];

            tamanho = word.length();
        
            word2 = new char[tamanho];

            charFy(auxWord, word);
            inversao(auxWord, word2, tamanho);
        
            boolean teste = true;

            for(int i=0; i<tamanho; i++){
                if(!teste(auxWord[i], word2[i])){
                    teste = false;
                }
            }

            if(teste)
                MyIO.println("SIM");
            else
                MyIO.println("NAO");
        }
        } while(!(word.equals("FIM")));
    }

}
