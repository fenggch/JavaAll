package Singleton;

/**
 * 懒汉式，线程安全
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-21
 */
public class ProductA {
    private static ProductA product;
    public static synchronized ProductA getInstance(){
        if (product == null){
            product = new ProductA();
        }
        return product;
    }
    private ProductA(){

    }
}
