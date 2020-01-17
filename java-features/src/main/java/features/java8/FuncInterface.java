package features.java8;

@FunctionalInterface
public interface FuncInterface {
    public void welcome(String name);
    
    public default void welcome(){
        System.out.println("welcome");
    }
    public static void welcomeStatic(){
        System.out.println("static welcome");
    }
}
