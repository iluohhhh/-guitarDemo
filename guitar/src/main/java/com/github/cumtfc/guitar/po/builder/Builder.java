package com.github.cumtfc.guitar.po.builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Builder implements java.io.Serializable {

    //	JIANGSU("jiangsu"),SHANGHAI("shanghai"),SHANDONG("shandong");
    private String value;

    public Builder() {
    }

    public Builder(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Id
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
