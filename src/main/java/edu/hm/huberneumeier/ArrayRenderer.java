package edu.hm.huberneumeier;

/**
 *
 * @author Tobias Huber
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
public class ArrayRenderer implements IRender{
    private int[] toRender;

    public ArrayRenderer(Object toRender) {
        this.toRender = (int[])toRender;
    }

    public String render(){
        String renderedArray = "[";
        for(int i= 0; i < getToRender().length; i++){
            renderedArray += getToRender()[i] + ", ";
        }
        if(renderedArray.length() > 2)
            renderedArray = renderedArray.substring(0,renderedArray.length()-2);
        renderedArray += "]";
        return renderedArray;
    }

    private int[] getToRender() {
        return toRender;
    }
}
