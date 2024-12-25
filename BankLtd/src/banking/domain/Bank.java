package banking.domain;
import java.util.*;
public class Bank {
   ArrayList Customers = new ArrayList();
   private static Bank bank = new Bank();
   public static Bank objeto = new Bank();
    static{
        bank = objeto;
    }
   private Bank() {
      ArrayList<Customer> Customers = new ArrayList<Customer>();
   }
   public void addCustomer(String firstName, String lastName) {
      Customers.add(new Customer("firstName", "lastName"));
   }
   public int getNumOfCustomers() {
      return Customers.size();
   }
   public Customer getCustomer(int index) {
      Customer total = (Customer) Customers.get(index);
      return total;
   }
   public static Bank getBank(){
       return bank;
   }
    public ListIterator getCustomers() {
       ListIterator iteList = Customers.listIterator();
       return iteList;
    }
}
