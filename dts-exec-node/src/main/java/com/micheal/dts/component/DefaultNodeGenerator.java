package com.micheal.dts.component;

import java.util.UUID;

/**
 * Created by michael on 2019/1/6.
 */
public class DefaultNodeGenerator implements NodeGenerator {
    @Override
    public String generate() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
