package assignment.day2;
import java.util.Scanner;

interface Telephone{
	void dialCall(String contactNumber);
	void recieveCalls(String contactName,String contactNumber);
	String getCallHistory();
}
class Network{
	private String connection;
	private boolean status;
	public Network() {
		this.connection = "AIRTEL";
		this.status = true;
	}
	
	public Network(String connection, boolean status) {
		this.connection = connection;
		this.status = status;
	}
	
	public boolean isNetworkEnabled() {
		if(this.status==true)
			return true;
		else
			return false;
	}
	
	public String getConnection() {
		return this.connection;
	}
	
	public void makeCall(String contactNumber) {
		if(isNetworkEnabled()) {
			System.out.println("Making call from "+getConnection()+" Connection :");
		}
		else
			System.out.println("Can't make call at this time as Network is Disabled .");
	}
	
	public void receiveCall(String contactName,String contactNumber) {
		if(isNetworkEnabled()) {
			System.out.println("Receiving call from Connection : "+
					getConnection()+" and Name : "+contactName+" Number : "+ contactNumber);
		}
		else
			{System.out.println("Can't receive call at this time as Network is Disabled .");
		}
	}
}
class MyPhone implements Telephone{
	String contactNumber;
	String userName;
	String callHistory;
	String phoneModel;
	Network network;
	
	public MyPhone() {
		this.contactNumber = "0000000000";
		this.userName = "USER1";
		this.phoneModel = "ONEPLUS_6";
		this.network = new Network();
	}
	public MyPhone(String contactNumber,String userName,String phoneModel,Network network) { 
		this.contactNumber = contactNumber;
		this.userName = userName;
		this.phoneModel = phoneModel;
		this.network= network;
		
	}
	@Override
	public void dialCall(String contactNumber) {
		network.makeCall(contactNumber);
		this.callHistory=this.callHistory + ("\nDialed call : "+userName+"  "
		     +contactNumber);
	}

	@Override
	public void recieveCalls(String contactName ,String contactNumber) {
		network.receiveCall(contactName,contactNumber);
		//this.callHistory[i++]="Recieved call :"+ this.userName+"  "+this.contactNumber;
		this.callHistory=this.callHistory + ("\nReceived call : "+contactName+"  "
			     +contactNumber);
	}

	@Override
	public String getCallHistory() {
		return callHistory;
	}
	
	public String getUsername() {
		return userName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public String isPhoneWorking() {
		if(network.isNetworkEnabled()) {
			return "YES";
		}
		else 
			return "NOT WORKING";
	}
	
}

public class TelephoneTest {

	public static void main(String[] args) {
		//Network n1=new Network("BSNL",true);
		//MyPhone m1=new MyPhone("9998888777","shipra","ONEPLUS_7",n1);
		MyPhone m2=new MyPhone();
//		m1.dialCall("7776666554");
//		m1.recieveCalls("Aditya","923456787");
//		String calllogs = m1.getCallHistory();
//		System.out.println("Call History : "+ calllogs);
//		m2.dialCall("7776666554");
//		m2.recieveCalls("aditi","9236676787");
//		m2.recieveCalls("tania", "9876567899");
//		String calllogs2 = m2.getCallHistory();
//		System.out.println("Call History : "+ calllogs2);
//		System.out.println(m1.getContactNumber()+ " "+m1.getUsername()+" "+m1.isPhoneWorking());
		
		int choice=0;
		Scanner sc=new Scanner(System.in);
		while(choice<3 &&choice>=0) {
			System.out.println("Menu: \n1.Calling\n2.History\n3.exit");
			choice=sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter the contact number you want to dial : ");
				String contact=sc.next();
				if(contact.length()==10&&!contact.isBlank()&&contact.matches("[0-9]+"))
					m2.dialCall(contact);
				else
					System.out.println("Please check the number ");
				break;
			}
		
			case 2:{
				m2.recieveCalls("aditi","9236676787");
				m2.recieveCalls("tania", "9876567899");
				String calllogs2 = m2.getCallHistory();
				System.out.println("Call History : "+ calllogs2);
				break;
			}
	
			}
		}
		sc.close();
	}
}
