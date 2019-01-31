package bankingsystemswing;

public class GlobalVariableExternalRecipient {

    private static GlobalVariableExternalRecipient instance = null;

    private String login;
    private String iban1;
    private String accountNumber;
    private String bic;
    private Float balance;
    
    //Email
    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }
    
    //IBAN
    public String getIban1() {
	return iban1;
    }

    public void setIban1(String iban1) {
	this.iban1 = iban1;
    }
    
    //Account Number 
    public String getAccountNumber() {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
    }
    
    //BIC Code
    public String getBicNumber() {
	return bic;
    }

    public void setBicNumber(String bic) {
	this.bic = bic;
    }
    
    //Balance 
    public Float getBalance() {
	return balance;
    }

    public void setBalance(Float balance) {
	this.balance = balance;
    }
    

    public static synchronized GlobalVariableExternalRecipient getInstance() {
	if (instance == null)
	    instance = new GlobalVariableExternalRecipient();
	return instance;
    }

}
