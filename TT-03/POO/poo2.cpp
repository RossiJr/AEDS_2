#include <math.h>

class Ponto{
    private:
    double x;
    double y;
    int id;
    int static nextID = 0;

    public:
    Ponto();
    Ponto(double x, double y);
    void alterarId();
    int getId();
    static void alterarNextID();
    int getNextId();
    void setX(double valor);
    double getX();
    void setY(double valor);
    double getY();
    double dist(double ponto2);
    double dist(Ponto ponto);
    int isTriangulo(Ponto ponto1, Ponto ponto2, Ponto ponto3);
    double getAreaRetangulo(Ponto ponto);
};

    Ponto::Ponto(){
        this->x = 0;
        this->y = 0;
    }
    Ponto::Ponto(double x, double y){
        this->x = x;
        this->y = y;
    }
    void Ponto::alterarId(){
        this->id = this->nextID;
        Ponto::alterarNextID();
    }
    int Ponto::getId(){
        return this->id;
    }
    void Ponto::alterarNextID(){
        nextID++;
    }
    int Ponto::getNextId(){
        return this->nextID;
    }
    double Ponto::dist(double ponto2){
        return this->x - ponto2;
    }
    double Ponto::dist(Ponto ponto){
        return this->x - ponto.getX();
    }
    int Ponto::isTriangulo(Ponto ponto1, Ponto ponto2, Ponto ponto3){
        if(ponto1.getX() > abs(ponto2.getX() - ponto3.getX()) && ponto1.getX() < ponto2.getX() + ponto3.getX()){
            if (ponto2.getX() > abs(ponto1.getX() - ponto3.getX()) && ponto2.getX() < ponto1.getX() + ponto3.getX()){
                if(ponto3.getX() > abs(ponto1.getX() - ponto2.getX()) && ponto3.getX() < ponto1.getX() + ponto2.getX())
                return 1;
                else
                return 0;
            }
            else
            return 0;
        }
        else
        return 0; 
    }
    double Ponto::getAreaRetangulo(Ponto ponto){
        return ponto.getX()*ponto.getY();
    }
