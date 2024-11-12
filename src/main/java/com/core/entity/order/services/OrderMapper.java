package com.core.entity.order.services;

import com.core.entity.exceptions.BuildException;
import com.core.entity.order.domain.model.Order;

public class OrderMapper {
    public static Order orderFromDTO(OrderDTO ordto) throws BuildException{
        return Order.getInstanceOrder(
            ordto.getReference(),
            ordto.getDescription(),
            ordto.getInitDate(),
            ordto.getFinishDate(),
            ordto.getAddress(),
            ordto.getPhoneContact(),
            ordto.getIdClient(),
            ordto.getName(),
            ordto.getSurname(),
            ordto.getDNI(),
            ordto.getPaymentDate(),
            ordto.getDeliveryDate(),
            ordto.getHigh(),
            ordto.getWidth(),
            ordto.getDepth(),
            ordto.getWeight(),
            ordto.getisFragil(),
            ordto.getLength()
        );
    }

    public static OrderDTO dtoFromOrder(Order o){
        return new OrderDTO(
            o.getReference(),
            o.getDescription(),
            o.getInitDate(),
            o.getFinishDate(),
            o.getAddress(),
            o.getPhoneContact(),
            o.getIdClient(),
            o.getName(),
            o.getSurname(),
            o.getDNI(),
            o.getPaymentDate(),
            o.getDeliveryDate(),
            o.getHigh(),
            o.getWidth(),
            o.getDepth(),
            o.getWeight(),
            o.getFragil(),
            o.getLength()
        );
    }
}
