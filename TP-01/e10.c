#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


int main(){
    int n;
    double aux;
    double scan;

    FILE * arq = fopen("saida.txt", "wb");
    
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        scanf("%lf", &aux);
        fwrite(&aux, sizeof(double), 1, arq);
    }
    fclose(arq);

    FILE * arqNovo = fopen("saida.txt", "r");

    for(int i=1; i<=n; i++){
        fseek(arqNovo,-i*(sizeof(double)),SEEK_END);
        fread(&scan, sizeof(double), 1, arqNovo);
        printf("%g\n", scan);
    }
    
    fclose(arqNovo);
    return 0;
}