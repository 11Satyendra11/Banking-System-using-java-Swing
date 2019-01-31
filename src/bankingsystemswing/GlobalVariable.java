package bankingsystemswing;

import java.sql.ResultSet;

public class GlobalVariable {

    private static GlobalVariable instance = null;

    private String login;
    private String iban1;
    private String accountNumber;
    private String bic;
    private Float balance;
    private String filename;
    private String password;
    ResultSet rs2 ;
    
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
    
    //File name
    public String getFileName() {
	return filename;
    }

    public void setFileName(String filename) {
	this.filename = filename;
    }
    
    //ResultSet rs2
    
    public void setResultSet(ResultSet prepare)
    {
	this.rs2 = prepare;

    }
    
    public ResultSet getResultSet()
    {
	return rs2;
    }

    
    //Password
    public String getPassword() {
   	return password;
       }

       public void setPassword(String Password) {
   	this.password = Password;
       }
    
    
    public static synchronized GlobalVariable getInstance() {
	if (instance == null)
	    instance = new GlobalVariable();
	return instance;
    }

}
