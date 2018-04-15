package businnessLogic;

import database.*;
public class ClientsAccess {
    
	ClientDB clientdb ;
  
    public String insertClient (String name, String identitycard, String cnp, String adress) throws ClassNotFoundException
    {
    clientdb = new ClientDB();
    clientdb.insertClient(name, identitycard, cnp, adress); 
            return "Success!";
    }
    
    public String getClientDetails(int idclient) throws ClassNotFoundException{
    	clientdb = new ClientDB();
        return clientdb.getclientdetails(idclient);
    }
    
    public String updateClient(int idclient, String nume, String idcard, String cnp, String adress) throws ClassNotFoundException
    {
    	clientdb = new ClientDB();
        clientdb.updateClients(idclient, nume, idcard, cnp, adress);
        return "Client updated!";
    }
    
    public String deleteClient(int idclient) throws ClassNotFoundException{
    	clientdb = new ClientDB();
        clientdb.deleteClients(idclient);
        return "Client deleted!";
    }
}
