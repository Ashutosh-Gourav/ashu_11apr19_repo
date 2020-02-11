
package com.pojo.service.infrastructure.sql;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class KeyHolderFactoryImpl implements KeyHolderFactory {

    @Override
    public KeyHolder create() {
        return new GeneratedKeyHolder();
    }

}
