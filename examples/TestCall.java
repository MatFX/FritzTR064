
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.xml.bind.JAXBException;

import de.mapoll.javaAVMTR064.Action;
import de.mapoll.javaAVMTR064.FritzConnection;
import de.mapoll.javaAVMTR064.Response;
import de.mapoll.javaAVMTR064.Service;

public class TestCall {
	
	//ip format address with dots
	private static String ip = "ipAdressToSet";
	private static  String user = "userToSet";
	private static  String password = "passwordToSet";

	public static void main(String[] args) throws  IOException, JAXBException{
		System.out.println("##################################################################");
		FritzConnection fcWithUser = new FritzConnection(ip,user,password);
		fcWithUser.init();
		fcWithUser.printInfo();
		System.out.println("##################################################################");
		
		Service service = fcWithUser.getService("X_VoIP:1");
	
		Action action = service.getAction("X_AVM-DE_DialNumber");
		Map<String, Object> arguments = new HashMap<String, Object>();
		//set number to dial; the routing to the end number is in the fritz box definied
		arguments.put("NewX_AVM-DE_PhoneNumber", "47110815");
		
		Response response1 = null;
		try 
		{
			//action rings
			response1 = action.execute(arguments);
		} 
		catch (UnsupportedOperationException | IOException e1) {
			
			e1.printStackTrace();
		}
	}

}
