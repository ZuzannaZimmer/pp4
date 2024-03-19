package pl.zzimmer.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {
    @Test
    void itListsProducts(){
        ProductCatalog catalog = new ProductCatalog();

        List<Product> productList = catalog.allProducts();

        assertThat(productList).hasSize(0);
    }

    @Test
    void itAllowsToAddProducts() {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct("Lego set 8083", "Nice one");

        List<Product> productList = catalog.allProducts();
        assertThat(productList).hasSize(1);
    }

    @Test
    void itLoadsProductsDetails() {
    ProductCatalog catalog = new ProductCatalog();
    String id = catalog.addProduct("Lego det 8083", "Nice on");

    Product loadedProduct = catalog.getProductBy(id);
    assertThat(id).isEqualTo(loadedProduct.getId());
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Lego det 8083", "Nice on");


        catalog.changePrice(id, BigDecimal.valueOf(10.10));

        Product loadedProduct = catalog.getProductBy(id);
        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loadedProduct.getPrice());
    }
}
