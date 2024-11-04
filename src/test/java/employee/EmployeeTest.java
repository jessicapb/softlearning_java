package employee;

import com.core.entity.employee.model.Employee;
import com.core.entity.employee.services.EmployeeDTO;
import com.core.entity.employee.services.EmployeeMapper;
import com.core.entity.exceptions.BuildException;

public class EmployeeTest {
    public static void main(String[]args){
        //Correcte Treballador
        Employee em;
        try{
            em=Employee.getInstanceEmployee("Jessica", "Prats", "jessica.prats13@gmail.com", "3467676", "Av.Riera", "2009-01-12", 15, "Java", "8:00-14:00", 6565667);
            System.out.println(em.getDetails());

            //Mapper
            EmployeeDTO edto = EmployeeMapper.dtoFromEmployee(em);
            System.out.println( "Adreça: " + edto.getAddress());

            Employee ecopy = EmployeeMapper.employeeFromDTO(edto);
            System.out.println("Mapper Treballador: " + ecopy.getDetails());

        }catch(BuildException e){
            System.out.println(e.toString());
            em=null;
        }

        //Incorrecte Treballador
        try{
            EmployeeDTO edto = new EmployeeDTO("J", "", "j", "3", "a", "2009-12-01", -0, "a", "a", -10);
            Employee emp = EmployeeMapper.employeeFromDTO(edto);
            System.out.println(emp.getDetails());
        }catch(BuildException e){
            System.out.println("Error en el treballador: " + e.toString());
            em=null;
        }
    }
}
