package com.core.appservices.serializers;

import com.core.entity.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer<T> implements Serializer<T> {
    private ObjectMapper mapper = new ObjectMapper();

    public String serialize(T object)throws ServiceException{
        try {
            return this.mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public T desearialize(String source, Class<T> object)throws ServiceException{
        try {
            return mapper.readValue(source, object);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
