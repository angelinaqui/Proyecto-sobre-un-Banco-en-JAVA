package banking.data;
import banking.domain.*;
import java.io.*;
import java.util.Scanner;
public class DataSource{
    private File dataFile;
    public DataSource (String dataFilePath) {
    this.dataFile = new File(dataFilePath);
    }
    public void loadData()throws FileNotFoundException{
    banking.domain.Bank bank = banking.domain.Bank.getBank();
    Scanner sc = new Scanner(dataFile);
    Customer customer;
    int numOfCustomers = sc.nextInt();
      for (int i = 0; i < numOfCustomers; i++) {
         String firstName = sc.next();
         String lastName = sc.next();
         bank.addCustomer(firstName, lastName);
         customer = bank.getCustomer(i);
         int numOfAccounts = sc.nextInt();
         for (int j = 0; j < numOfAccounts; j++) {
            String accountType = sc.next();
            if (accountType.equals("S")) {
               float balance = sc.nextFloat();
               float interestRate = sc.nextFloat();
               customer.addAccount(new SavingsAccount(balance, interestRate));
            }
            if (accountType.equals("C")) {
               float balance = sc.nextFloat();
               float overdraftProtection = sc.nextFloat();
               customer.addAccount(new CheckingAccount(balance, overdraftProtection));
            }
         }
      }
   }
}
