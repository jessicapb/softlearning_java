package com.core.appservices.serializers;

import com.core.entity.exceptions.ServiceException;

public interface Serializer<T> {
    public String serialize(T object)throws ServiceException;
    public T desearialize(String source, Class<T> object)throws ServiceException;
}
