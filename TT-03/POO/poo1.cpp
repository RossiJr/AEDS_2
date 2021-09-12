#include <stdio.h>
#include <cstdlib>
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include "formas.h"
using namespace std;

Retangulo::Retangulo(double base, double altura){
    this->base = base;
    this->altura = altura;
}
double Retangulo::getArea(){
    double area = this->altura * this->base;
    return area;
}
double Retangulo::getPerimetro(){
    double perimetro = (this->altura*2) + (this->base*2);
    return perimetro;
}
double Retangulo::getDiagonal(){
    double diagonal = sqrt(pow(this->altura, 2) + pow(this->base, 2));
    return diagonal;
}

int main(){
    Retangulo *r1 = new Retangulo(10, 2);
    Retangulo *r2 = new Retangulo(20, 4);

    cout<<"\n"<<r2->getArea();
    cout<<"\n"<<r1->getArea();

    cout<<"\n"<<r2->getPerimetro();
    cout<<"\n"<<r1->getPerimetro();

    cout<<"\n"<<r2->getDiagonal();
    cout<<"\n"<<r1->getDiagonal();

    return 0;
}