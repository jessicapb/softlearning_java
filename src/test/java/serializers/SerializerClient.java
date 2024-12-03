package serializers;


import com.core.appservices.serializers.Serializer;
import com.core.appservices.serializers.Serializers;
import com.core.appservices.serializers.SerializersCatalog;
import com.core.entity.client.services.CastellaClientDTO;
import com.core.entity.client.services.CatalaClientDTO;


public class SerializerClient {
    public static void main(String[] args){
        CatalaClientDTO cat = new CatalaClientDTO("Jessica", "Prats", "jessicaprats.nuria@gmail.com", "34 678 90 09", "Av.riera", "2024/12/02", "targeta", 13);
        CastellaClientDTO cast = new CastellaClientDTO("Carles", "Meca", "carlesmeca.nuria@gmail.com", "34 678 90 09", "Montflorit", "2024/12/02", "targeta", 2);

        try {
            // CatalaClient Serializer
            System.out.println(" \n Catala Serializer: \n ");
            Serializer formatter = SerializersCatalog.getInstace(Serializers.JSON_CLIENT);
            String jcatclient = formatter.serialize(cat);
            System.out.println(jcatclient);

            System.out.println(" \n Catala Desarialize: \n ");
            CatalaClientDTO clientDTO = (CatalaClientDTO)formatter.desearialize(jcatclient, CatalaClientDTO.class);
            System.out.println(clientDTO);

            // CatalaClient XML
            System.out.println(" \n Catala XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_CLIENT);
            String xmlclient = formatter.serialize(cat);
            System.out.println(xmlclient);

            System.out.println(" \n Catala XML Desearialize: \n ");
            CatalaClientDTO clientdto = (CatalaClientDTO)formatter.desearialize(xmlclient, CatalaClientDTO.class);
            System.out.println(clientdto);

            // CastelaClient Serializer
            System.out.println(" \n Castella Serializer: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.JSON_CAST_CLIENT);
            String jcastclient = formatter.serialize(cast);
            System.out.println(jcastclient);

            System.out.println(" \n Castella Desarialize: \n ");
            CastellaClientDTO castclientDTO = (CastellaClientDTO)formatter.desearialize(jcastclient, CastellaClientDTO.class);
            System.out.println(castclientDTO);

            // CastellaXML
            System.out.println(" \n Castella XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_CAST_CLIENT);
            String xmlcastclient = formatter.serialize(cast);
            System.out.println(xmlcastclient);

            System.out.println(" \n Castella XML Desearialize: \n ");
            CastellaClientDTO castclientdto = (CastellaClientDTO)formatter.desearialize(xmlcastclient, CastellaClientDTO.class);
            System.out.println(castclientdto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
