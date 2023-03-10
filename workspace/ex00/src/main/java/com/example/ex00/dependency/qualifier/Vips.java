package com.example.ex00.dependency.qualifier;

public class Vips implements Resturant {
    public int steak = Resturant.steakPrice + 500000;

    @Override
    public boolean isSalad() {
        return true;
    }
}
