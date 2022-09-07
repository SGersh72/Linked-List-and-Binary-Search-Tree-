package LinkedList;

public class MyLinkedList implements NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    //This list is sorted and does not allow duplicates
    public boolean addItem(ListItem newItem) {
        if (this.root == null) { //the list is empty => newItem become root
            this.root = newItem;
            return true;
        }
        //adding a new item in its place in a sorted list implementing compareTo()
        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {  //newItem > currentItem => move to the right
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else { //there is no next(), so newItem is added as the tail of the list
                    currentItem.setNext(newItem).setPrevious(currentItem); //shortcut, since each method in Node returns
                    //newItem.setPrevious(currentItem);
                    return true;
                }
            }
            else if (comparison > 0) {  //newItem < currenItem => newItem is set on the left
                if (currentItem.previous() != null) { //not reached the head yet
//                    currentItem.previous().setNext(newItem);
//                    newItem.setPrevious(currentItem.previous());
//                    newItem.setNext(currentItem);
//                    currentItem.setPrevious(newItem);
                    //shortcut of these lines, based on the Node methods return statements
                    //*Note: each link is declared bi-laterally
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                }
                else { //we reached the head => newItem becomes the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            }
            else { //newItem is equal to currentItem => not adding a duplicate
                System.out.println(newItem.getValue() + " is already in the list and not added");
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
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                //found item
                if (currentItem == this.root) {
                    this.root = currentItem.next(); //setting the next item as root, before deleting item (root)
                }
                else {
                    currentItem.previous().setNext(currentItem.next()); //connecting forward: previous to next (effectively deleting current)
                    if (currentItem.next() != null) {  //connecting backwards: next to previous (if current isn't tail)
                        currentItem.next().setPrevious(currentItem.previous());

                    }
                }
                return true;
            } else if (comparison < 0) { //haven't reached item in the list
                currentItem = currentItem.next();
            }
            else { //comparison > 0, passed the tail => item is not in the list
                return false;
            }
        }
        //At this point the entire list was traversed, and item was not found
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty.");
        }
        else {
        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
        }
        //Using recursive method to traverse a linked list:
//        if (root != null) {
//            System.out.println(root.getValue());
//        } else {
//            traverse(root.next());
//        }

    }
}
