#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int isPalindromo(char* vect, int pInicial, int boo, int tamanho) {                        //Retorna um valor inteiro informando se é palíndromo ou não -\- 1 - Palíndromo  |  0 - !(Palíndromo)
        /*
        *
        * A variavel pInicial deve ser instaciada como 0 e a variável boo deve ser instaciada como 1
        *
        */
        if (pInicial >= tamanho / 2)
        return boo;
        else {
        if (vect[pInicial] == vect[(tamanho - 1) - pInicial])
        return isPalindromo(vect, ++pInicial, boo, tamanho);
        else
        return isPalindromo(vect, tamanho - 1, 0, tamanho);
        }
    }

int testeTermino(char* frase){
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
    char frase[100];
    int flag, tamanho;
    do{
        fgets(frase, sizeof(frase), stdin);
        tamanho = strlen(frase);
        setbuf(stdin, NULL);
        if (testeTermino(frase) == 1){
            flag = isPalindromo(frase, 0, 1, strlen(frase)-1);

            if(flag == 0)
                printf("NAO\n");
            else
                printf("SIM\n");
        }
    
    }while(testeTermino(frase) == 1);


return 0;
}
