package ca.ulaval.glo4002.quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Commerce {
    private final Map<String, Float> listePrix = Map.of(
        "toutou", 10.0f,
        "chaise", 20.0f,
        "livre", 30
    );

    final PanierClient achats = new PanierClient();

    public void ajouterPanier(String codeProduit, int quantite) {
        float prix = listePrix.get(codeProduit);
        float taxes = 0;

        if (codeProduit == "livre") {
            taxes = Config.POURCENT_TAXES;
        }

        float total = prix * quantite + (prix * quantite * taxes);

        achats.articles.put(codeProduit, quantite);
        achats.total += total;
    }

    public List<String> creerListeArticlesSurFacture() {
        List<String> articles = new LinkedList<>();

        achats.articles.forEach((codeProduit, quantite) -> {
            float prix = listePrix.get(codeProduit);
            String ligneArticle = codeProduit + " .... x" + quantite + " .... " + prix;
            if (codeProduit == "livre") {
                ligneArticle += " + taxes";
            }
            articles.add(ligneArticle);
        });

        articles.add(""); // ligne vide
        articles.add("Total: " + achats.total);

        return articles;
    }
}
