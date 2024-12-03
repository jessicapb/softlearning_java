package com.core.appservices.serializers;

import java.util.TreeMap;

import com.core.entity.client.services.CastellaClientDTO;
import com.core.entity.client.services.CatalaClientDTO;

public class SerializersCatalog {

    private static TreeMap<Serializers, Serializer > catalog = new TreeMap<>();

    private static void loadCatalog(){
        //AL CREAR EL SERIALITZADOR PASSEM PER CONSTRUCTOR L'OBJECTE AMB QUE ES REALITZARÀ LA SERIALITZACIO
        catalog.put(Serializers.JSON_CLIENT,new JacksonSerializer<CatalaClientDTO>());
        catalog.put(Serializers.JSON_CAST_CLIENT,new JacksonSerializer<CastellaClientDTO>());
        catalog.put(Serializers.XML_CLIENT,new JacksonXmlSerializer<CatalaClientDTO>());
        catalog.put(Serializers.XML_CAST_CLIENT,new JacksonXmlSerializer<CastellaClientDTO>());
    }

    public static Serializer getInstace(Serializers type){
        if(catalog.isEmpty()){
            loadCatalog();
        }
        return catalog.get(type);
    }
}
