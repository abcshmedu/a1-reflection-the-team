package edu.hm.huberneumeier;

/**
 * Renderer to render an (int) array.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017 -03-29
 */
public class ArrayRenderer implements IRenderer {
    private int[] toRender;

    /**
     * Passing the field to render, it will be type cased to an int array.
     *
     * @param toRender the to render
     */
    public ArrayRenderer(Object toRender) {
        this.toRender = (int[]) toRender;
    }

    /**
     * Render the field to an string.
     *
     * @return rendered Array
     */
    public String render() {
        String renderedArray = "[";
        for (int i = 0; i < getToRender().length; i++) {
            renderedArray += getToRender()[i] + ", ";
        }
        if (renderedArray.length() > 2) {
            renderedArray = renderedArray.substring(0, renderedArray.length() - 2);
        }
        renderedArray += "]";
        return renderedArray;
    }

    /**
     * Getter of int Array.
     *
     * @return the int array
     */
    private int[] getToRender() {
        return toRender;
    }
}
