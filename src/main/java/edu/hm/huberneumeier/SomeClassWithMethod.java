/**
 * Example class to render.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 */
package edu.hm.huberneumeier;

import java.util.Date;

/**
 * A class for testing the Renderer and ArrayRenderer.
 */
public class SomeClassWithMethod {
    @RenderMe(with = ArrayRenderer.class)
    int[] array = {1, 2, 3,};
    @RenderMe
    private int foo;
    @RenderMe
    private Date date = new Date(123456789);

    /**
     * Constructor for SomeClass.
     *
     * @param foo initialize foo
     */
    public SomeClassWithMethod(int foo) {
        this.foo = foo;
    }

    /**
     * Method for testing.
     */
    @RenderMe
    public int getTheNumber() {
        return 42;
    }
}
