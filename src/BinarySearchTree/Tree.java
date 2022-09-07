package BinarySearchTree;

public class Tree {

    private TreeNode root;

    //**** This implementation does not allow duplicate values ****
    // insert() method in TreeNode checks for that
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value); //calling TreeNode insert()
        }
    }

    //Get a node with an int value
    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    //Delete Method
    public void delete(int value) {
        root = delete(root, value); //calling a second delete method
                                    //1st parameter: replacement node; 2nd parameter: value to delete

    }

    //This returns the replacement node (for the deleted).
    //In the above delete method, if the root isn't the node being replaced, we get the same node back for the root

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;   // If the tree is empty, return null => stop the recursion of going left or right
        }
        if (value < subtreeRoot.getData()) {
            //replace the leftChild with the result of the delete() / or return leftChild back
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));

        } else {
            //value == subtreeRoot.getData()  => This is the node to delete => What to replace it with:
            //Cases 1 and 2: node has 0 or 1 children: 0 => replace with null;  1 => replace with that child node
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild(); //either rightChild or null
            }
            else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
            // Case 3: a node with 2 children. Replacement comes from either the left or the right subtrees.
            // The rule is: max from the left, or min from the right to replace the subtreeRoot node
            subtreeRoot.setData(subtreeRoot.getRightChild().getMin()); //replacing with min node of rightChild tree
            //Delete the smallest node in the right subTree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData())); //the value to delete is: subtreeRoot.getData()
            //OR  if left subTree replacement is chosen
            // subtreeRoot.setData(subtreeRoot.getLeftChild().getMax());
        }
        return subtreeRoot;  //The current node is not the value to delete -> it is returned (otherwise the replacement node is returned)
    }

    //Get Min value
    public int getMin() {
        if (root == null) {
            return Integer.MIN_VALUE;  //Signal to the user that the tree is empty
        }
        else {
            return root.getMin();
        }
    }

    //Get Max value
    public int getMax() {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        else {
            return root.getMax();
        }
    }




    //To print out a tree
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }


}
