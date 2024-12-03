package com.core.entity.order.services;

import com.core.entity.exceptions.BuildException;
import com.core.entity.order.domain.model.Order;

public class OrderMapper {
    public static Order orderFromDTO(OrderDTO orderDTO)throws BuildException{
        /* int reference, String description, String initDate, String address, String phoneContact, 
        String idClient, String name, String surname, 
        String DNI, String paymentDate, String deliveryDate,  String finishDate, 
        double high, double width, 
        double depth, double weight, boolean fragil, double length, String shopCart*/
        return Order.getInstanceOrder(
            orderDTO.getReference(),
            orderDTO.getDescription(),
            orderDTO.getInitDate(),
            orderDTO.getAddress(),
            orderDTO.getPhoneContact(),
            orderDTO.getIdClient(),
            orderDTO.getName(),
            orderDTO.getSurname(),
            orderDTO.getDNI(),
            orderDTO.getPaymentDate(),
            orderDTO.getDeliveryDate(),
            orderDTO.getFinishDate(),
            orderDTO.getHigh(),
            orderDTO.getWidth(),
            orderDTO.getDepth(),
            orderDTO.getWeight(),
            orderDTO.getisFragil(),
            orderDTO.getLength(),
            orderDTO.getShopCartDetails()
        );
    }

    public static OrderDTO dtoFromOrder(Order o){
        /*int reference, String description, String initDate, String address, String phoneContact, 
    String idClient, String name, String surname, String DNI, String paymentDate, String deliveryDate, String finishDate, double high, double width, 
    double depth, double weight, boolean fragil, double length, String shopCart */
        return new OrderDTO(
            o.getReference(),
            o.getDescription(),
            o.getInitDate(),
            o.getAddress(),
            o.getPhoneContact(),
            o.getIdClient(),
            o.getName(),
            o.getSurname(),
            o.getDNI(),
            o.getPaymentDate(),
            o.getDeliveryDate(),
            o.getFinishDate(),
            o.getHigh(),
            o.getWidth(),
            o.getDepth(),
            o.getWeight(),
            o.getFragil(),
            o.getLength(),
            o.getShopCartDetails()
        );
    }
}
