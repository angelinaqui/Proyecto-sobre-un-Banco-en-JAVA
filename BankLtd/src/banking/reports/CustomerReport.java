package banking.reports;
import banking.domain.*;
import java.text.NumberFormat;
import java.util.*;
public class CustomerReport {
   public void generateReport() {
      NumberFormat currency_format = NumberFormat.getCurrencyInstance();
      /**
       * * Paso1: obtenga el objeto bank **
       */
      Bank bank = Bank.getBank();
      Customer customer;
      System.out.println("\t\t\tREPORTE DE CLIENTES");
      System.out.println("\t\t\t===================");
      ListIterator iteList = bank.getCustomers();
      while (iteList.hasNext()) {
         Object cust_idx = iteList.next();
         customer = bank.getCustomer((int)cust_idx);
         System.out.println();
         System.out.println("Customer: " + customer.getLastName() + ", "  + customer.getFirstName());
         ListIterator iteLista = customer.getAccounts();
         while (iteLista.hasNext()) {
            Object acct_idx = iteList.next();
            Account account = customer.getAccount((int) acct_idx);
            String account_type = "Desconocida";
            if(account instanceof SavingsAccount) {
               account_type = "Savings Account";
            } else if ( account instanceof CheckingAccount ) {
	  account_type = "Checking Account";
	} else {
	  account_type = "Unknown Account Type";
	}
            // Print the current balance of the account
            System.out.println("    " + account_type + ": su saldo es de "
                  + currency_format.format(account.getBalance()));
         }
      }
   }
}
