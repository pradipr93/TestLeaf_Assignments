package seleniumLearning;

public class DuplicateLead {
	
	public static void main(String[] args) throws Exception {
		LeadCreation LeadCreationObj = new LeadCreation();
		LeadCreationObj.driver = LeadCreationObj.setUp("http://leaftaps.com/opentaps");
		LeadCreationObj.login();		
		LeadCreationObj.createLead();
		LeadCreationObj.verifyTitle("View Lead | opentaps CRM");
		LeadCreationObj.duplicateLead();
		LeadCreationObj.verifyTitle("View Lead | opentaps CRM");
	}

}
