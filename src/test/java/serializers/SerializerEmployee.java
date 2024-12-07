package serializers;

import com.core.appservices.serializers.Serializer;
import com.core.appservices.serializers.Serializers;
import com.core.appservices.serializers.SerializersCatalog;
import com.core.entity.employee.services.CastellaEmployeeDTO;
import com.core.entity.employee.services.CatalaEmployeeDTO;

public class SerializerEmployee {
    public static void main(String[] args){
        CatalaEmployeeDTO cat = new CatalaEmployeeDTO("Jessica", "Prats", "jessica.prats13@gmail.com", "3467676", "Av.Riera", "2009-01-12",  "Java", "8:00-14:00", 15, 6565667);
        CastellaEmployeeDTO cast = new CastellaEmployeeDTO("Jessica", "Prats", "jessicaprats.nuria@gmail.com", "3467676", "Av.Riera", "2021-01-12",  "Boostrap", "8:00-14:00", 13, 6565667);

        try {
            // CatalaTreballador Serializer
            System.out.println(" \n Catala Serializer: \n ");
            Serializer formatter = SerializersCatalog.getInstace(Serializers.JSON_EMPLOYEE);
            String jcattreballador = formatter.serialize(cat);
            System.out.println(jcattreballador);

            System.out.println(" \n Catala Desarialize: \n ");
            CatalaEmployeeDTO employeeDTO = (CatalaEmployeeDTO)formatter.desearialize(jcattreballador, CatalaEmployeeDTO.class);
            System.out.println(employeeDTO);

            // CatalaTreballador XML
            System.out.println(" \n Catala XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_EMPLOYEE);
            String xmlemployee = formatter.serialize(cat);
            System.out.println(xmlemployee);

            System.out.println(" \n Catala XML Desearialize: \n ");
            CatalaEmployeeDTO employeedto = (CatalaEmployeeDTO)formatter.desearialize(xmlemployee, CatalaEmployeeDTO.class);
            System.out.println(employeedto);

            // CastellaTreballador Serializer
            System.out.println(" \n Castella Serializer: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.JSON_CAST_EMPLOYEE);
            String jcastemployee = formatter.serialize(cast);
            System.out.println(jcastemployee);

            System.out.println(" \n Castella Desarialize: \n ");
            CastellaEmployeeDTO castemployeeDTO = (CastellaEmployeeDTO)formatter.desearialize(jcastemployee, CastellaEmployeeDTO.class);
            System.out.println(castemployeeDTO);
            
            // CastellaTreballador XML
            System.out.println(" \n Castella XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_CAST_EMPLOYEE);
            String xmlcastemployee = formatter.serialize(cast);
            System.out.println(xmlcastemployee);

            System.out.println(" \n Castella XML Desearialize: \n ");
            CastellaEmployeeDTO castellaEmployeedto = (CastellaEmployeeDTO)formatter.desearialize(xmlcastemployee, CastellaEmployeeDTO.class);
            System.out.println(castellaEmployeedto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
