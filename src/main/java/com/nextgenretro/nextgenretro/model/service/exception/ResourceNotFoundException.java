package com.nextgenretro.nextgenretro.model.service.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not Found. Id " + id);
    }
}
