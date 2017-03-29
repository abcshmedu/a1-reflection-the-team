package edu.hm.huberneumeier;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
public class Renderer implements IRender {
    private Object toRender;

    public Renderer(Object toRender) {
        this.toRender = toRender;
    }

    public String render() {
        String renderedObject = "";

        for (Field field : getToRender().getClass().getDeclaredFields()) {
            //set field accessible (ignore private)
            field.setAccessible(true);

            //get annotation from field
            RenderMe annotation = field.getAnnotation(RenderMe.class);

            if (annotation.with() != Renderer.class) {
                try {
                    IRender render = annotation.with().getConstructor(Object.class).newInstance(field.get(getToRender()));
                    renderedObject += field.getName() + " (" + field.getType().getName() + ") " + render.render() + "\n";
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } else {

                //get value of field
                Object value = null;
                try {
                    value = field.get(getToRender());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (value != null) {
                    renderedObject += field.getName() + " (" + field.getType().getName() + ") " + value + "\n";
                }
            }
        }
        return renderedObject;
    }

    private Object getToRender() {
        return toRender;
    }
}
