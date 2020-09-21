package Singleton;

/**
 * 饿汉式，线程安全
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-21
 */
public class ProductB {
    private static ProductB product = new ProductB();

    public static  ProductB getInstance(){

        return product;
    }
    private ProductB(){

    }
}
