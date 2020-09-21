package Singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-21
 */
public class ProductC {
    private static ProductC product ;

    public static ProductC getInstance(){
        if (product ==null){
            synchronized (ProductC.class){
                if (product == null){
                    product = new ProductC();
                }
            }
        }
        return product;
    }
    private ProductC(){

    }
}
