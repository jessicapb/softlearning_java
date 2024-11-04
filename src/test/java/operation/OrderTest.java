package operation;

import com.core.entity.exceptions.BuildException;
import com.core.entity.order.domain.model.Order;

public class OrderTest {
    public static void main(String[]args){
        Order or;
        try{
            or = Order.getInstanceOrder(0, null, null, null, null, null, null, null, null, null);
            System.out.println(or.getDetails());

            or.setPackagedDimensions("h:120,w:80,d:60,we:12.8,f:true,l:80,we:12.45,f:true,d:67.89");
            System.out.println(or.getPackedDimensions());

            or.setDetail("Llibre", 1, 1212121, 12.45, 12, 13.56);

        }catch(BuildException e){
            System.out.println(e.toString());
            or=null;
        }
    }
}
