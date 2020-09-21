package StaticFactoryMethod;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-18
 */
public abstract class Product {
    public void MethName(){
        System.out.println(this.getClass().getName());
    }
    public abstract void MethodDiff();
   //声明抽象业务方法
}
