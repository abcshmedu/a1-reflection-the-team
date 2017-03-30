package edu.hm.huberneumeier;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Default Renderer, renders a object to a string.
 * If necessary it will call a other renderer.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
public class Renderer implements IRenderer {
    private Object toRender;

    public Renderer(Object toRender) {
        this.toRender = toRender;
    }

    public String render() {
        String renderedObject = "Instance of "+getToRender().getClass().getCanonicalName() + ":\n";

        for (Field field : getToRender().getClass().getDeclaredFields()) {
            //set field accessible (ignore private)
            field.setAccessible(true);

            //get annotation from field
            RenderMe annotation = field.getAnnotation(RenderMe.class);

            //check if annotation is not equal to default
            if (annotation.with() != Renderer.class) {
                try {
                    //try to create a new object of renderer given by annotation
                    IRenderer render = annotation.with().getConstructor(Object.class).newInstance(field.get(getToRender()));
                    //call render to get string from
                    renderedObject += getFieldAsString(field, render.render());
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
                //create string from field
                if (value != null) {
                    renderedObject += getFieldAsString(field, value.toString());
                }
            }
        }
        //return created string, it represents the object and all the marked fields
        return renderedObject;
    }

    private Object getToRender() {
        return toRender;
    }

    private String getFieldAsString(Field field, String value){
        //TODO get int[] instead of [I if field is an array
        return field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + value + "\n";
    }
}
