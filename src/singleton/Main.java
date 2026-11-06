package singleton;

// general implementation

class Singleton{
    private static Singleton instance;
    String data;
    
    private Singleton(String data){
        this.data = data;
    }
    
    public static Singleton getInstance(String data) {
        if(instance == null){
            synchronized (Singleton.class){
               if(instance == null){
                    instance = new Singleton(data);  
               }
            }
        }
        return instance;
    }
}
public class Main {

    public static void main(String[] args) {
        Singleton i = Singleton.getInstance("d1");
        System.out.println(i.data);
    }
    
}
