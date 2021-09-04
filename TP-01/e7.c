#include <stdio.h>
#include <string.h>

int onlyVogal(char* string){
    int valor = 1;
    for(int i=0; i<strlen(string)-1; i++){
        if(!(((int)string[i] == 'A' || (int)string[i] == 'a') || ((int)string[i] == 'E' || (int)string[i] == 'e') || ((int)string[i] == 'I' || (int)string[i] == 'i') || ((int)string[i] == 'O' || (int)string[i] == 'o') || ((int)string[i] == 'U' || (int)string[i] == 'u')))
        valor = 0;
    }
    return valor;
}
int onlyConsoantes(char* string){
    int valor = 1;
    for(int i=0; i<strlen(string)-1; i++){
        if(!(((int)string[i] >= 65 && (int)string[i] <= 90) || ((int)string[i] >= 97 && (int)string[i] <= 122))) {
            valor = 0;
        }
        if((((int)string[i] == 'A' || (int)string[i] == 'a') || ((int)string[i] == 'E' || (int)string[i] == 'e') || ((int)string[i] == 'I' || (int)string[i] == 'i') || ((int)string[i] == 'O' || (int)string[i] == 'o') || ((int)string[i] == 'U' || (int)string[i] == 'u')))
            valor = 0;
    }
    return valor;
}
int inteiro(char* string){
    int valor = 1;
    for(int i=0; i<strlen(string)-1; i++){
        if((int)string[i] < 47 || (int)string[i] > 57)
            valor = 0;
    }
    return valor;
}
int real(char* string){
    int valor = 1;
    int cont = 0;
    for(int i=0; i<strlen(string)-1; i++){
        if(((int)string[i] < 47 && (int)string[i] != ',' && (int)string[i] != '.') || (int)string[i] > 57)
            valor = 0;
        if((int)string[i] == '.' || (int)string[i] == ',')
            ++cont;
    }
    if(cont > 1)
        valor = 0;

    return valor;
}

int main(){
    char string[150];
    int boo[4];

    do{
        fgets(string, sizeof(string), stdin);
        setbuf(stdin, NULL);
        if(!(string[0] == 'F' && string[1] == 'I' && string[2] == 'M')){
            boo[0] = onlyVogal(string);
            boo[1] = onlyConsoantes(string);
            boo[2] = inteiro(string);
            boo[3] = real(string);

            for(int i=0; i<4; i++){
                if(boo[i])
                printf("SIM ");
                else
                printf("NAO ");
            }
        printf("\n");
        }
    }while(!(string[0] == 'F' && string[1] == 'I' && string[2] == 'M'));



    return 0;
}