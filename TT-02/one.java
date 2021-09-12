class one{
    public static boolean isPalindromo(char[] vect, int pInicial, boolean boo) {                        //Retorna um valor boolean informando se é palíndromo ou não  
        /*
        *
        * A variavel pInicial deve ser instaciada como 0 e a variável boo deve ser instaciada como true
        *
        */
        if (pInicial >= vect.length / 2)
        return boo;
        else {
        if (vect[pInicial] == vect[(vect.length - 1) - pInicial])
        return isPalindromo(vect, ++pInicial, boo);
        else
        return isPalindromo(vect, vect.length - 1, false);
        }
    }
    public static void charFy(char[] stringVetor, String word) {                                        // Transforma a string em um vetor de caracteres
            for (int i = 0; i < word.length(); i++)
                stringVetor[i] = word.charAt(i);
    }

    public static void main(String [] args){
        String frase;
        char[] fraseArray;
        boolean boo;
        do{
            frase = MyIO.readLine();
            if(!(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M')){
                fraseArray = new char[frase.length()];
                charFy(fraseArray, frase);
                
                boo = isPalindromo(fraseArray, 0, true);
                
                if(boo)
                MyIO.println("SIM");
                else
                MyIO.println("NAO");
            }
        }while(!(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'));
    }

}