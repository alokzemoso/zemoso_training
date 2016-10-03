import java.util.*;

interface factory{
    public void login(String social_network_name);
}

public class fact implements factory{
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Choose log-in:(Facebook,Google,Linkedin,Twitter):");
        String x=inputReader.next();
        System.out.println(x.toLowerCase());
        factory o = new fact();
        o.login(x.toLowerCase());  
    }
        
    @Override
    public void login(String social_network_name) {
        
        switch(social_network_name)
        {
            case "facebook":
                System.out.println("You choose Facebook");
                break;
            case "google":
                System.out.println("You choose Google");
                break;
            case "linkedin":
                System.out.println("You choose Linkedin");
                break;
            case "twitter":
                System.out.println("You choose Twitter");
                break;
            default:
                System.out.println("Wrong choice!!");
    
        }
    }
    
}
