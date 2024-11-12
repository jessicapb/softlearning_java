package operation;

import com.core.entity.exceptions.BuildException;
import com.core.entity.order.domain.model.Order;
import com.core.entity.order.services.OrderDTO;
import com.core.entity.order.services.OrderMapper;


public class OrderTest {
    public static void main(String[]args) throws BuildException{
        Order or;
        try{
            or = Order.getInstanceOrder("Av.riera sant llorenç", "1212212", "12121A", "Jessica", "Prats", "12345678A");
            System.out.println(or.getDetails());

            //PhysicalData
            or.setPackagedDimensions("h:120,w:80,d:60,we:12.8,f:true,l:80,we:12.45,f:true,d:67.89");
            System.out.println(or.getPackedDimensions());

            //ShopCart
            or.setDetail("Llibre", 1, "1212121", 12.45, 12, 13.56);

            // for(int i=0; i < or.getNumDetails(); i++){
            //     System.out.println("Producto ("+(i+1)+")" + or.getDetail(i));
            // }

            //Mapper
            OrderDTO ordto= OrderMapper.dtoFromOrder(or);
            System.out.println( "Adreça: " + ordto.getAddress());

            
            //OrderDTO1 orcopy = OrderMapper1.order1FromDTO(ordto);
        }catch(BuildException e){
            System.out.println(e.toString());
            or=null;
        }
    }
}
