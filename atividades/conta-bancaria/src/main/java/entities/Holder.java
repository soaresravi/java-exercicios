package entities;

public class Holder {
    
    private int accountNumber;
    private String accountHolder;
    private double balance;
    
    public Holder(int accountNumber, String accountHolder, double initialDeposit) { //nao é um saldo, é um deposito inicial
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        deposit(initialDeposit); // ja fazendo o deposito inicial somar no saldo
    }
    //fazendo assim eu consigo fazer 2 construtores para ficar certo o if/else e o saldo
    
    public Holder(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder; //para que nao seja inicializado sem nada
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount + 5; //o parametro pode ser diferente da variavel, pois isso la eu fiz 2 certo, uma p/ deposito e 1 p/ saque
    }
    
    public String toString() {
        return "Account " +
        accountNumber +
        ", Holder: " +
        accountHolder +
        ", Balance: $ " +
        String.format("%.2f", balance);
    }
}
