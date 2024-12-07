package order;

import com.core.entity.exceptions.BuildException;
import com.core.entity.order.domain.model.Order;
import com.core.entity.order.services.OrderDTO;
import com.core.entity.order.services.OrderMapper;

public class OrderTestComplet {
    public static void main(String[] args)throws BuildException{
        Order or;
        try {
            //getInstance amb tot el contingut
            or = Order.getInstanceOrder(13, "Javava", "2000/12/20-08:20:45", "Av.riera", "123456789", "1234567J", 
            "Jessica", "Prats", "12345678A", "2000/12/20-08:20:45", "2000/12/20-08:20:45", "2000/12/24-09:20:45", 
            13, 13, 13, 10, true, 10, "nomarticle:lllibre,quantitat:11,referencia:23451,preuindividual:12.45,descompte:3, total:12.45;");
            System.out.println(or.getDetails());

            // //Mapper
            System.out.println(" \n Mapper Order: \n ");
            OrderDTO ordto = OrderMapper.dtoFromOrder(or);
            System.out.println("Carrito compra:" + ordto.getShopCartDetails());

            Order ocopy = OrderMapper.orderFromDTO(ordto);
            System.out.println("Detalls generals:" + ocopy.getDetails());
        } catch (BuildException e) {
            System.out.println(e.toString());
            or=null;
        }
    }
}
