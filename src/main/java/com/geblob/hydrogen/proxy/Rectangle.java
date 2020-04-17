package com.geblob.hydrogen.proxy;

import lombok.Data;

@Data
public class Rectangle implements Sizable {
    private Integer length;
    private Integer width;

    @Override
    public Integer getSize() {
        System.out.println("computing");
        return (length + width) * 2;
    }
}
