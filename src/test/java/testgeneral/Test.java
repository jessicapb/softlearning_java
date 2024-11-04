package testgeneral;

import java.util.HashSet;
import java.util.Set;


public class Test {
    public static void main(String[]args) {
        //Set
        Set<String> courses = new HashSet<>();
        courses.add("Jessica");
        courses.add("Carles");
        courses.add("Irene");

        for (String course:courses){
            System.out.println(course);
        }

        //Mapa
        //Map<String, Courses>parqMobil = new HashMap<>();
        //parqMobil.put("PHP",new CoursesMapper());

        //Array
    }
}
