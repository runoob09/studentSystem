package com.edu.xaufe.enity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
