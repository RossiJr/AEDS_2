#include <stdio.h>

int main(){
    int anoAtual;
        do{
            scanf("%d", &anoAtual);
            if(anoAtual != 0){
                anoAtual += 76;
                printf("%d", anoAtual);
            }

        }while(anoAtual != 0);

    return 0;
}