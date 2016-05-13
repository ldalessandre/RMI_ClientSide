
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {

  private Client() {}
	
	public static void main (String args[]) {
		
		String host = (args.length < 1) ? null : args[0];
		
		try {
						
			Registry registry = LocateRegistry.getRegistry();
			Hello stub = (Hello) registry.lookup("localhost:1010/Hello");
			
			String response = stub.sayHello();
			
			System.out.println("response: " + response);
		}
		catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}

