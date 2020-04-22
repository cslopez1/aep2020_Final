package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTest {

    private Tree nodeOne = new Tree(1);
    private Tree nodeTwo = new Tree(2);
    private Tree nodeThree = new Tree(3);
    private Tree nodeFour = new Tree(4);
    private Tree nodeFive = new Tree(5);
    private Tree nodeSix = new Tree(6);
    private Tree nodeSeven = new Tree(7);

    public TreeTest() {
        nodeOne.addChild(nodeTwo);
        nodeOne.addChild(nodeThree);
        nodeTwo.addChild(nodeFour);
        nodeTwo.addChild(nodeFive);
        nodeTwo.addChild(nodeSix);
        nodeThree.addChild(nodeSeven);
    }

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

    @Test
    public void addingAChildWithItsOwnChildrenShouldOnlyIncreaseNumberOfChildrenByOne() {
        Tree oneTree = new Tree(1);
        Tree twoTree = new Tree(2);
        twoTree.addChild(new Tree(1));
        oneTree.addChild(new Tree(2));
        assertEquals(1, oneTree.numChildren());
    }

    @Test
    public void sizeOfTreeWithThreeNodesShouldBeThree() {
        Tree oneTree = new Tree(1);
        Tree twoTree = new Tree(2);
        twoTree.addChild(new Tree(1));
        oneTree.addChild(twoTree);
        assertEquals(3, oneTree.size());
    }

    @Test
    public void sizeOfTreeWithFourNodesShouldBeFour() {
        Tree oneTree = new Tree(1);
        Tree twoTree = new Tree(2);
        twoTree.addChild(new Tree(3));
        oneTree.addChild(twoTree);
        oneTree.addChild(new Tree(0));
        assertEquals(4, oneTree.size());
    }

    // From here begins the tests using the same standardized tree, initialized by TreeTest.
    // TestTree has two children from the root node, with one child having three of its own children, and the other
    // child having one. There are a total of seven nodes.

    @Test
    public void sizeOfTestTreeIsSeven() {
        // to ensure it works for nodes with >2 children
        assertEquals(7, nodeOne.size());
    }

    @Test
    public void sumOfTestTreeIs28() {
        assertEquals(28, nodeOne.sumTree());
    }

    @Test
    public void treeContainsNodeTwoShouldBeTrue() {
        assertTrue(nodeOne.contains(nodeTwo));
    }
}
