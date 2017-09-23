package com.dynu.stevenseegal.oregen.util;

import javax.annotation.Nullable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper
{
    public static MethodHandle findMethod(final Class<?> clazz, final String methodName, @Nullable final String methodObfName, final Class<?>... parameterTypes) {
        final Method method = net.minecraftforge.fml.relauncher.ReflectionHelper.findMethod(clazz, methodName, methodObfName, parameterTypes);
        try {
            return MethodHandles.lookup().unreflect(method);
        } catch (final IllegalAccessException e) {
            throw new net.minecraftforge.fml.relauncher.ReflectionHelper.UnableToFindMethodException(e);
        }
    }

    public static MethodHandle findFieldGetter(final Class<?> clazz, final String fieldName, @Nullable final String fieldObfName) {
        final Field field = net.minecraftforge.fml.relauncher.ReflectionHelper.findField(clazz, getFieldNameArray(fieldName, fieldObfName));

        try {
            return MethodHandles.lookup().unreflectGetter(field);
        } catch (final IllegalAccessException e) {
            throw new net.minecraftforge.fml.relauncher.ReflectionHelper.UnableToAccessFieldException(new String[0], e);
        }
    }

    private static String[] getFieldNameArray(final String fieldName, @Nullable final String fieldObfName) {
        if (fieldObfName != null) {
            return new String[]{fieldName, fieldObfName};
        } else {
            return new String[]{fieldName};
        }
    }
}
