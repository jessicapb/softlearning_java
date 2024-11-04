package ClientCompany;

import com.core.entity.ClientCompany.model.ClientCompany;
import com.core.entity.exceptions.BuildException;

public class ClientCompanyTest {
    public static void main(String[]args){
        //Correcte EmpresaClient
        ClientCompany cc;
        try{
            cc=ClientCompany.getInstanceClientCompany("Jessica", "Prats", "jessica.prats13@gmail.com", "3456789", "Av.Riera", "2009-09-12", 12, "Targeta", 10, "Educació");
            System.out.println("Nom: " + cc.getName());
            System.out.println("Treballadors: " + cc.getWorkers());
            System.out.println("Empresa: " + cc.getSocialreason());
            System.out.println("Tipus d'empresa: " + cc.getCompanyType());
        }catch(BuildException e){
            System.out.println(e.toString());
            cc=null;
        }
    }
}
