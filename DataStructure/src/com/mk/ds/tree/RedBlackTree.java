package com.mk.ds.tree;

class RedBlackNode {
    RedBlackNode left, right;
    int element;
    int color;

    public RedBlackNode(int element) {
        this.element = element;
    }

}

public class RedBlackTree {
    private static final Integer RED   = 1;
    private static final Integer BLACK = 0;

    private RedBlackNode root;

    public RedBlackTree(){
        root = null;
    }

    public void add(Integer value) {
        if (value == null) throw new IllegalArgumentException("Inserting null value");
        root = add(root, value);
        root.color = BLACK;
    }

    private RedBlackNode add(RedBlackNode rbnode, Integer value) {
        if(rbnode == null) {
            rbnode = new RedBlackNode(value);
            rbnode.color = RED;
        } else if(rbnode.element > value) {
            rbnode.left = add(rbnode.left, value);
        } else if(rbnode.element < value) {
            rbnode.right = add(rbnode.right, value);
        }

        if (null != rbnode.right && (rbnode.right.color == RED) && (null != rbnode.left && rbnode.left.color == BLACK))
                rbnode = rotateLeft(rbnode);
        if (null != rbnode.left && (rbnode.left.color == RED) &&  (null != rbnode.left.left && rbnode.left.left.color == RED))
                rbnode = rotateRight(rbnode);
        if ((null != rbnode.left && rbnode.left.color == RED)  && (null != rbnode.right && rbnode.right.color == RED))
                flipColors(rbnode);
        return rbnode;
    }

    private void flipColors(RedBlackNode rbNode) {
        flipColorsForChild(rbNode);
        flipColorsForChild(rbNode.left);
        flipColorsForChild(rbNode.right);
    }

    private void flipColorsForChild(RedBlackNode rbNode) {
        if(rbNode.color == RED){
            rbNode.color = BLACK;
        } else {
            rbNode.color = RED;
        }
    }

    private RedBlackNode rotateRight(RedBlackNode node) {
        RedBlackNode rbNode = node.left;
        node.left = rbNode.right;
        rbNode.right = node;
        rbNode.color = rbNode.right.color;
        rbNode.right.color = RED;
        return rbNode;
    }

    private RedBlackNode rotateLeft(RedBlackNode node) {
        RedBlackNode rbNode = node.right;
        node.right = rbNode.left;
        rbNode.left = node;
        rbNode.color = rbNode.left.color;
        rbNode.left.color = RED;
        return rbNode;
    }

    public void display(RedBlackNode root) {
        if (root != null) {
            display(root.left);
            System.out.println(" Node :: Element :- " + root.element+" color :- " +root.color);
            display(root.right);
        }
    }

    public static void main(String[] args) {
       RedBlackTree tree = new RedBlackTree();
       tree.add(10);
       tree.add(20);
       tree.add(30);
       tree.add(40);
       tree.add(15);
       tree.add(17);
       tree.display(tree.root);
    }
}
