package com.example.Web.Scraping.NFL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoWebScrapping {

    public static void main(String[] args) throws IOException {

        //1 - URL do site a ser acessado
        String url = "https://www.nfl.com/stats/player-stats/";

        //2 - Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();

        //3 - Obtendo a tabela através de sua classe
        Element table = doc.getElementsByClass("d3-o-table d3-o-table--detailed d3-o-player-stats--detailed d3-o-table--sortable").first();

        //4 - Otendo o corpo da tabela através da tag
        Element tbody = table.getElementsByTag("tbody").first();

        //5 - Criando uma lista de todos os tr's do tbody obtido
        List<Element> players = tbody.getElementsByTag("tr");

        //6 - Criando uma lista vazia para guardar os dados dos tr's convertidos
        List<Passing> playersObjects = new ArrayList<>();

        // 7 - Iterando por cada tr e convertendo em um Passing. Em seguida inserindo-o na lista de Passings
        for (Element player : players) {
            // Listando todos os atributos do td em questão
            List<Element> attributes = player.getElementsByTag("td");
            // Criando o objeto e inserindo nele os atributos extraídos do td
            Passing passing = new Passing(
                    attributes.get(0).text(),
                    attributes.get(1).text(),
                    attributes.get(2).text(),
                    attributes.get(3).text()

            );
            // Adicionando o objeto na lista de objetos Passing
            playersObjects.add(passing);
        }
        // Por fim, convertemos os objetos do tipo Passing para Json, facilitando a leitura dos dados obtidos do site
        for (Passing passing : playersObjects) {
            converterToJson(passing);
        }

    }

    private static void converterToJson(Passing passing) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(passing);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
