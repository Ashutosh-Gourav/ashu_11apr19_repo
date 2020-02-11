
package com.pojo.service.infrastructure.sql;

import org.springframework.jdbc.support.KeyHolder;

public interface KeyHolderFactory {

    KeyHolder create();

}
