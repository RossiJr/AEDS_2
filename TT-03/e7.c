#include <stdio.h>
#include <string.h>
double somatorioPA(double a, double b, int n){
    return (n*a + n*a + b*n*n - n * b)/2;
}
int main(){
    printf("%lf", somatorioPA(2, 2, 100));




    return 0;
}