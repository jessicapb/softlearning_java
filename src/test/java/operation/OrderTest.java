package operation;

import com.core.entity.exceptions.BuildException;
import com.core.entity.order.domain.model.Order;
import com.core.entity.order.services.OrderDTO;
import com.core.entity.order.services.OrderMapper;

public class OrderTest {
    public static void main(String[]args) throws BuildException{
        Order or;
        try{
            //getInstance petit
            System.out.println(" \n Dades principals: \n");
            or = Order.getInstanceOrder("Av.riera sant llorenç", "123456789", "12121A", "Jessica", "Prats", "12345678A");
            System.out.println(or.getDetails());

            //Prepara la cistella
            or.setShopCartDetails("nomarticle:llibre,quantitat:1,referencia:12345,preuindividual:12.45,descompte:3, total:12.45 ");
            or.setShopCartDetails("nomarticle:llibre,quantitat:1000,referencia:123456,preuindividual:12.45,descompte:3, total:12.45");
            or.setShopCartDetails("nomarticle:llibre,quantitat:2000,referencia:123567,preuindividual:12.45,descompte:3, total:12.45");
            or.setShopCartDetails("nomarticle:llibre,quantitat:4000,referencia:12345789,preuindividual:12.45,descompte:3, total:12.45");

            //Mostrar quants elements té la cistella
            System.out.println(" \n Número d'elements de la cistella: \n");
            System.out.println("La cistella té aquests número d'elements: " + or.getNumDetails());

            //Mostrar els elements de la cistella
            System.out.println(" \n Elements de la cistella: \n");
            System.out.println("Elements de la cistella: " + or.getShopCartDetails());

            //Preu total de la cistlla
            System.out.println(" \n Preu total de la cistella: \n");
            System.out.println("El preu total de la cistella es: " + or.getPrice());

            //Actualitzar el carrito
            System.out.println(" \n Actualitzar un article: \n");
            or.updateDetail("12345", 15);
            System.out.println("Article actualitzat: " + or.getShopCartDetails());

            //Eliminar article del carrito
            System.out.println("\n Eliminar article: \n");
            or.deleteDetail("12345789");
            System.out.println("Article eliminat: " + or.getShopCartDetails());

            //Preu total de la cistella actualitzada
            System.out.println(" \n Preu total amb les dades actualitzades: \n");
            System.out.println("El preu total de la cistella actualitzada es: " + or.getPrice());

            //getInstance amb tot el contingut
            System.out.println(" \n Dades importants: \n");
            or = Order.getInstanceOrder(12, "Javass", "2000/12/12-08:23:56", "2000/12/12-09:23:10", "Av.riera", "123456789", 
            "1234567A", "Jessica", "Prats", "12345678A", "2000/12/12-10:23:10", "2000/12/14-14:23:10", 13, 13, 13, 13, true, 13);
            System.out.println(or.getDetails());

            //Actualitzar el carrito
            System.out.println(" \n Actualitzar article: \n");
            or.updateDetail("12345", 15);
            System.out.println("Elements actualitzats: " + or.getShopCartDetails());

            //Eliminar article del carrito
            System.out.println(" \n Eliminar article: \n");
            or.deleteDetail("12345789");
            System.out.println("Article eliminat: " + or.getShopCartDetails());

            //PhysicalData
            System.out.println(" \n Dimensions del packet: \n");
            or.setPackagedDimensions("h:120,w:80,d:60,we:12.8,f:true,l:80,we:12.45,f:true,d:67.89");
            System.out.println("Dimensions del paquet: " + or.getPackedDimensions());

            //Estat de la comanda
            //or.setInitDate("2000/12/14-14:23:10");
            or.setDeliveryDate("2000/12/14-14:23:10");
            //or.setPaymentDate("2000/12/14-14:23:10");
            or.setFinishDate("2000/12/14-14:23:10");
            System.out.println(" \n Estat de la comanda: " + or.getStatus());

            //Mapper
            System.out.println(" \n Mapper Order: \n ");
            OrderDTO ordto = OrderMapper.dtoFromOrder(or);
            System.out.println("Adreça:" +ordto.getAddress());

            Order ocopy = OrderMapper.orderFromDTO(ordto);
            System.out.println("Mapper del Order: " + ocopy.getDetails());
        }catch(BuildException e){
            System.out.println(e.toString());
            or=null;
        }
    }
}
