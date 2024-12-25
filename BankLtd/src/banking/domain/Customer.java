package banking.domain;
import java.util.*;

public class Customer {
   private String firstName;
   private String lastName;
   ArrayList accounts = new ArrayList();
   public Customer(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
      ArrayList accounts = new ArrayList();
   }
   public String getFirstName() {
      return firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public Account getAccount(int n) {
      return (Account) accounts.get(n);
   }
   public void addAccount(Account account) {
      accounts.add(account);
   }
   public int getNumOfAccounts() { 
      return accounts.size();
   }
   public ListIterator getAccounts(){
       ListIterator iteList = accounts.listIterator();
       return iteList;
   }
}
