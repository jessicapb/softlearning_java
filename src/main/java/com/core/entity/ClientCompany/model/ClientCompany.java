package com.core.entity.ClientCompany.model;

import com.core.checks.Check;
import com.core.entity.client.model.Client;
import com.core.entity.exceptions.BuildException;
import com.core.entity.shared.stakeholders.CompanyData;

public class ClientCompany extends Client{
    protected Client cli;
    protected CompanyData comp;

    protected ClientCompany(){
    }

    public static ClientCompany getInstanceClientCompany(String name, String surname, String email, String number, String address, String antiquity,
    int ident, String paymentcode, int workers, String socialreason)throws BuildException {
        String message = "";
        ClientCompany cc = new ClientCompany();

        try{
            cc.cli=Client.getInstanceClient(name, surname, email, number, address, antiquity, ident, paymentcode);
        }catch(BuildException e){
            message += e.getMessage();
        }

        try{
            cc.comp=CompanyData.getInstanceCompanyData(workers, socialreason);
        }catch(BuildException e){
            message += e.getMessage();
        }

        if(message.length()>0){
            cc = null;
            throw new BuildException(message);
        }
        return cc;
    }

    //MÉTODES PARE
    public String getName() {
        return name;
    }

    public int setName(String name) {
        if(Check.isNull(name) == true){
            return -1;
        }
        if(Check.minLenght(name, 3) !=0){
            return -2;
        }
        this.name = name;
        return 0;
    }

    //MÈTODES CLIENT
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
    
    //MÈTODES COMPANYDATA
    public int getWorkers() {
        return this.comp.getWorkers();
    }

    public String getSocialreason() {
        return this.comp.getSocialreason();
    }

    public String getCompanyType() {
        return  this.comp.getCompanyType();
    }
    @Override
    public String toString() {
        return "ClientCompany: Nom: " + this.getName() + " ,Treballadors: "+ this.getWorkers()+ " ,Empresa: " + this.getSocialreason() + "";
    }
}
