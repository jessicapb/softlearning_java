package serializers;

import com.core.appservices.serializers.Serializer;
import com.core.appservices.serializers.Serializers;
import com.core.appservices.serializers.SerializersCatalog;
import com.core.entity.courses.services.CastellaCoursesDTO;
import com.core.entity.courses.services.CatalaCoursesDTO;

public class SerializerCourses {
    public static void main(String[] args){
        CatalaCoursesDTO cat = new CatalaCoursesDTO(1212, 12.04, "Java", 134, "M12");
        CastellaCoursesDTO cast = new CastellaCoursesDTO(1212, 12.04, "Diseño", 134, "M05");

        try {
            // CatalaCurs Serializer
            System.out.println(" \n Catala Serializer: \n ");
            Serializer formatter = SerializersCatalog.getInstace(Serializers.JSON_COURSES);
            String jcatcourses = formatter.serialize(cat);
            System.out.println(jcatcourses);

            System.out.println(" \n Catala Desarialize: \n ");
            CatalaCoursesDTO coursesDTO = (CatalaCoursesDTO)formatter.desearialize(jcatcourses, CatalaCoursesDTO.class);
            System.out.println(coursesDTO);

            // CatalaCurs XML
            System.out.println(" \n Catala XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_COURSES);
            String xmlclient = formatter.serialize(cat);
            System.out.println(xmlclient);

            System.out.println(" \n Catala XML Desearialize: \n ");
            CatalaCoursesDTO coursesdto = (CatalaCoursesDTO)formatter.desearialize(xmlclient, CatalaCoursesDTO.class);
            System.out.println(coursesdto);

            // CastellaCurs Serializer
            System.out.println(" \n Castella Serializer: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.JSON_CAST_COURSES);
            String jcastcourses = formatter.serialize(cast);
            System.out.println(jcastcourses);

            System.out.println(" \n Castella Desarialize: \n ");
            CastellaCoursesDTO castcoursesDTO = (CastellaCoursesDTO)formatter.desearialize(jcastcourses, CastellaCoursesDTO.class);
            System.out.println(castcoursesDTO);
            
            // CastellaCurs XML
            System.out.println(" \n Castella XML: \n ");
            formatter = SerializersCatalog.getInstace(Serializers.XML_CAST_COURSES);
            String xmlcastcourses = formatter.serialize(cast);
            System.out.println(xmlcastcourses);

            System.out.println(" \n Castella XML Desearialize: \n ");
            CastellaCoursesDTO castcoursesdto = (CastellaCoursesDTO)formatter.desearialize(xmlcastcourses, CastellaCoursesDTO.class);
            System.out.println(castcoursesdto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
