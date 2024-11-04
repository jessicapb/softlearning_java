package com.core.entity.provider.services;

import com.core.entity.exceptions.BuildException;
import com.core.entity.provider.model.Provider;

public class ProviderMapper {
    public static Provider providerFromDTO(ProviderDTO pdto) throws BuildException{
        return Provider.getInstanceProvider(
            pdto.getName(), 
            pdto.getSurname(),
            pdto.getEmail(),
            pdto.getNumber(),
            pdto.getAddress(),
            pdto.getAntiquity(),
            pdto.getIdent(),
            pdto.getSponsors(),
            pdto.getWorkers(),
            pdto.getSocialreason()
        );
    }

    public static ProviderDTO dtoFromProvider(Provider p){
        return new ProviderDTO(
            p.getName(),
            p.getSurname(),
            p.getEmail(),
            p.getNumber(),
            p.getAddress(),
            p.getAntiquity(),
            p.getIdent(),
            p.getSponsors(),
            p.getWorkers(),
            p.getSocialreason()
        );
    }
}
