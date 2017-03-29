/**
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
package edu.hm.huberneumeier;

import java.util.Date;

public class SomeClass {
    @RenderMe
    private int foo;
    @RenderMe(with = "edu.hm.huberneumeier.ArrayRenderer")
    int[] array = {1, 2, 3,};
    @RenderMe
    private Date date = new Date(123456789);

    public SomeClass(int foo) {
        this.foo = foo;
    }
}
