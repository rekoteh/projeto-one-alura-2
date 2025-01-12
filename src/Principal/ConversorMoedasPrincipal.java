package Principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoedasPrincipal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String chave = ""; //Adicionar chave API
        String prompt = "-> ";
        String sair = "SAIR";


        System.out.println("""
                --Tabela de Valores para Conversão--
                Dolar = USD;
                Euro = EUR;
                Japão = JPY;
                Rublo = RUB;
                Peso Comlombiano = COP;
                Real Brasileiro  = BRL;
                """);
        System.out.println("Digite a moeda desejada para conversão (ou sair)");
        System.out.print(prompt);
        String codigoOrigem = leitura.nextLine().trim().toUpperCase();

        if (codigoOrigem.equals(sair)) {
            System.out.println("Programa finalizado com sucesso!");
            System.out.println("Até Mais...");
            return;
        }

        System.out.println("Digite para qual moeda deseja converter: ");
        System.out.print(prompt);
        String codigoDestino = leitura.nextLine().trim().toUpperCase();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", chave, codigoOrigem)))
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200)  {
            System.out.println(" Erro na MoedaOrigem! ");
            System.out.println("Código não suportado!");
            return;
        }

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        var conversionRates = gson.fromJson(response.body(), ExchangeRateApiResponse.class).getConversionRates();

        var taxaDeCambio = conversionRates.get(codigoDestino);

        if (taxaDeCambio == null) {
            System.out.println("Erro na MoedaDestino!");
            System.out.println("Código não suportado!");
            return;
        }

        System.out.println("Qual é o valor que deseja converter? ");
        System.out.print(prompt);
        Double valorMoedaOrigem = leitura.nextDouble();

        Double moedaDestino = valorMoedaOrigem * taxaDeCambio;
        System.out.printf("Valor Convertido: %.2f%n", moedaDestino);
        System.out.println("Programa Finalizado com Sucesso!");
        //moedaDestino =  valor da moedaOrigem multiplicado pela taxaDeCambio
    }
}

