package com.nextgenretro.nextgenretro.model.controller.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not Found. Id " + id);
    }
}
