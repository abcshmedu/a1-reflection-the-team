import edu.hm.huberneumeier.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


/**
 * Tests for the renders.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 */

public class RendererTest {

    @Test
    public void testRendering() throws Exception {
        SomeClass toRender = new SomeClass(5);
        Renderer renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.huberneumeier.SomeClass:\n" +
                "array (Type int[]): [1, 2, 3]\n" +
                "foo (Type int): 5\n" +
                "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }

    @Test
    public void testRenderingWithMethode() throws Exception {
        SomeClassWithMethod toRender = new SomeClassWithMethod(5);
        Renderer renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.huberneumeier.SomeClassWithMethod:\n" +
                "array (Type int[]): [1, 2, 3]\n" +
                "foo (Type int): 5\n" +
                "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" +
                "getTheNumber (Type int): 42\n", renderer.render());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRenderingWithParameterMethode() throws Exception {
        SomeClass toRender = new SomeClass(5) {
            /*
             * Method for testing.
             */
            @RenderMe
            public int returnEnteredNumber(int x) {
                return x;
            }
        };
        Renderer renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.huberneumeier.SomeClassWithParameterMethod:\n" +
                "array (Type int[]): [1, 2, 3]\n" +
                "foo (Type int): 5\n" +
                "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }
}
