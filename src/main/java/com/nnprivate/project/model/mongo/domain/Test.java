package com.nnprivate.project.model.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Document(collection = "test")
public class Test {

    public Test(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    private String id;

    String username;

    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Test{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
