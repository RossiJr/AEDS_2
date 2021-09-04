#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

void inverterFrase(char* fraseNormal, char* fraseInvertida, int tamanho){       //Inverte o vetor de caracteres
    int i;
    int aux = tamanho-2;
    for(int i=0; i<tamanho; i++, aux--)
    fraseInvertida[i] = fraseNormal[aux];
}

int comparacao(char* fraseNormal, char* fraseInvertida, int tamanho){           //Compara para ver se e anagrama
    int flag = 1;
    for (int i=0; i<tamanho--; i++){
        if(!(fraseNormal[i] == fraseInvertida[i]))
            flag = 0;
    }
    return flag;
}

int testeTermino(char* frase){                                                  //Testa para termino do programa
    if(strlen(frase) == 4){
        if(frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M'){
            return 0;
        }
        else
            return 1;
    }
    else
        return 1;
}
int main(){
    /*Falta colocar um loop*/
    char fraseInvertida[100];
    char frase[100];
    int flag, tamanho;
    do{
        fgets(frase, sizeof(frase), stdin);
        tamanho = strlen(frase);
        setbuf(stdin, NULL);
        if (testeTermino(frase) == 1){

            inverterFrase(frase, fraseInvertida, tamanho);
    
            flag = comparacao(frase, fraseInvertida, tamanho);

            if(flag == 0)
                printf("NAO\n");
            else
                printf("SIM\n");
        }
    
    }while(testeTermino(frase) == 1);


return 0;
}