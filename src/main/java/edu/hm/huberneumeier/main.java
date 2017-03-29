package edu.hm.huberneumeier;

/**
 * Description.
 *
 * @author Andreas Neumeier
 * @version 2017-03-29
 * @created by Andreas Neumeier on 29.03.2017
 */
public class main {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass(42);
        Renderer renderer = new Renderer(someClass);
        System.out.println(renderer.render());
    }
}
