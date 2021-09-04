#include <stdio.h>
#include <string.h>

int isPalindromo(char* vect, int pInicial, int boo) {                        // Retorna um valor boolean para palindromo ou nao -\- variavel pInicial e boo devem inicar com 0
    if (pInicial >= strlen(vect) / 2)
        return boo;
    else {
        if (vect[pInicial] == vect[(strlen(vect) - 2) - pInicial])
            return isPalindromo(vect, ++pInicial, boo);
        else
            return isPalindromo(vect, strlen(vect) - 1, 0);
    }
}

int main(){
    char frase[100];
    int boo;
    do{
        fgets(frase, sizeof(frase), stdin);
        setbuf(stdin, NULL);
        if(!(frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M')){
            boo = isPalindromo(frase, 0, 1);
            if(boo == 1)
            printf("SIM\n");
            else
            printf("NAO\n");
        }
    }while(!(frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M'));

    return 0;
}