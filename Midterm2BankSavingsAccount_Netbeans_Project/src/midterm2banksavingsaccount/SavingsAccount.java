//Mickie Blair
//Midterm Project Part 2- Bank Account and Savings Account
//SavingsAccount Class

package midterm2banksavingsaccount;

import javax.swing.JOptionPane;

public class SavingsAccount extends BankAccount {
    //fields
    boolean inactive;
    
    /**
     * Constructor
     * @param b Balance
     * @param rate Annual Interest Rate
     */
    public SavingsAccount(double b, double rate){
        super(b,rate);
    }
    
    //set status
    public void setStatus(){
        this.inactive = getBalance()< 25.00;          
    }
    
    /**
     * 
     * @return Status
     */
    public boolean getStatus(){
        return this.inactive;
    }
    
    /**
     * Make Withdrawal overriding Bank Account
     * @param w Withdrawal amount
     */
    @Override
    public void withdraw(double w){
       if (!this.inactive)
       {
           super.withdraw(w);
       }
        
    }
    
    /**
     * Make Deposit overriding Bank Account
     * @param d Withdrawal amount
     */
    @Override
    public void deposit(double d){
       
        if (!this.inactive)
        {
            super.deposit(d);
        }
            
        else    
        {
            if (d + super.getBalance() >= 25.00)
            {
                super.deposit(d);
                setStatus();
                
                JOptionPane.showMessageDialog(null, "The deposit of $" + d 
                        + " has reactivated the account."
                    );
            }
             
            else
            {
                super.deposit(d);
                
                JOptionPane.showMessageDialog(null, "The account is still inactive.\n"
                    + "\nBalance must be greater than $25.00 to become active."
                    +"\n Please deposit $" + (25.00 - super.getBalance()) + "to "
                            + "activate the account.");
            }
        }
    }
    
    //End of month processing overriding bank account
    @Override
    public void monthlyProcess(){

        if (super.getNumOfWithdrawals() > 4)
        {
            super.setMonthlyServiceCharges((super.getNumOfWithdrawals()-4) * 1);
        }

        super.monthlyProcess();
        
        setStatus();
        
    }
    
    //to string overriding bank account
    @Override
    public String toString(){
        String status;
        
        if (this.inactive)
        {
            status = "Inactive";
        }
        
        else
        {
            status = "Active";
        }
        
        String str =String.format("%-35s%11s\n%-35s$%10.2f",
                "Account Status (End of Month):", status,
                "Ending Balance:", super.getBalance());
        
        return str;
    }
}
