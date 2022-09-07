package BinarySearchTree;

public class TreeNode {

    //This tree will store int values:
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;


    public TreeNode(int data) {
        this.data = data;
    }

    //Methods

    //insert method checks that a value inserted to TreeNode isn't a duplicate
    public void insert(int value) {
        if (value == data) {
            return;   // disabling duplicates
        }
        if (value < data) {
            if (leftChild == null) {
                //the position is open
                leftChild = new TreeNode(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        //value > data
        else {
            if (rightChild == null) {
                rightChild = new TreeNode(value) ;
            }
            else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        }
        else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        return null;
    }

    // Traverse in order is a (left->root->right) sorted traverse (from min to max)
    public void traverseInOrder() {
        if(leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    //Get Min value
    //*** Here the return type is int, for simplicity, but would have been TreeNode otherwise ***//
    public int getMin() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.getMin();
        }
    }
    //Get Max value
    public int getMax() {
        if (rightChild == null) {
            return data;
        }
        else{
            return rightChild.getMax();
        }
    }


    //Getters and Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public String toString() {
        return "Data = " + data;
    }
}
