class two{
    public static void retornarInt(String caracteresLidos, int[] idades){                                                                                               //Atribui como int o valor das idades
        int pos = 0;            //posicao na string
        int pessoa = 0;         //posicao do array de idades
        int multiplicador;      //para considerar variável centena, dezena ou unidade
        for(int i=0; i<4; i++)
            idades[i] = 0;

        while(!(pos == caracteresLidos.length())){                                                                                                          //le a string
            if(caracteresLidos.charAt(pos)!=' '){
                if(pos < caracteresLidos.length()-3){                                                                                                       //Testa para codigo do If interno nao acessar posição inexistente da String
                    if((caracteresLidos.charAt(pos+3) == ' ') && (caracteresLidos.charAt(pos+2) != ' ') && (caracteresLidos.charAt(pos+1) != ' '))          //testa para ver se e a terceira casa de um numero
                    multiplicador = 100;
                    else if((caracteresLidos.charAt(pos+2) == ' ') && (caracteresLidos.charAt(pos+1) != ' '))                                               //testa para ver se e a segunda casa de um numero
                    multiplicador = 10;
                    else
                    multiplicador = 1;
                }
                else{
                    if(pos != caracteresLidos.length()-1){                                                                                                  //Garante que não é o ultimo caractere da String e que não vai acessar posição inexistente
                        if(caracteresLidos.charAt(pos) != ' ' && caracteresLidos.charAt(pos+1) != ' ' && ((caracteresLidos.length()-1) - pos) == 2)         //Testa para terceira casa de um número e identifica se ele tem tres casas
                        multiplicador = 100;
                        else if(caracteresLidos.charAt(pos) != ' ' && caracteresLidos.charAt(pos+1) != ' ')                                                 //Testa para segunda casa de um numero
                        multiplicador = 10;
                        else
                        multiplicador = 1;
                    }
                    else                                                                                                                                    //Se for a ultima casa, então o número não é dezena nem centena
                    multiplicador = 1;

                }
                idades[pessoa] += ((int)caracteresLidos.charAt(pos)-48)*multiplicador;                                                                      //transforma o char da tabela ASCII em int
            }
            else
            pessoa++;

            ++pos;
        }
    }

    public static void main(String [] args){
        int[] idade = new int[4];
        String aux;

        do{
            aux = MyIO.readLine();
            retornarInt(aux, idade);
            if(!(idade[0] == 0)){
                idade[3] = idade[0] - (idade[1] + idade[2]);
                if(idade[1] > idade[2] && idade[1] > idade[3])
                MyIO.println(idade[1]);
                else if(idade[2] > idade[1] && idade[2] > idade[3])
                MyIO.println(idade[2]);
                else
                MyIO.println(idade[3]);
            }
        }while(!(idade[0] == 0));

    }


}