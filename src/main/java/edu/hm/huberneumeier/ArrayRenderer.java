package edu.hm.huberneumeier;

/**
 *
 * @author Tobias Huber
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
public class ArrayRenderer extends Renderer {

    public ArrayRenderer(SomeClass toRender) {
        super(toRender);
    }

    @Override
    public String render(){
        //for (Field field : getaObject().getClass().getDeclaredFields()) {
        //    field.setAccessible(true);
        //    Object value = null;
        //    try {
        //        value = field.get(getaObject());
        //    } catch (IllegalAccessException e) {
        //        e.printStackTrace();
        //    }
        //    if (value != null) {
        //        System.out.println(field.getName() + "=" + value);
        //    }
        //}
        return "";
    }
}
