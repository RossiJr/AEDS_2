#include <stdio.h>


int main(){
    int idades[4];
    do{
        if(idades[0] != 0){
            for(int i=0; i<3; i++){
                scanf("%d", &idades[i]);
            if(idades[0] == 0)
                break;
                }
                idades[3] = idades[0] - (idades[1] + idades[2]);
                if(idades[0] != 0){
                if(idades[1] > idades[2] && idades[1] > idades[3])
                printf("%d\n", idades[1]);
                else if(idades[2] > idades[1] && idades[2] > idades[3])
                printf("%d\n", idades[2]);
                else
                printf("%d\n", idades[3]);
            }
        }
    }while(idades[0] != 0);

    return 0;
}