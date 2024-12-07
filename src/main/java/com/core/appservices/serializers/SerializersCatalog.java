package com.core.appservices.serializers;

import java.util.TreeMap;

import com.core.entity.book.services.CastellaBookDTO;
import com.core.entity.book.services.CatalaBookDTO;
import com.core.entity.client.services.CastellaClientDTO;
import com.core.entity.client.services.CatalaClientDTO;
import com.core.entity.courses.services.CastellaCoursesDTO;
import com.core.entity.courses.services.CatalaCoursesDTO;
import com.core.entity.employee.services.CastellaEmployeeDTO;
import com.core.entity.employee.services.CatalaEmployeeDTO;
import com.core.entity.order.services.CatalaOrderDTO;

public class SerializersCatalog {

    private static TreeMap<Serializers, Serializer > catalog = new TreeMap<>();

    private static void loadCatalog(){
        //AL CREAR EL SERIALITZADOR PASSEM PER CONSTRUCTOR L'OBJECTE AMB QUE ES REALITZARÀ LA SERIALITZACIO
        // CatalaClient
        catalog.put(Serializers.JSON_CLIENT,new JacksonSerializer<CatalaClientDTO>());
        catalog.put(Serializers.XML_CLIENT,new JacksonXmlSerializer<CatalaClientDTO>());

        // CastellaClient
        catalog.put(Serializers.JSON_CAST_CLIENT,new JacksonSerializer<CastellaClientDTO>());        
        catalog.put(Serializers.XML_CAST_CLIENT,new JacksonXmlSerializer<CastellaClientDTO>());

        // CatalaLlibre
        catalog.put(Serializers.JSON_BOOK,new JacksonSerializer<CatalaBookDTO>());
        catalog.put(Serializers.XML_BOOK,new JacksonXmlSerializer<CatalaBookDTO>());

        // CastellaLlibre
        catalog.put(Serializers.JSON_CAST_BOOK,new JacksonSerializer<CastellaBookDTO>());
        catalog.put(Serializers.XML_CAST_BOOK,new JacksonXmlSerializer<CastellaBookDTO>());

        // CatalaCompra
        catalog.put(Serializers.JSON_ORDER,new JacksonSerializer<CatalaOrderDTO>());
        catalog.put(Serializers.XML_ORDER,new JacksonXmlSerializer<CatalaOrderDTO>());

        // CastellaCompra
        catalog.put(Serializers.JSON_CAST_ORDER,new JacksonSerializer<CastellaBookDTO>());
        catalog.put(Serializers.XML_CAST_ORDER,new JacksonXmlSerializer<CastellaBookDTO>());

        // CatalaCurs
        catalog.put(Serializers.JSON_COURSES,new JacksonSerializer<CatalaCoursesDTO>());
        catalog.put(Serializers.XML_COURSES,new JacksonXmlSerializer<CatalaCoursesDTO>());

        // CastellaCurs
        catalog.put(Serializers.JSON_CAST_COURSES, new JacksonSerializer<CastellaCoursesDTO>());
        catalog.put(Serializers.XML_CAST_COURSES, new JacksonXmlSerializer<CastellaCoursesDTO>());

        // CatalaTreballador
        catalog.put(Serializers.JSON_EMPLOYEE,new JacksonSerializer<CatalaEmployeeDTO>());
        catalog.put(Serializers.XML_EMPLOYEE, new JacksonXmlSerializer<CatalaEmployeeDTO>());

        // CastellaCurs
        catalog.put(Serializers.JSON_CAST_EMPLOYEE, new JacksonSerializer<CastellaEmployeeDTO>());
        catalog.put(Serializers.XML_CAST_EMPLOYEE, new JacksonXmlSerializer<CastellaEmployeeDTO>());
    }
    public static Serializer getInstace(Serializers type){
        if(catalog.isEmpty()){
            loadCatalog();
        }
        return catalog.get(type);
    }
}
