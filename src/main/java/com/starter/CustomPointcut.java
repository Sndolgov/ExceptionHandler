package com.starter;

import com.starter.property.HandlerProperty;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class CustomPointcut extends DynamicMethodMatcherPointcut
{
    @Autowired
    private HandlerProperty property;

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects)
    {
        return method.isAnnotationPresent(HandleException.class);
    }

    @Override
    public ClassFilter getClassFilter()
    {
        return clazz ->
        {
            String packageName = clazz.getPackage().getName();
            for (String aPackage : property.getPackages())
            {
                if (packageName.contains(aPackage))
                    return true;
            }
            return false;
        };
    }
}
