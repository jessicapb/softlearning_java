package com.core.entity.order.domain.model;

public enum OrderStatus {
    CREATED,
    CANCELLED,
    CONFIRMED,
    FORTHCOMMING,//paquete preparado y almacenado pendiente de envio
    DELIVERED,
    FINISHED
}
