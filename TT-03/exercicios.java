public class exercicios {
    public static boolean busca(int[] array, int elemento){                         //Realiza a busca sequencial pelo elemento no array e retorna true ou false
        for(int i=0; i<array.length; i++){
            if(array[i] == elemento)
                return true;
        }
        return false;
    }
    public static boolean buscaBinaria(int[] array, int elemento){                  //Realiza uma busca binária pelo elemento no array e retorna true ou false
        int meio;
        int limiteS = array.length-1;
        int limiteI = 0;

        while(limiteI <= limiteS){
            meio = (limiteS+limiteI)/2;
            if(elemento == array[meio])
                return true;
            if(elemento < array[meio])
                limiteS = meio - 1;
            else
                limiteI = meio + 1;
        }
        return false;
    }
    public static void maiorMenor(int[] array){                                     //Imprime o maior e o menor elemento do array no terminal
        int menor = array[0];
        int maior = menor;

        for(int i=0; i<array.length; i++){
            if(array[i] > maior)
                maior = array[i];
            if(array[i] < menor)
                menor = array[i];
        }
        MyIO.println("Maior: " + maior);
        MyIO.println("Menor: " + menor);
    }

    public static void main(String[] args){}
}

