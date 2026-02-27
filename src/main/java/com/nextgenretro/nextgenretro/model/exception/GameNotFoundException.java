package com.nextgenretro.nextgenretro.model.exception;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException(String name){
        super("Game with name "+name+" not found");
    }
}
