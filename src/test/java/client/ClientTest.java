package client;

import com.core.entity.client.model.Client;
import com.core.entity.client.services.ClientDTO;
import com.core.entity.client.services.ClientMapper;
import com.core.entity.exceptions.BuildException;

public class ClientTest {
    public static void main(String[]args){
        //Correcte Client
        Client c;
        try{
            c=Client.getInstanceClient("Jessica","Prats", "jessica.prats13@gmail.com", "34567890", "Av.Riera", "2009-01-12", 13, "Tarjeta");
            System.out.println(c.getDetails());

            //Mapper
            ClientDTO cdto = ClientMapper.dtoFromClient(c);
            System.out.println("Adreça del client: " + cdto.getAddress());

            Client ccopy = ClientMapper.clientFromDTO(cdto);
            System.out.println("Mapper Client: " + ccopy.getDetails());

        }catch(BuildException e){
            System.out.println(e.toString());
            c=null;
        }

        //Incorrecte Client
        try{
            ClientDTO cdto=new ClientDTO("J", "P", "j", "34", "12", "2009-12-01",-13, "Targeta");
            Client cl = ClientMapper.clientFromDTO(cdto);
            System.out.println(cl.getDetails());

        }catch(BuildException e){
            System.out.println("Error en el client: " + e.toString());
            c=null;
        }
    }
}
