public class three{

    
    public static void main(String [] args){
        int anoAtual;
        do{
            anoAtual = MyIO.readInt();
            if(anoAtual != 0){
                anoAtual += 76;
                MyIO.println(anoAtual);
            }

        }while(anoAtual != 0);
    }
}