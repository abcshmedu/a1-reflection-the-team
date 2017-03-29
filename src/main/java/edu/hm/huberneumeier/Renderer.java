package edu.hm.huberneumeier;

import java.lang.reflect.Field;

/**
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
            //set field accessible (ignore private)
            field.setAccessible(true);
            //get annotation from field
            RenderMe annotation = field.getAnnotation(RenderMe.class);

            if (annotation != null) {
                try {
                    Class obj = Class.forName(annotation.with());
                    obj.newInstance();
                    obj.cast(new Renderer(getaObject()));

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

            //get value of field
            Object value = null;
            try {
                value = field.get(getaObject());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


            if (value != null) {
                System.out.println(field.getName() + " = " + value);
                System.out.println(field.getGenericType());
            }


        }
        return "";
    }

    SomeClass getaObject() {
        return aObject;
    }
}
