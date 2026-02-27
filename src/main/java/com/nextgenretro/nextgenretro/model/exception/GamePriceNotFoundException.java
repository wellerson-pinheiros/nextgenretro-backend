package com.nextgenretro.nextgenretro.model.exception;

public class GamePriceNotFoundException extends RuntimeException{
    public GamePriceNotFoundException(Double minPrice, Double maxPrice) {
        super("The price cannot be less than or equal to 0." + minPrice + " to " + maxPrice);
    }
}
