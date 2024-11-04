package com.core.entity.ClientCompany.services;

import com.core.entity.ClientCompany.model.ClientCompany;
import com.core.entity.exceptions.BuildException;

public class ClientCompanyMapper {
    public static ClientCompany clientcompanyFromDTO(ClientCompanyDTO ccdto) throws BuildException{
        return ClientCompany.getInstanceClientCompany(
            ccdto.getName(),
            ccdto.getSurname(),
            ccdto.getEmail(),
            ccdto.getNumber(),
            ccdto.getAddress(),
            ccdto.getAntiquity(),
            ccdto.getIdent(),
            ccdto.getPaymentcode(),
            ccdto.getWorkers(),
            ccdto.getSocialreason()
        );
    }

    public static ClientCompanyDTO dtoFromClientCompanyDTO(ClientCompany cc){
        return new ClientCompanyDTO(null, null, null, null, null, null, 0, null, 0, null);
    }
}
