package service;

import api.ProductService;
import org.junit.Assert;
import org.junit.Test;
import src.Boots;
import src.Cloth;
import src.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProductPositive(){
        List<Product> list = new ArrayList<Product>();
        list.add(new Cloth(1L, "Spodnie", 142.2f, 1, "niebieskie", 4, "M", "bawelna"));
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10,  36, true));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(list));
        List<Product> resultList = productService.getAllProducts();

        Assert.assertEquals(list, resultList);
    }

    @Test
    public void testGetAllProductNegative(){
        List<Product> list = new ArrayList<Product>();
        list.add(new Cloth(1L, "Spodnie", 142.2f, 1, "niebieskie", 4, "M", "bawelna"));
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10,  36, true));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(list));
        List<Product> resultList = productService.getAllProducts();

        list.add(new Boots(3L, "trampki", 20, 3, "niebieskie", 4, 40, false));
        Assert.assertNotEquals(list, resultList);
    }

    @Test
    public void testGetCountProductsWithProducts(){
        List<Product> list = new ArrayList<Product>();
        list.add(new Cloth(1L, "Spodnie", 142.2f, 1, "niebieskie", 4, "M", "bawelna"));
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10,  36, true));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(list));
        int result = productService.getCountProducts();

        Assert.assertEquals(list.size(), result);
    }

    @Test
    public void testGetCountProductsWithoutProducts(){
        List<Product> list = new ArrayList<Product>();

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(list));
        int result = productService.getCountProducts();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByNameWhenExist(){
        List<Product> list = new ArrayList<Product>();
        Product kozaki = new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10,  36, true);
        list.add(kozaki);
        list.add(new Cloth(1L, "Spodnie", 142.2f, 1, "niebieskie", 4, "M", "bawelna"));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(list));
        final Product result = productService.getProductByName("kozaki");

        Assert.assertEquals(kozaki, result);

    }

    @Test
    public void testGetProductByNameWhenNotExist(){
        List<Product> list = new ArrayList<Product>();
        Product kozaki = new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10,  36, true);
        list.add(kozaki);
        list.add(new Cloth(1L, "Spodnie", 142.2f, 1, "niebieskie", 4, "M", "bawelna"));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(list));
        final Product result = productService.getProductByName("noname");

        Assert.assertEquals(null, result);

    }

    @Test
    public void testIsProductOnWarehouseWhenIs(){
        List<Product> list = new ArrayList<Product>();
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10,  36, true));

        ProductServiceImpl productService = new ProductServiceImpl(list);
        boolean result = productService.isProductOnWarehouse("kozaki");

        Assert.assertTrue(result);
    }

    @Test
    public void testIsProductOnWarehouseWhenIsNot() {
        List<Product> list = new ArrayList<Product>();
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 0, 36, true));

        ProductServiceImpl productService = new ProductServiceImpl(list);
        boolean result = productService.isProductOnWarehouse("kozaki");

        Assert.assertFalse(result);
    }

    @Test
    public void testIsProductByNameExistWhenIs() {
        List<Product> list = new ArrayList<Product>();
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10, 36, true));

        ProductServiceImpl productService = new ProductServiceImpl(list);
        boolean result = productService.isProductExist("kozaki");

        Assert.assertTrue(result);
    }

    @Test
    public void testIsProductExisByNametWhenIsNot(){
        List<Product> list= new ArrayList<Product>();
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10, 36, true));

        ProductServiceImpl productService = new ProductServiceImpl(list);
        boolean result = productService.isProductExist("kalosze");

        Assert.assertFalse(result);
    }

    @Test
    public void testIsProductExisByIdtWhenIs() {
        List<Product> list = new ArrayList<Product>();
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10, 36, true));

        ProductServiceImpl productService = new ProductServiceImpl(list);
        boolean result = productService.isProductExist(2L);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsProductExisByIdtWhenIsNot(){
        List<Product> list= new ArrayList<Product>();
        list.add(new Boots(2L, "kozaki", 56.3f, 2, "czarne", 10, 36, true));

        ProductServiceImpl productService = new ProductServiceImpl(list);
        boolean result = productService.isProductExist(1L);

        Assert.assertFalse(result);
    }
}
