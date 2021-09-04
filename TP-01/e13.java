public class e13{
    public static void charFy(char[] stringVetor, String word) {                // Transforma a string em um vetor de caracteres
        for (int i = 0; i < word.length(); i++) {
            stringVetor[i] = word.charAt(i);
        }
    }

    /*
    *   Retorna uma String cifrada -\- o parametro str deve ser a string em formato de vetor de caracteres, 
    *   ja o 'pos' deve ser o tamanho da string -1 e o key deve ser a chave de criptografia
    */
    public static String ciframento(char[] str, int pos, int key){
        if(pos == 0){
            str[pos] += key;
            String strFinal = "";
            for(int i=0; i<str.length; i++)
            strFinal+=str[i];
            return strFinal;
        }
        else{
            str[pos] += key;
            return ciframento(str, --pos, key);
        }
    }


    public static void main(String [] args){
        String str;
        char[] strAux;
        do{
            str = MyIO.readLine();
            if(!(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')){
                strAux = new char[str.length()];
                charFy(strAux, str);
                System.out.println(ciframento(strAux, str.length()-1, 3));
            }
        }while(!(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'));
    }

}