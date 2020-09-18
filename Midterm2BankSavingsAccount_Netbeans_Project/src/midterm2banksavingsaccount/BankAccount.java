//Mickie Blair
//Midterm Project Part 2- Bank Account and Savings Account
//Abstract BankAccount Class

package midterm2banksavingsaccount;

public abstract class BankAccount {
   //fields
    private double balance;
    private int numberDeposits;
    private int numberWithdrawals;
    private double annualInterestRate;
    private double monthlyServiceCharges;
    
    /**
     * Constructor
     * @param b Balance
     * @param rate Annual Interest Rate
     */
    public BankAccount(double b, double rate){
        this.balance = b;
        this.annualInterestRate = rate;
        this.numberDeposits = 0;
        this.numberWithdrawals = 0;
        this.monthlyServiceCharges = 0.00;
    }

    //Setters/getters
    /**
    * Set balance
    * @param b Starting Balance
    */
    public void setBalance(double b){
        this.balance = b;
    }
    
    /**
     * set Number Of Deposits
     * @param n number of deposits
     */
    public void setNumOfDeposits(int n){
        this.numberDeposits = n;
    }
    
    /**
     * set Number Of Withdrawals
     * @param n number of withdrawals
     */
    public void setNumOfWithdrawals(int n){
        this.numberWithdrawals = n;
    }
    
    /**
     * set Annual Interest Rate
     * @param r Annual Interest Rate
     */
    public void setAnnualInterestRate(double r){
        this.annualInterestRate = r;
    }
    
    /**
     * set Monthly Service Charge
     * @param sc number of deposits
     */
    public void setMonthlyServiceCharges(double sc){
        this.monthlyServiceCharges = sc;
    }
    
    /**
     * 
     * @return Balance
     */
    public double getBalance(){return this.balance;}
    
    /**
     * 
     * @return Number of Deposits
     */
    public int getNumOfDeposits(){return this.numberDeposits;}
    
    /**
     * 
     * @return Number of Withdrawals
     */
    public int getNumOfWithdrawals(){return this.numberWithdrawals;}
    
    /**
     * 
     * @return Annual Interest Rate
     */
    public double getAnnualInterestRate(){return this.annualInterestRate;}
    
    /**
     * 
     * @return Monthly Service Charge
     */
    public double getMonthlyServiceCharges(){return this.monthlyServiceCharges;}

    /**
     * Make Deposit
     * @param d Deposit Amount
     */
    public void deposit(double d){
        this.balance += d;
        this.numberDeposits++;
    }
    
    /**
     * Make Withdrawal
     * @param w Withdrawal amount
     */
    public void withdraw(double w){
        this.balance -= w;
        this.numberWithdrawals++;
    }
    
    //calculate interest
    public void calcInterest(){
        double monthlyInterestRate;
        double monthlyInterest;
        
        monthlyInterestRate = (this.annualInterestRate/12);
        
        monthlyInterest = this.balance * monthlyInterestRate;
        
        this.balance+= monthlyInterest;
    }
    
    //End of month processing
    public void monthlyProcess(){
        
        this.balance -= this.monthlyServiceCharges;
            
        calcInterest();
        
        this.numberDeposits = 0;
        this.numberWithdrawals = 0;
        this.monthlyServiceCharges = 0;
    }
}
