public class e15{
    /*
    *   Retorna um valor boolean informando se a String e composta ou nao apenas por 'vogal' -\- Variavel 'str' deve conter a String a ser utilizada, 
    *   variavel 'tamanho' deve ser iniciada como o "string.length()-1", variavel 'boo' deve ser iniciada como "true";
    */
    public static boolean vogais(String str, int tamanho, boolean boo){
        if(tamanho == 0){
            if(!((str.charAt(tamanho) == 'A' || str.charAt(tamanho) == 'a') || (str.charAt(tamanho) == 'E' || str.charAt(tamanho) == 'e') || (str.charAt(tamanho) == 'I' || str.charAt(tamanho) == 'i') || (str.charAt(tamanho) == 'O' || str.charAt(tamanho) == 'o') || (str.charAt(tamanho) == 'U' || str.charAt(tamanho) == 'u')))
            boo = false;

            return boo;
        }
        else{
            if((str.charAt(tamanho) == 'A' || str.charAt(tamanho) == 'a') || (str.charAt(tamanho) == 'E' || str.charAt(tamanho) == 'e') || (str.charAt(tamanho) == 'I' || str.charAt(tamanho) == 'i') || (str.charAt(tamanho) == 'O' || str.charAt(tamanho) == 'o') || (str.charAt(tamanho) == 'U' || str.charAt(tamanho) == 'u'))
            return vogais(str, --tamanho, boo);
            else
            return vogais(str, 0, false);
        }
    }

    /*
    *   Retorna um valor boolean informando se a String e composta ou nao apenas por 'consoante' -\- Variavel 'str' deve conter a String a ser utilizada, 
    *   variavel 'tamanho' deve ser iniciada como o "string.length()-1", variavel 'boo' deve ser iniciada como "true";
    */
    public static boolean consoantes(String str, int tamanho, boolean boo){
        if(tamanho == 0){
            if((str.charAt(tamanho) == 'A' || str.charAt(tamanho) == 'a') || (str.charAt(tamanho) == 'E' || str.charAt(tamanho) == 'e') || (str.charAt(tamanho) == 'I' || str.charAt(tamanho) == 'i') || (str.charAt(tamanho) == 'O' || str.charAt(tamanho) == 'o') || (str.charAt(tamanho) == 'U' || str.charAt(tamanho) == 'u') || !((str.charAt(tamanho) >= 65 && str.charAt(tamanho) <= 90) || (str.charAt(tamanho) >= 97 && str.charAt(tamanho) <= 122)))
            boo = false;

            return boo;
        }
        else{
            if(!((str.charAt(tamanho) == 'A' || str.charAt(tamanho) == 'a') || (str.charAt(tamanho) == 'E' || str.charAt(tamanho) == 'e') || (str.charAt(tamanho) == 'I' || str.charAt(tamanho) == 'i') || (str.charAt(tamanho) == 'O' || str.charAt(tamanho) == 'o') || (str.charAt(tamanho) == 'U' || str.charAt(tamanho) == 'u')) && ((str.charAt(tamanho) >= 65 && str.charAt(tamanho) <= 90) || (str.charAt(tamanho) >= 97 && str.charAt(tamanho) <= 122)))
            return consoantes(str, --tamanho, boo);
            else
            return consoantes(str, 0, false);
        }
    }

    /*
    *   Retorna um valor boolean informando se a String e um numero 'inteiro' -\- Variavel 'str' deve conter a String a ser utilizada, 
    *   variavel 'tamanho' deve ser iniciada como o "string.length()-1", variavel 'boo' deve ser iniciada como "true";
    */
    public static boolean inteiro(String str, int tamanho, boolean boo){
        if(str.charAt(tamanho) < 47 || str.charAt(tamanho) > 57)
            boo = false;
        if(tamanho == 0)
            return boo;
        else
            return inteiro(str, --tamanho, boo);
    }

    /*
    *   Retorna um valor boolean informando se a String e um numero 'real' -\- Variavel 'str' deve conter a String a ser utilizada, 
    *   variavel 'tamanho' deve ser iniciada como o "string.length()-1", variavel 'boo' deve ser iniciada como "true" e variavel 'cont' iniciada como 0;
    */
    public static boolean real(String str, int tamanho, boolean boo, int cont){
        if((str.charAt(tamanho) < 47 && str.charAt(tamanho) != ',' && str.charAt(tamanho) != '.') || str.charAt(tamanho) > 57){
            boo = false;
        }
        else if(str.charAt(tamanho) == ',' || str.charAt(tamanho) == '.')
        ++cont;
        if(cont > 1)
        return false;
        if(tamanho == 0)
        return boo;
        else
        return real(str, --tamanho, boo, cont);
    }


    public static void main(String[] args){
        String str;
        boolean[] saidas = new boolean[4];
        do{
            str = MyIO.readLine();
            if(!(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')){
                saidas[0] = vogais(str, str.length()-1, true);
                saidas[1] = consoantes(str, str.length()-1, true);
                saidas[2] = inteiro(str, str.length()-1, true);
                saidas[3] = real(str, str.length()-1, true, 0);
                for(int i=0; i<4; i++){
                    if(saidas[i])
                    MyIO.print("SIM ");
                    else
                    MyIO.print("NAO ");
                }
                MyIO.print("\n");
            }

        }while(!(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'));
    }
}