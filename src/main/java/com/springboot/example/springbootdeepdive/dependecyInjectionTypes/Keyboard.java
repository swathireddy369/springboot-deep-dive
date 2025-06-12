package com.springboot.example.springbootdeepdive.dependecyInjectionTypes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public interface Keyboard {
    public void getData();
}
@Component
@Primary
class BluetoothKeyBoard implements Keyboard {
    public BluetoothKeyBoard(){
        System.out.println("BluetoothKeyBoard created");
    }

    @Override
    public void getData() {
        System.out.println("BluetoothKeyBoard getData");
    }
}

@Component
class WiredKeyBoard implements Keyboard {
    public WiredKeyBoard(){
        System.out.println("WiredKeyBoard created-1");
    }

    @Override
    public void getData() {
        System.out.println("WiredKeyBoard getData");
    }
}
