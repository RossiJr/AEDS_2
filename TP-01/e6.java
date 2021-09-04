public class e6 {
    public static void charFy(char[] stringVetor, String word){         //Transforma a string em um vetor de caracteres
        for(int i=0; i<word.length(); i++)
            stringVetor[i] = word.charAt(i); 
    }

    public static boolean vogais(char[] string){                                    //Retorna se a string é composta apenas por vogais
        boolean valor = true;
        for(int i=0; i<string.length; i++){
            if(!((string[i] == 'A' || string[i] == 'a') || (string[i] == 'E' || string[i] == 'e') || (string[i] == 'I' || string[i] == 'i') || (string[i] == 'O' || string[i] == 'o') || (string[i] == 'U' || string[i] == 'u')))
            valor = false;
        }
        return valor;
    }
    public static boolean consoantes(char[] string){                                //Retorna se a string é composta apenas por consoantes
        boolean valor = true;
        for(int i=0; i<string.length; i++){
            if(!((string[i] >= 65 && string[i] <= 90) || (string[i] >= 97 && string[i] <= 122))) {
                valor = false;
            }
            if(((string[i] == 'A' || string[i] == 'a') || (string[i] == 'E' || string[i] == 'e') || (string[i] == 'I' || string[i] == 'i') || (string[i] == 'O' || string[i] == 'o') || (string[i] == 'U' || string[i] == 'u')))
                valor = false;
        }
        return valor;
    }
    public static boolean inteiro(char[] string){                                   //Retorna se a string é um número inteiro
        boolean valor = true;
        for(int i=0; i<string.length; i++){
            if(string[i] < 47 || string[i] > 57)
                valor = false;
        }
        return valor;
    }
    public static boolean real(char[] string){                                      //Retorna se a string é um número real
        boolean valor = true;
        int cont = 0;
        for(int i=0; i<string.length; i++){
            if((string[i] < 47 && string[i] != ',' && string[i] != '.') || string[i] > 57)
                valor = false;
            if(string[i] == '.' || string[i] == ',')
                ++cont;
        }
        if(cont > 1)
            valor = false;

        return valor;
    }

    public static void main(String [] args){

        boolean[] saidas = new boolean[4];                                      //Onde armazena o output - SIM ou NAO - das questoes
        char[] stringArray;                                                     //Array de char onde a string lida sera armazenada

        String strings;                                                         //Variável onde é armazenado os dados de entrada
        
        do{
            
            strings = MyIO.readLine();
            if(!(strings.equals("FIM"))){
                stringArray = new char[strings.length()];
                
                charFy(stringArray, strings);
                
                saidas[0] = vogais(stringArray);
                saidas[1] = consoantes(stringArray);
                saidas[2] = inteiro(stringArray);
                saidas[3] = real(stringArray);
                for(int i=0; i<4; i++){
                    if(saidas[i])
                    MyIO.print("SIM ");
                    else
                    MyIO.print("NAO ");
                }
                MyIO.print("\n");
            }
        }while(!(strings.equals("FIM")));
    }
}
