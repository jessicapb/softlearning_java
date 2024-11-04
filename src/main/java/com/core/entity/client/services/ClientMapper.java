package com.core.entity.client.services;

import com.core.entity.client.model.Client;
import com.core.entity.exceptions.BuildException;

public class ClientMapper {
    public static Client clientFromDTO(ClientDTO cdto) throws BuildException{
        return Client.getInstanceClient(
            cdto.getName(), 
            cdto.getSurname(), 
            cdto.getEmail(), 
            cdto.getNumber(),
            cdto.getAddress(),
            cdto.getAntiquity(), 
            cdto.getIdent(),
            cdto.getPaymentcode()
        );
    }

    public static ClientDTO dtoFromClient(Client c){
        return new ClientDTO(
            c.getName(), 
            c.getSurname(), 
            c.getEmail(), 
            c.getNumber(),
            c.getAddress(),
            c.getAntiquity(), 
            c.getIdent(),
            c.getPaymentcode()            
        );
    }
}
