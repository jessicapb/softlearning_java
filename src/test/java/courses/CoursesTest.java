package courses;

import com.core.entity.courses.model.Courses;
import com.core.entity.courses.services.CoursesDTO;
import com.core.entity.courses.services.CoursesMapper;
import com.core.entity.exceptions.BuildException;

public class CoursesTest {
    public static void main(String[]args) {
        //Correcte Curs
        Courses c;
        try{
            c=Courses.getInstanceCourses(1212, 12.04, "Java", 134, "M12");
            System.out.println(c.getDetails());

            //Mapper
            CoursesDTO codto = CoursesMapper.dtoFromCourses(c);
            System.out.println("Codi del curs: " + codto.getCode());

            Courses cocopy = CoursesMapper.coursesFromDTO(codto);
            System.out.println("Mapper del curs: " + cocopy.getDetails());

        }catch(BuildException e){
            System.out.println(e.toString());
            c=null;
        }

        //Incorrecte Curs
        try{
            CoursesDTO codto = new CoursesDTO(-0, -10, "a", -0, "", -0);
            Courses co = CoursesMapper.coursesFromDTO(codto);
            System.out.println(co.getDetails());
        }catch(BuildException e){
            System.out.println("Error del curs: " + e.toString());
            c=null;
        }
    }
}
