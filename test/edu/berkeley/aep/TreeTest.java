package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void aTreeWithOneNodeWithDataOneShouldEqualAnotherTreeWithOneNodeWithDataOne() {
        Tree oneTree = new Tree(1);
        Tree oneTree2 = new Tree(1);
        assertEquals(oneTree, oneTree2);
    }
}
