package edu.hm.huberneumeier;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Default Renderer, renders a object to a string.
 * If necessary it will call a other renderer.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 */
public class Renderer implements IRenderer {
    private Object toRender;

    /**
     * Default ctor.
     *
     * @param toRender  object to render
     */
    public Renderer(Object toRender) {
        this.toRender = toRender;
    }

    /**
     * Renders the object got in ctor.
     *
     * @return returns a string with all rendered types
     */
    public String render() {
        String renderedObject = "Instance of " + getToRender().getClass().getCanonicalName() + ":\n";

        for (Field field : getToRender().getClass().getDeclaredFields()) {
            //set field accessible (ignore private)
            field.setAccessible(true);

            //get annotation from field
            RenderMe annotation = field.getAnnotation(RenderMe.class);

            //check if annotation is not equal to default
            if (annotation != null && annotation.with() != Renderer.class) {
                try {
                    //try to create a new object of renderer given by annotation
                    IRenderer render = annotation.with().getConstructor(Object.class).newInstance(field.get(getToRender()));
                    //call render to get string from
                    renderedObject += getFieldAsString(field, render.render());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException();
                }
            } else {
                //get value of field
                Object value = null;
                try {
                    value = field.get(getToRender());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException();
                }
                //create string from field
                if (value != null) {
                    renderedObject += getFieldAsString(field, value.toString());
                }
            }
        }
        for (Method method : getToRender().getClass().getDeclaredMethods()) {
            //set field accessible (ignore private)
            method.setAccessible(true);

            //get annotation from field
            RenderMe annotation = method.getAnnotation(RenderMe.class);

            //Get value of method
            Object value = null;
            try {
                value = method.invoke(getToRender());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException();
            }
            //create string from field
            if (value != null) {
                renderedObject += getMethodAsString(method, value.toString());
            }
        }

        //return created string, it represents the object and all the marked fields
        return renderedObject;
    }

    /**
     * Getter for the object to render.
     *
     * @return  the object to render
     */
    private Object getToRender() {
        return toRender;
    }

    /**
     * Format the gotten information and return it.
     *
     * @param field the field found in the object rendered
     * @param value the value of the field
     * @return  a string with all information about the rendered type
     */
    private String getFieldAsString(Field field, String value) {
        return field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + value + "\n";
    }

    /**
     * Format the gotten information and return it.
     *
     * @param method the method found in the object rendered
     * @param value the value of the field
     * @return  a string with all information about the rendered type
     */
    private String getMethodAsString(Method method, String value) {
        return method.getName() + " (Type " + method.getReturnType().getCanonicalName() + "): " + value + "\n";
    }
}
