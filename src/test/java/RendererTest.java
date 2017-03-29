import edu.hm.huberneumeier.Renderer;
import edu.hm.huberneumeier.SomeClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */

public class RendererTest {
    private SomeClass toRender;
    private Renderer renderer;

    @Before
    public void setUp() {
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
    }

    @Test
    public void testRendering() throws Exception {
        assertEquals("Instance of edu.hm.SomeClass:\n" +
                "foo (Type int): 5\n" +
                "array (Type int[]) [1, 2, 3, ]\n" +
                "date (Type java.util.Date):Fri Jan 02 11:17:36 CET 1970\n ", renderer.render());
    }

}