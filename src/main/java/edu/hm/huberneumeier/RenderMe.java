package edu.hm.huberneumeier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Render annotation used in this example.
 *
 * @author Tobias Huber, Andreas Neumeier
 * @version 2017-03-29
 * @created by Tobias Huber on 29.03.2017
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {
    //possible parameters, which can be passed by using the annotation
    Class<? extends IRenderer> with() default Renderer.class;
}
