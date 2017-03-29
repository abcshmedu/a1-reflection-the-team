package edu.hm.huberneumeier;

import java.lang.reflect.Field;

/**
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
public class Renderer {
    private SomeClass aObject;

    public Renderer(SomeClass toRender) {
        aObject = toRender;
    }

    public String render() {
        for (Field field : getaObject().getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(getaObject());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value != null) {
                System.out.println(field.getName() + "=" + value);
            }
        }
        return "";
    }

    private SomeClass getaObject() {
        return aObject;
    }
}
