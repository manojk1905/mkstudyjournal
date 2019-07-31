package com.mk.ds.tree;

class AVLNode {
    int data, height;
    AVLNode left, right;

    AVLNode(int data) {
        this.data = data;
        height = 1;
        left = null;
        right = null;
    }
}

class AVLTree {
    AVLNode root;
    private int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    public AVLNode insert(AVLNode node, int value) {
        if (node == null)
            return (new AVLNode(value));
        if (value < node.data)
            node.left = insert(node.left, value);
        else if (value > node.data)
            node.right = insert(node.right, value);
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && value < node.left.data)
            return rightRotate(node);
        if (balance < -1 && value > node.right.data)
            return leftRotate(node);
        if (balance > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private int max(int leftNodeHeight, int rightNodeHeight) {
        return (leftNodeHeight > rightNodeHeight) ? leftNodeHeight : rightNodeHeight;
    }

    private AVLNode rightRotate(AVLNode avlNode) {
        AVLNode node = avlNode.left;
        AVLNode rightChild = node.right;

        node.right = avlNode;
        avlNode.left = rightChild;

        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        node.height = max(height(node.left), height(node.right)) + 1;

        return node;
    }

    private AVLNode leftRotate(AVLNode avlNode) {
        AVLNode node = avlNode.right;
        AVLNode leftChild = node.left;

        node.left = avlNode;
        avlNode.right = leftChild;

        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        node.height = max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public void display(AVLNode root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 17);
        tree.display(tree.root);
    }
}

