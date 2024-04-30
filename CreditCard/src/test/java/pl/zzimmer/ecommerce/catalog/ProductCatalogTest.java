package pl.zzimmer.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {
    @Test
    void itListsProducts(){
        ProductCatalog catalog = getProductCatalog();

        List<Product> productList = catalog.allProducts();

        assertThat(productList).hasSize(0);
    }

    private static ProductCatalog getProductCatalog() {
        ProductCatalog catalog = new ProductCatalog(new ArrayListProductStorage());
        return catalog;
    }

    @Test
    void itAllowsToAddProducts() {
        ProductCatalog catalog = getProductCatalog();

        catalog.addProduct("Lego set 8083", "Nice one");

        List<Product> productList = catalog.allProducts();
        assertThat(productList).hasSize(1);
    }

    @Test
    void itLoadsProductsDetails() {
        ProductCatalog catalog = getProductCatalog();
        String id = catalog.addProduct("Lego det 8083", "Nice on");

    Product loadedProduct = catalog.getProductBy(id);
    assertThat(id).isEqualTo(loadedProduct.getId());
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = getProductCatalog();
        String id = catalog.addProduct("Lego det 8083", "Nice on");


        catalog.changePrice(id, BigDecimal.valueOf(10.10));

        Product loadedProduct = catalog.getProductBy(id);
        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loadedProduct.getPrice());
    }
}
