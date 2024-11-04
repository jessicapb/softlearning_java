package com.core.entity.client.model;

import com.core.checks.Check;
import com.core.entity.exceptions.BuildException;
import com.core.entity.shared.stakeholders.Person;
import com.core.entity.shared.stakeholders.Stakeholder;

public class Client extends Person implements Stakeholder{
    protected String paymentcode;

    protected Client(){
    }

    public static Client getInstanceClient(String name, String surname, String email, String number, String address, String antiquity,
            int ident, String paymentcode) throws BuildException {
        String message ="";
        int error = 0;

        Client c = new Client();

        try{
        c.PersonCheck(name, surname, email, number, address, antiquity, ident);
        }catch(BuildException e){
            message += e.getMessage();
        }
        
        if((error = c.setPaymentcode(paymentcode)) !=0){
            message +=  Check.getErrorMessage(error);
        }

        if(message.length()>0){
            c = null;
            throw new BuildException(message);
        }
        return c;
    }

    public String getPaymentcode() {
        return paymentcode;
    }

    public int setPaymentcode(String paymentcode) {

        if(Check.isNull(paymentcode) == true){
            return -1;
        }if(Check.minLenght(paymentcode, 5) !=0){
            return -2;
        }else{
            this.paymentcode = paymentcode;
        }
        return 0;
    }

    @Override
    public String getDetails() {
        return "CLIENT: Nom: " + name + ", Cognoms: " + surname + ", Aniversari: " + antiquity + ", Email: " + email
                + ", Número telèfon: " + number + ", Adreça: " + address + ", Número de soci: " + ident + ", Mètode de pagament: " + paymentcode + "";
    }
}
