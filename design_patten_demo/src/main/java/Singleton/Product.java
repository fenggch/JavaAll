package Singleton;

/**
 * 懒汉式，线程不安全
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-21
 */
public class Product {
    private static Product product;

    public static Product getInstance(){
        if (product == null){
            product = new Product();
        }
        return product;
    }
    private Product(){
        this.name = this.getClass().getName();
    }
    String name;
}
