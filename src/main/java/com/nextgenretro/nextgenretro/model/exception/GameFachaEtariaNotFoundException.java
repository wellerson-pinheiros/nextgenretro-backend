package com.nextgenretro.nextgenretro.model.exception;

public class GameFachaEtariaNotFoundException extends RuntimeException{
    public GameFachaEtariaNotFoundException(String fachaEtaria){
        super("Game with name "+fachaEtaria+" not found");
    }
}
