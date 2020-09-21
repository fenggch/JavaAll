package StaticFactoryMethod;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-18
 */
public class StaticFactoryMethodMain {
    public static void main(String[] args) {
        Product a = SimpleFactory.GetProduct("B");
        a.MethName();
        a.MethodDiff();

    }
}
