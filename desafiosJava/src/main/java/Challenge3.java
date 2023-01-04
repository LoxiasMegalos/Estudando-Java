import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Challenge3 {

    static ArrayList<Json> faturamentoDia = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("D:\\Murilo\\Desktop\\projetinhosjava\\desafiosJava\\src\\main\\java\\dados.json");

        Object obj = jsonParser.parse(reader);
        JSONArray listaFaturamento = (JSONArray) obj;

        listaFaturamento.forEach(dado -> listaFaturamentoObjeto((JSONObject) dado));
        getMenorValor();
        getMaiorValor();
        diasMaioresQueAMedia();
    }

    private static void diasMaioresQueAMedia() {
        int quantidadeDeDiasDeTrabalho = 0;
        Double totalDeFaturamento = 0.0;
        int numeroDeDiasMaioresQueMedia = 0;

        for(Json diaTrabalho : faturamentoDia){
            if(diaTrabalho.valor != 0.0){
                quantidadeDeDiasDeTrabalho += 1;
                totalDeFaturamento += diaTrabalho.valor;
            }
        }
        Double media = totalDeFaturamento / quantidadeDeDiasDeTrabalho;

        for(Json diaTrabalho : faturamentoDia){
            if(diaTrabalho.valor > media){
                numeroDeDiasMaioresQueMedia += 1;
            }
        }

        System.out.printf("Media de faturamento mensal foi de: %.2fR$ E a quantidade de dias com o faturamento superior a esse valor foram: %d\n",media,numeroDeDiasMaioresQueMedia);
    }

    private static void getMaiorValor() {
        Double maiorValor = 0.0;
        Long diaDoMaiorValor = Long.valueOf(0);

        for(Json diaTrabalho : faturamentoDia){
            if(diaTrabalho.valor != 0.0 && diaDoMaiorValor == 0){
                maiorValor = diaTrabalho.valor;
                diaDoMaiorValor = diaTrabalho.dia;
            }
            if(diaTrabalho.valor != 0.0 && diaTrabalho.valor > maiorValor){
                maiorValor = diaTrabalho.valor;
                diaDoMaiorValor = diaTrabalho.dia;
            }
        }
        System.out.printf("Nesse mes o dia com o maior faturamento foi: %d No valor de: %.2fR$\n", diaDoMaiorValor,maiorValor);
    }

    private static void getMenorValor() {
        Double menorValor = 0.0;
        Long diaDoMenorValor = Long.valueOf(0);
        for(Json diaTrabalho : faturamentoDia){
            if(diaTrabalho.valor != 0.0 && diaDoMenorValor == 0){
                menorValor = diaTrabalho.valor;
                diaDoMenorValor = diaTrabalho.dia;
            }
            if(diaTrabalho.valor != 0.0 && diaTrabalho.valor < menorValor){
                menorValor = diaTrabalho.valor;
                diaDoMenorValor = diaTrabalho.dia;
            }
        }
        System.out.printf("Nesse mes o dia com o menor faturamento foi: %d No valor de: %.2fR$\n", diaDoMenorValor,menorValor);
    }


    private static void listaFaturamentoObjeto(JSONObject dado){
        Json faturamento = new Json((Long) dado.get("dia"), (Double) dado.get("valor"));
        faturamentoDia.add(faturamento);
    }

    public record Json(
        Long dia,
        Double valor
    ) { }
}
