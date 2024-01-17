package com.akilisha.mapper.definition;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public interface MapperSrc extends Mappable {

    default void accept(String fromField, Class<?> fromType, String fieldName, Class<?> fieldType, MapperDest target, Mapping mapping) throws Throwable {
        MethodType getterMethodType = MethodType.methodType(fromType);
        String getter = "get" + Character.toUpperCase(fromField.charAt(0)) + fromField.substring(1);
        if (ClassDef.isJavaType(fieldType)) {
            MethodHandle getterHandler;
            try {
                getterHandler = lookup.findVirtual(getThisTarget().getClass(), getter, getterMethodType);
            } catch (NoSuchMethodException th) {
                getter = "is" + Character.toUpperCase(fromField.charAt(0)) + fromField.substring(1);
                getterHandler = lookup.findVirtual(getThisTarget().getClass(), getter, getterMethodType);
            }
            Object fieldValue = getterHandler.invoke(getThisTarget());
            if (fromType.equals(fieldType)) {
                //map value now
                target.map(fieldName, fieldType, fieldValue);
            } else {
                Converter<?> converter = mapping.get(fieldName);
                Object convertedValue = converter.getEval().apply(fieldValue);
                target.map(fieldName, fieldType, convertedValue);
            }

        } else {
            throw new RuntimeException("Not yet handled");
        }
    }
}