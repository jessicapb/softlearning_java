package serializers;

import com.core.appservices.serializers.Serializer;
import com.core.appservices.serializers.Serializers;
import com.core.appservices.serializers.SerializersCatalog;
import com.core.entity.order.services.CastellaOrderDTO;
import com.core.entity.order.services.CatalaOrderDTO;

public class SerializerOrder {
    public static void main(String[] args){
        CatalaOrderDTO cat = new CatalaOrderDTO(13, "Javava", "2000/12/20-08:20:45", "Av.riera", "123456789", "1234567J", 
        "Jessica", "Prats", "12345678A", "2000/12/20-08:20:45", "2000/12/20-08:20:45", "2000/12/24-09:20:45", 
        13, 13, 13, 10, true, 10, "nomarticle:lllibre,quantitat:11,referencia:23451,preuindividual:12.45,descompte:3, total:12.45;","");

        CastellaOrderDTO cast = new CastellaOrderDTO(13, "Javava", "2000/12/20-08:20:45", "Av.riera", "123456789", "1234567J", 
        "Jessica", "Prats", "12345678A", "2000/12/20-08:20:45", "2000/12/20-08:20:45", "2000/12/24-09:20:45", 
        13, 13, 13, 10, true, 10, "nomarticle:lllibre,quantitat:11,referencia:23451,preuindividual:12.45,descompte:3, total:12.45;","");
        try {
            // CatalaOrder Serializer
            System.out.println(" \n Catala Serializer: \n ");
            Serializer formatter = SerializersCatalog.getInstace(Serializers.JSON_ORDER);
            String jcatorder = formatter.serialize(cat);
            System.out.println(jcatorder);

            System.out.println(" \n Catala Desarialize: \n ");
            CatalaOrderDTO orderDTO = (CatalaOrderDTO)formatter.desearialize(jcatorder,CatalaOrderDTO.class);
            System.out.println(orderDTO);

            // CatalaOrder XML
            System.out.println(" \n Catala XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_ORDER);
            String xmlorder = formatter.serialize(cat);
            System.out.println(xmlorder);

            System.out.println(" \n Catala XML Desearialize: \n ");
            CatalaOrderDTO orderdto = (CatalaOrderDTO)formatter.desearialize(xmlorder,CatalaOrderDTO.class);
            System.out.println(orderdto);

            // CastellaOrder Serializer
            System.out.println(" \n Castella Serializer: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.JSON_CAST_ORDER);
            String jcastorder = formatter.serialize(cast);
            System.out.println(jcastorder);

            System.out.println(" \n Castella Desarialize: \n ");
            CastellaOrderDTO castorderdto = (CastellaOrderDTO)formatter.desearialize(jcastorder,CastellaOrderDTO.class);
            System.out.println(castorderdto);

            // CastellaXML
            System.out.println(" \n Castella XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_CAST_ORDER);
            String xmlOrder = formatter.serialize(cast);
            System.out.println(xmlOrder);

            System.out.println(" \n Castella XML Desearialize: \n ");
            CastellaOrderDTO castellaorderDTO = (CastellaOrderDTO)formatter.desearialize(xmlOrder, CastellaOrderDTO.class);
            System.out.println(castellaorderDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
