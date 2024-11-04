package provider;

import com.core.entity.exceptions.BuildException;
import com.core.entity.provider.model.Provider;
import com.core.entity.provider.services.ProviderDTO;
import com.core.entity.provider.services.ProviderMapper;

public class ProviderTest {

    public static void main(String[]args){
        //Correcte Proveïdor
        Provider pr;
        try{
            pr=Provider.getInstanceProvider("Jessica", "Prats", "jessica.prats13@gmail.com", "3467676", "Av.Riera", "2009-01-12", 14, "Java", 14, "Education");
            System.out.println(pr.getDetails());

            //Mapper
            ProviderDTO pdto = ProviderMapper.dtoFromProvider(pr);
            System.out.println("Adreça: " + pdto.getAddress());

            Provider pcopy = ProviderMapper.providerFromDTO(pdto);
            System.out.println("Mapper Proveïdor: " + pcopy.getDetails());
            
        }catch(BuildException e){
            System.out.println(e.toString());
            pr=null;
        }

        //Incorrecte Proveïdor
        try{
            ProviderDTO pdto = new ProviderDTO("J", "j", "k", "3", "a", "2009-12-01", -10, "Java", -0, "Education");
            Provider pro = ProviderMapper.providerFromDTO(pdto);
            System.out.println(pro.getDetails());
        }catch(BuildException e){
            System.out.println("Error en el proveïdor: " + e.toString());
            pr=null;
        }
    }
}
