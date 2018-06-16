package com.github.cumtfc.guitar.po.wood;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wood implements java.io.Serializable {

    //	CAMPHOR("camphor"),//樟木
//	BRICH("birch"),//桦木
//	KOREANPINE("koreanpine");//红松
    private String value;

    public Wood() {
    }

    public Wood(String value) {
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
