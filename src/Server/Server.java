package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;










import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.support.igd.PortMappingListener;
import org.fourthline.cling.support.model.PortMapping;

import klase.Fajl;
import klase.User;

public class Server {
	
	
	
	
	static LinkedList<ServerNit> klijenti = new LinkedList<ServerNit>();
	static LinkedList<Fajl> fajlovi = new LinkedList<Fajl>();
	static LinkedList<User> users = new LinkedList<User>();
	static int brojOnlineKlijenata = 0;
	
	
	
	public static void main(String[] args) {
		
		try {
			Process j = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Open SSL\" dir=in action=allow protocol=TCP localport=9876");
			j.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(j.getInputStream()));
			String line = reader.readLine();
			while(line!=null){
				System.out.println(line);
				line = reader.readLine();
			}
	            
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}catch(InterruptedException e3){
			e3.printStackTrace();
		}
		
		PortMapping p = new PortMapping(9876,"192.168.0.101",PortMapping.Protocol.TCP,"MojaMapa");//STAVITI U MAIN METODU
		UpnpService upnS = new UpnpServiceImpl(new PortMappingListener(p));
		upnS.getControlPoint().search();
		//upnS.shutdown();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int port = 9876;
		if(args.length > 0) {
			
			port = Integer.parseInt(args[0]);
		}
		
		Socket klijentSoket = null;
		try {
			ServerSocket serverSoket = new ServerSocket(port);
			System.out.println("Server je poceo sa radom!");
			
			
			while(true) {
				
				klijentSoket = serverSoket.accept();
				ServerNit klijent = new ServerNit(klijenti, klijentSoket, fajlovi);
				klijenti.add(klijent);
				brojOnlineKlijenata++;
				System.out.println("Broj online klijenata :" + brojOnlineKlijenata);
				klijent.start();
				
			}
		
			
		} catch (IOException e) {
			upnS.shutdown();
			e.printStackTrace();
		}
		
		
		
		

	}

}
