package com.example.DrawLoterya.services;

public interface UserService<T> {
    void create(T t);
    void update(T t);
    String get(String key);
}
