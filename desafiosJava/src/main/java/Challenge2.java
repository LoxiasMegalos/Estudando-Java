
import java.util.Scanner;

public class Challenge2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();

        int anterior = 0;
        int proximo = 1;
        int temporario;
        boolean pertence = false;

        while(true){

            if(numero == anterior || numero == proximo){
                pertence = true;
                break;
            }

            if(proximo > numero){
                break;
            }

            temporario = proximo;
            proximo = anterior + proximo;
            anterior = temporario;
        }

        System.out.println(pertence);
    }

}
