import java.lang.Math;

public class recursivo {
    public static void charFy(char[] stringVetor, String word) { // Transforma a string em um vetor de caracteres
        for (int i = 0; i < word.length(); i++) {
            stringVetor[i] = word.charAt(i);
        }
    }

    public static boolean isVogal(char caracter) { // Retorna um valor boolean indicando se é ou nao vogal
        if ((caracter == 'a' || caracter == 'A') || (caracter == 'e' || caracter == 'E')
                || (caracter == 'i' || caracter == 'I') || (caracter == 'o' || caracter == 'O')
                || (caracter == 'u' || caracter == 'U'))
            return true;

        return false;
    }

    public static boolean isMinuscula(char caracter) { // Retorna um valor boolean indicando se é ou não minuscula
        if (caracter >= 97 && caracter <= 122)
            return true;

        return false;
    }

    public static int maiorElemento(int[] vetor, int tamanho, int maior) { // Retorna o maior elemento
        if (tamanho == 0)
            return maior;

        else {
            if (vetor[tamanho] > maior)
                maior = vetor[tamanho];
            return maiorElemento(vetor, --tamanho, maior);
        }
    }

    public static boolean isPalindromo(char[] vect, int pInicial, boolean boo) { // Retorna um valor boolean para
                                                                                 // palindromo ou nao
        if (pInicial >= vect.length / 2)
            return boo;
        else {
            if (vect[pInicial] == vect[(vect.length - 1) - pInicial])
                return isPalindromo(vect, ++pInicial, boo);
            else
                return isPalindromo(vect, vect.length - 1, false);
        }
    }

    public static int quantidadeVogais(char[] frase, int tamanho, int vogais) { // Retorna um valor indicando a
                                                                                // quantidade de vogais na frase
        if (isVogal(frase[tamanho])) // O metodo isVogal retorna um valor do tipo boolean indicando se o char é vogal
            ++vogais;

        if (tamanho == 0)
            return vogais;
        else
            return quantidadeVogais(frase, --tamanho, vogais);
    }

    public static int quantidadeMinusculas(char[] frase, int tamanho, int qtd) { // Retorna a quantidade de minusculas
                                                                                 // na frase
        if (isMinuscula(frase[tamanho])) // Este metodo retorna um valor boolean indicando se e minuscula
            ++qtd;

        if (tamanho == 0)
            return qtd;
        else
            return quantidadeMinusculas(frase, --tamanho, qtd);
    }

    public static int ordenacao(int[] array, int pos) { // Ordena o array de forma crescente
        int menor = array[pos];
        int aux = pos;

        for (int i = pos + 1; i < array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
                aux = i;
            }
        }
        array[aux] = array[pos];
        array[pos] = menor;

        if (pos == array.length - 1)
            return 0;
        else
            return ordenacao(array, ++pos);
    }

    public static int e1(int n) { // Retorna a conta maluca - no final sempre da 0
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else {
            return e1(n - 1) * e1(n - 2) - e1(n - 1);
        }
    }

    public static int e2(int n) { // Retorna a conta solicitada
        if (n == 0)
            return 1;
        else
            return (int) Math.pow((n - 1), 2);
    }

    public static void main(String[] args) {
        int n = MyIO.readInt();
        // int[] array = new int[n];

        // for(int i=0; i<n; i++)
        // array[i] = MyIO.readInt();

        // MyIO.println(ordenacao(array, 0));

        // for(int i=0; i<n; i++)
        MyIO.println(e2(n));
    }
}
