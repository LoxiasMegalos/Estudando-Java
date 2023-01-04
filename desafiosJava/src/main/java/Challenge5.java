import java.util.Scanner;
public class Challenge5 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite qualquer coisa: ");
        String qualquerCoisa = entrada.next();
        String qualquerCoisaInvertida = "";
        for(int i = qualquerCoisa.length() - 1 ; i >= 0; i--){

            qualquerCoisaInvertida += qualquerCoisa.charAt(i);

        }
        System.out.println(qualquerCoisaInvertida);
    }
}
