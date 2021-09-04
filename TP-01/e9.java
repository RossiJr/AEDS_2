import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;


public class e9{


    public static void main(String [] args) throws IOException{
        RandomAccessFile arq = new RandomAccessFile("saida.txt", "rw");
        int n = MyIO.readInt();

        for(int i=0; i<n; i++){
            arq.seek(i * 8);
            arq.writeDouble(MyIO.readDouble());
        }
        arq.close();

        RandomAccessFile arqNovo = new RandomAccessFile("saida.txt", "r");

        for(int i=n-1; i>-1; i--){
            arqNovo.seek(i*8);
            MyIO.println(arqNovo.readDouble());
        }

        arqNovo.close();
    }


}