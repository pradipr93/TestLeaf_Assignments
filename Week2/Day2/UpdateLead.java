package seleniumLearning;


public class UpdateLead {

    
	
	public static void main(String[] args) throws Exception {
		LeadDeletion LeadDeletionObj = new LeadDeletion();
		LeadDeletionObj.driver = LeadDeletionObj.setUp("http://leaftaps.com/opentaps");
		LeadDeletionObj.login();		
		LeadDeletionObj.editLead();

		


	}

}
