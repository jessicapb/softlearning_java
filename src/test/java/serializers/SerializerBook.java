package serializers;

import com.core.appservices.serializers.Serializer;
import com.core.appservices.serializers.Serializers;
import com.core.appservices.serializers.SerializersCatalog;
import com.core.entity.book.services.CastellaBookDTO;
import com.core.entity.book.services.CatalaBookDTO;

public class SerializerBook {
    public static void main(String[] args){
        CatalaBookDTO cat = new CatalaBookDTO(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia", "Santillana", "987500505", 12.405, 34.56, 34.32, 12.45, true, 12.4);
        CastellaBookDTO cast = new CastellaBookDTO(13, 45.67, "java", "Jessica", "Harry Potter", "Dura", 134, "Fantasia", "Santillana", "987500505", 12.405, 34.56, 34.32, 12.45, true, 12.4);
        try {
            // CatalaLlibre Serializer
            System.out.println(" \n Catala Serializer: \n ");
            Serializer formatter = SerializersCatalog.getInstace(Serializers.JSON_BOOK);
            String jcatbook = formatter.serialize(cat);
            System.out.println(jcatbook);

            System.out.println(" \n Catala Desarialize: \n ");
            CatalaBookDTO bookDTO = (CatalaBookDTO)formatter.desearialize(jcatbook, CatalaBookDTO.class);
            System.out.println(bookDTO);

            // CatalaLlibre XML
            System.out.println(" \n Catala XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_BOOK);
            String xmlbook = formatter.serialize(cat);
            System.out.println(xmlbook);

            System.out.println(" \n Catala XML Desearialize: \n ");
            CatalaBookDTO bookdto = (CatalaBookDTO)formatter.desearialize(xmlbook, CatalaBookDTO.class);
            System.out.println(bookdto);

            // CastellaLlibre Serializer
            System.out.println(" \n Castella Serializer: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.JSON_CAST_BOOK);
            String jcastbook = formatter.serialize(cast);
            System.out.println(jcastbook);

            System.out.println(" \n Castella Desarialize: \n ");
            CastellaBookDTO castbookDTO = (CastellaBookDTO)formatter.desearialize(jcastbook, CastellaBookDTO.class);
            System.out.println(castbookDTO);

            // CastellaLlibre XML
            System.out.println(" \n Castella XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_CAST_BOOK);
            String xmlBook = formatter.serialize(cast);
            System.out.println(xmlBook);

            System.out.println(" \n Castella XML Desearialize: \n ");
            CastellaBookDTO castBookDTO = (CastellaBookDTO)formatter.desearialize(xmlBook, CastellaBookDTO.class);
            System.out.println(castBookDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
