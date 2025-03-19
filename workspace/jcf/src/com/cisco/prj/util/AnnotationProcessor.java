package com.cisco.prj.util;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    // AnnotationProcessor.generateCreateStatement(Employee.class);
   //  AnnotationProcessor.generateCreateStatement(Product.class);

    public static String generateCreateStatement(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();
        Table table = clazz.getAnnotation(Table.class);
        if(table != null) {
            builder.append("create table ");
            builder.append(table.name());
            builder.append("("); // create table products (

            Method[] methods = clazz.getDeclaredMethods(); // not inherited
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column col = m.getAnnotation(Column.class);
                    if(col != null) {
                        builder.append(col.name());
                        builder.append(" ");
                        builder.append(col.type());
                        builder.append(" ,"); //  // create table products (PID NUMERIC(10) ,
                    }
                }
            }
            // after iteration of methods we have extra ,
            builder.setCharAt(builder.lastIndexOf(","), ')');
        }
        return builder.toString();
    }

    public static String generateInsertStatement(Object obj) {
        StringBuilder builder = new StringBuilder();
        Table table = obj.getClass().getAnnotation(Table.class);
        if(table != null) {
            builder.append("insert into ");
            builder.append(table.name());
            builder.append(" values ( "); // insert into  products values (

            Method[] methods = obj.getClass().getDeclaredMethods(); // not inherited
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column col = m.getAnnotation(Column.class);
                    if(col != null) {
                        try {
                            Object ret = m.invoke(obj);
                            if(ret instanceof  String) {
                                builder.append("'");
                                builder.append(ret);
                                builder.append("'");
                            } else {
                                builder.append(ret);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        builder.append(" ,"); //  // create table products (PID NUMERIC(10) ,
                    }
                }
            }
            // after iteration of methods we have extra ,
            builder.setCharAt(builder.lastIndexOf(","), ')');
        }
        return builder.toString();
    }
}
