package com.nextgenretro.nextgenretro.model.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not Found. Id " + id);
    }
}
