import java.util.ArrayList;
import java.util.Scanner;
public class Challenge4 {

    static ArrayList<FaturamentoPorEstado> faturamentoPorEstados = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean operacao = true;
        while(operacao){

            System.out.println("(1) - Adicionar Estado");
            System.out.println("(2) - Calcular Percentual");
            System.out.println("(0) - Sair");

            switch (entrada.nextInt()) {
                case 1 -> {
                    System.out.print("Informe o Estado: ");
                    String estado = entrada.next();
                    System.out.print("Informe o Faturamento: ");
                    Double faturamento = entrada.nextDouble();
                    faturamentoPorEstados.add(new FaturamentoPorEstado(estado, faturamento));
                }
                case 2 -> {
                    if(faturamentoPorEstados.size() > 0){
                        calcularMedias();
                        break;
                    }
                    System.out.println("Impossivel calcular a media de 0 entradas!");
                }
                case 0 -> {
                    operacao = false;
                }
                default -> {
                    System.out.println("Opção Invalida!");
                }
            }
        }
        //System.out.println(faturamentoPorEstados);
    }

    private static void calcularMedias() {
        double totalFaturamento = 0.0;
        for(FaturamentoPorEstado estado : faturamentoPorEstados){
            totalFaturamento += estado.faturamento;
        }
        for(FaturamentoPorEstado estado : faturamentoPorEstados){
            Double porcentagem = (estado.faturamento / totalFaturamento) * 100;
            System.out.printf("Estado: %s - Percentual do faturamento no mes: %.0f%%\n", estado.estado,porcentagem);
        }
        System.out.println();
    }

    public record FaturamentoPorEstado(
         String estado,
         Double faturamento
    ){ }
}
