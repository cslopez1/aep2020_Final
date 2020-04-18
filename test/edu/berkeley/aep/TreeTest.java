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

    @Test
    public void aTreeWithOneNodeShouldHaveChildrenOfLength0() {
        Tree oneTree = new Tree(1);
        assertEquals(0, oneTree.numChildren());
    }

    @Test
    public void addingAChildShouldIncreaseNumberOfChildrenByOne() {
        Tree oneTree = new Tree(1);
        oneTree.addChild(new Tree(2));
        assertEquals(1, oneTree.numChildren());
    }
}
