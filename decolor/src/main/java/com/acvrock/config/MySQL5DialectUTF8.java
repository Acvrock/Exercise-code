package com.acvrock.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created by moon on 11/02/2017.
 *
 * @Description:
 */
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect {
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
    }
}