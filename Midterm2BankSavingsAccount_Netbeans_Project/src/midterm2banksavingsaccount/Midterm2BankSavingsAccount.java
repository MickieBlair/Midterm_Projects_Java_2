//Mickie Blair
//Midterm Project Part 2- Bank Account and Savings Account
//Demo Program

package midterm2banksavingsaccount;


import javax.swing.JOptionPane;

public class Midterm2BankSavingsAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //show introduction
        showIntro();
        
        //repeat program method
        repeatProgram();
    }
    
   //show introduction to the program
    public static void showIntro(){
        JOptionPane.showMessageDialog(null, "Bank Program\n"
                  + "\nThe program will allow a user to enter a savings account\n"
                  + "balance and annual interest rate\n"
                  + "\nThe user will be able to deposit and withdraw funds if"
                  + "\nthe account is active (Balance must be greater than $25.00.)"
                  + "\n\nMonthly Service charges will be calculated at the end"
                  + "\nof every month and the balance displayed.\n");
    }
    
    //repeat program
    public static void repeatProgram(){
        String again;           //variable for do again
                
        //loop to do again
        do
        {
            //do this again
            bankAccountDemo();
            
            //ask the user if they would like to run the program again
            again = JOptionPane.showInputDialog("\nWould you like to run "
                        + "the program again? (Enter Y or N):  ");
            

            //verify input        
            while ((!again.equalsIgnoreCase("Y")) 
                    && (!again.equalsIgnoreCase("N"))){

                again = JOptionPane.showInputDialog("\nInvalid Entry\n"
                    + "Would you like to run the program again? "
                    + "(Enter Y or N):  ");
                
            }
        }
 
        while (again.equalsIgnoreCase("Y"));
        
        System.exit(0);
    }
    
    //bank account and saving account demo program
    public static void bankAccountDemo(){
        String newMonth;            //variable for new month
        String newTransaction;      //variable for new transaction
        int option;                 //variable for transaction option
        double startingBalance;     //Starting Balance
        int numOfMonth = 1;         //number of months
        double annualRate;          //annual interest ratea
        double withdrawal;          //withdrawal amount
        String input;               //input variable
        
        //get starting balance
        startingBalance = getStartingBalance();

        //get the annual interest rate
        annualRate = getAnnualInterestRate();

        //create a savings account object
        SavingsAccount account = new SavingsAccount(startingBalance, annualRate);

        //set status of account
        account.setStatus();

        System.out.printf("%-34s $%10.2f\n", "Starting Balance", account.getBalance());
        System.out.printf("%-33s %11.1f%%\n", "Annual Interest Rate", account.getAnnualInterestRate()*100);

        //again loop for new account
        do
            {
                //Month number
                System.out.println("\nMonth " + numOfMonth);

                //loop for more transactions
                do
                {
                    //get the transaction type
                    option=getTransactionOption();  

                    //switch for transaction
                    switch(option)
                    {
                        case 1: 
                        {
                            //call method to get deposit amount and make deposit
                            account.deposit(makeDeposit());

                            break;
                        }

                        case 2: 
                        {
                            //if account is inactive no withdrawal allowed
                            if (account.getStatus())
                            {
                                JOptionPane.showMessageDialog(null, "The account is inactive.\n"
                                                    + "\nNo Funds may be withdrawn."
                                                    + "\n Balance must be greater than $25.00 to be active.");
                            }

                            //else for active accounts
                            else
                            {
                                //call method to get withdrawal amount
                                withdrawal = makeWithdrawal(account);

                                //if balance high enough withdraw money otherwise display message
                                if (withdrawal>account.getBalance())
                                {
                                    JOptionPane.showMessageDialog(null, "The amount of withdrawal"
                                            + " is greater than the balance.");
                                }

                                else if (account.getBalance() - withdrawal < 25.00)
                                {
                                    input = JOptionPane.showInputDialog("The amount of withdrawal"
                                            + " will drop the balance below $25.00\n"
                                            + "making the account Inactive\n\n"
                                            + "Would you like to continue with the withdrawal?\n"
                                            + "Enter Y or N");

                                    while ((!input.equalsIgnoreCase("Y")) && (!input.equalsIgnoreCase("N"))){

                                       input = JOptionPane.showInputDialog("Invalid Entry\n\n"
                                                    + "Would you like to continue with the withdrawal?\n"
                                                    + "Enter Y or N");
                                        }

                                    if (input.equalsIgnoreCase("Y"))
                                    {
                                        account.withdraw(withdrawal);
                                        account.setStatus();
                                    }
                                }

                                else if (withdrawal <= account.getBalance())
                                {
                                   account.withdraw(withdrawal); 
                                }
                            }

                            break;
                        }
                    }

                    //ask the user if they would like to enter another transaction
                    newTransaction = JOptionPane.showInputDialog("New Transaction\n\n"
                            + "Would you like enter "
                            + "another transaction for the month? \n\n(Enter Y or N)");

                    //verify input        
                    while ((!newTransaction.equalsIgnoreCase("Y")) && (!newTransaction.equalsIgnoreCase("N"))){

                    newTransaction = JOptionPane.showInputDialog("Invalid Entry\n\n"
                            + "New Transaction\n\n"
                            + "Would you like enter "
                            + "another transaction for the month? \n\n(Enter Y or N)");
                    }
                }
                while (newTransaction.equalsIgnoreCase("Y"));

                //monthly processing
                account.monthlyProcess();

                //print results
                System.out.println(account);

                //ask the user if they would like to enter another month data
                newMonth = JOptionPane.showInputDialog("New Month\n\n"
                        + "Would you like enter "
                        + "information for another month?\n\n (Enter Y or N)");

                //verify input        
                while ((!newMonth.equalsIgnoreCase("Y")) && (!newMonth.equalsIgnoreCase("N"))){

                    newMonth = JOptionPane.showInputDialog("Invalid Entry\n\n"
                            + "New Month\n\n"
                            + "Would you like enter "
                        + "information for another account?\n\n (Enter Y or N)");
                }

                //increment month number
                numOfMonth++;
             }

        while (newMonth.equalsIgnoreCase("Y"));
        
    }
    
    //get starting balance
    public static double getStartingBalance(){
        double start;
        
        //Input the starting balance
        String input = JOptionPane.showInputDialog("Enter the starting balance for"
                + " the savings account:");
        
        //Convert to double
        start = Double.parseDouble(input);
        
        //input validation
        while (start <0){
           input = JOptionPane.showInputDialog("The starting balance cannot"
                   + " be negative.\n"
                   + "Enter the starting Balance for"
                   + " the savings account:");
        
            start = Double.parseDouble(input); 
            }
        
        return start;
    }
    
    //get the annual interest rate
    public static double getAnnualInterestRate(){
        double rate;
        
        //Input the starting balance
        String input = JOptionPane.showInputDialog("Enter the annual interest rate\n"
                + "for the savings account."
                + " \n\n(Enter 5 for 5%)");
        
        //Convert to double
        rate = Double.parseDouble(input);
        
        //input validation
        while (rate <=0){
           input = JOptionPane.showInputDialog("The interest rate must be greater"
                   + "than zero.\n"
                   + "Enter the annual interest rate\n" 
                   + "for the savings account." 
                   + "\n\n(Enter 5 for 5%)");
        
            rate = Double.parseDouble(input); 
            }
        
        //return rate as decimal
        return rate/100;
    }
   
    //get tranasction option
    public static int getTransactionOption(){
        int choice;
        
        //Input the starting balance
        String input = JOptionPane.showInputDialog("Choice Transaction Option:\n"
                + "\n1. Deposit"
                + "\n2. Withdrawal");
        
        //Convert to double
        choice = Integer.parseInt(input);
        
        //input validation
        while (choice !=1 && choice!=2){
           input = JOptionPane.showInputDialog("Invalid Entry\n\n"
                   + "Choice Transaction Option:\n"
                + "\n1. Deposit"
                + "\n2. Withdrawal");
        
            choice = Integer.parseInt(input); 
            }
        
        return choice;
    }
    
    //make deposit
    public static double makeDeposit(){
       double deposit;
        
        //Input the starting balance
        String input = JOptionPane.showInputDialog("Enter the amount for"
                + " the deposit:");
        
        //Convert to double
        deposit = Double.parseDouble(input);
        
        //input validation
        while (deposit <0){
           input = JOptionPane.showInputDialog("The deposit cannot"
                   + " be a negative amount.\n"
                   + "Enter the amount for"
                   + " the deposit:");
        
            deposit = Double.parseDouble(input); 
            }
       
        return deposit;
    }
    
    /**
     * make withdrawal
     * @param a Saving Account
     * @return 
     */
    public static double makeWithdrawal(SavingsAccount a){
       double withdrawal;
        
        //Input the starting balance
        String input = JOptionPane.showInputDialog("Enter the amount for"
                + " the withdrawal:");
        
        //Convert to double
        withdrawal = Double.parseDouble(input);
        
        //input validation
        while (withdrawal <0){
           input = JOptionPane.showInputDialog("The withdrawal cannot"
                   + " be a negative amount.\n"
                   + "Enter the amount for"
                   + " the withdrawal:");
        
            withdrawal = Double.parseDouble(input); 
            }

        return withdrawal;
    }
}
  

