package com.incretio.creditmanager.entity;

public class Credit {

    private final long uid;
    private final String name;

    public Credit(long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }
}
