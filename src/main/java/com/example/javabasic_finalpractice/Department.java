package com.example.javabasic_finalpractice;

import java.io.Serializable;

public class Department  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ID;
    private String name;
    private String domain;

    @Override
    public String toString() {
        return "Department{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
