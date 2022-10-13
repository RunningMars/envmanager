package com.bikego.env.management.controller;

public class UserDaoImpl implements UserDao{

    @Override
    public void add(String name) {
        System.out.println("一些列複雜的業務邏輯:" + name);
    }
}
