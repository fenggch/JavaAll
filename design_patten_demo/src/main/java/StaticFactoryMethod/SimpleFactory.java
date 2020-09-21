package StaticFactoryMethod;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-18
 */
public class SimpleFactory {

    public static Product GetProduct(String arg){
        String str = "world";
        switch (arg){
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return null;

        }
    }
}
