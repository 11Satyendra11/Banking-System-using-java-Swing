package bankingsystemswing;

public class GlobalVariableOfficeAdvisorEmail {

    private static GlobalVariableOfficeAdvisorEmail instance = null;

    private String email;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public static synchronized GlobalVariableOfficeAdvisorEmail getInstance() {
	if (instance == null)
	    instance = new GlobalVariableOfficeAdvisorEmail();
	return instance;
    }

}
