package com.sample.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserProfile {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String phone;
    public String address;
}
