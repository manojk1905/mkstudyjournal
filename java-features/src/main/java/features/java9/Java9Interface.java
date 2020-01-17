package features.java9;

public interface Java9Interface {

	default void defaultMethod(){
		privateMethod();
    }
    
    static void defaultStaticMethod(){
    	privateStaticMethod();
    }
    
    private void privateMethod(){
        System.out.println("private method..");
    }
    
    private static void privateStaticMethod(){
    	 System.out.println("private static method..");
    }

}
