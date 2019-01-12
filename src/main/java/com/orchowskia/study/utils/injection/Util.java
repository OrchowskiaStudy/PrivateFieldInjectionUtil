package com.orchowskia.study.utils.injection;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class Util {
    public static <T> T injectPrivateDependency(T toFill, Object toInject) {
        Class<?> toFillClass = toFill.getClass();
//        // ReflectionTestUtils.setField(toFill, "mysteriousNameOfField", toInject);
        Optional<Field> chap = Arrays.stream(toFillClass.getDeclaredFields())
                .filter(x -> x.getGenericType().getTypeName().equals(toInject.getClass().getTypeName())).findFirst();
        chap.ifPresent(x -> {
            try {
                x.setAccessible(true);
                x.set(toFill, toInject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return toFill;
    }
}
