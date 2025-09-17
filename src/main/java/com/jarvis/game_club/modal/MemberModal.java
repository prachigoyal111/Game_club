package com.jarvis.game_club.modal;
import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "members")
public class MemberModal {
    @Id
    private String id;
    private String name;
    private String balance;
    private String phone;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public MemberModal(String id, String name, String balance, String phone) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.phone = phone;
    }
    public MemberModal() {
    }
    @Override

    public String toString() {
        return "MemberModal [id=" + id + ", name=" + name + ", balance=" + balance + ", phone=" + phone + "]";
    }
    
}
