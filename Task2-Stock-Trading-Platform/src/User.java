import java.util.ArrayList;
public class User{
    String name;
    double balance;
    ArrayList<Holding> portfolio;

    ArrayList<Transaction>transactions;

    //constructor
    public User(String name,double balance){
        this.name=name;
        this.balance=balance;
        this.portfolio=new ArrayList<>();
         this.transactions=new ArrayList<>();
    }
}