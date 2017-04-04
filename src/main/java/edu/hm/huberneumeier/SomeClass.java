/**
 * Example class to render.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 */
package edu.hm.huberneumeier;

import java.util.Date;

public class SomeClass {
    @RenderMe(with = ArrayRenderer.class)
    int[] array = {1, 2, 3,};
    @RenderMe
    private int foo;
    @RenderMe
    private Date date = new Date(123456789);

    public SomeClass(int foo) {
        this.foo = foo;
    }
}
