package edu.hm.huberneumeier;

/**
 * Renderer to render an (int) array.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
public class ArrayRenderer implements IRenderer {
    private int[] toRender;

    //passing the field to render, it will be type cased to an int array
    public ArrayRenderer(Object toRender) {
        this.toRender = (int[])toRender;
    }

    //render the field to and an string
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
