package LinkedList;

public class SearchTree implements NodeList {

    // A search tree can be described as a root with a left tree and a right tree:
    // Traversing each node on the left (each node is a potential root of its own tree) and up the root
    // then down the right tree. A node does not link to previous.
    // Traversal is through a recursive function

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            //the tree is empty, newItem becomes root
            this.root = newItem;
            return true;
        }
        //otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;

        //By design, the while loop condition is always true, because we are always checking for null
        // before moving left or right, and could have written as while (true), instead of returning
        // false in the end. The choice was made for readability purposes.
        while(currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                //newItem > currentItem => going to the right
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                }
                else {
                    //there is no node to the right
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem < currentItem => going left
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                }
                else {
                    //there is no node to the right
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                //equal => do not add
                System.out.println(newItem.getValue() + " is already present.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
            else {
                //currentItem is equal to item => remove currentItem
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;  //item is not in the tree
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                // again, we are deleting the root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            // and delete the smallest
            if (leftmostParent == item) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted).
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null).
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        //recursive method
        if (root != null) {
            traverse(root.previous()); //previous = left tree
            System.out.println(root.getValue());
            traverse(root.next());  // next = right tree
        }

    }
}
