package banking.domain;
public class CheckingAccount extends Account {
   private double overdraftProtection;
   public CheckingAccount(double balance) {
      super(balance);
   }
   public CheckingAccount(double balance, double protect) {
      super(balance);
      this.overdraftProtection = protect;
   }
   @Override
   public void withdraw(double amount) throws OverdraftException {
      if (balance < amount) {
         System.out.println("No hay fondos suficientes para cubrir  $" + amount + ". El saldo es  $" + balance);
         if ((balance + overdraftProtection) < amount) {
            throw new OverdraftException("Fondos insuficientes para el overdraft protection",overdraftProtection);
         } else {
            System.out.println("Pero hay overdraft protection por $" + overdraftProtection);
            overdraftProtection = (balance + overdraftProtection) - amount;
            balance = 0.0;
         }
      } else {
         balance -= amount;
      }
   }
}
