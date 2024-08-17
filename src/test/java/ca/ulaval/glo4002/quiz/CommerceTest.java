package ca.ulaval.glo4002.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommerceTest {
    private static final String PRODUIT_TAXABLE = new String("livre");
    private static final String PRODUIT_NON_TAXABLE = new String("chaise");

    @Test
    void quandAjouterProduitTaxable_alorsCalculTaxes() {
        Commerce commerce = new Commerce();
        commerce.ajouterPanier(PRODUIT_TAXABLE, 1);
        assertEquals(34.5f, commerce.achats.total);
    }

    @Test
    void quandAjouterProduitNonTaxable_alorsPasDeTaxes() {
        Commerce commerce = new Commerce();
        commerce.ajouterPanier(PRODUIT_NON_TAXABLE, 1);
        assertEquals(20.0f, commerce.achats.total);
    }
}
