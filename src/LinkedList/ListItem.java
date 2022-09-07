package LinkedList;

public abstract class ListItem {
    //creating instances of the very same class in that class
    //protected enables access from the concrete (sub) class
    protected ListItem rightLink = null;   //== nextItem
    protected ListItem leftLink = null;    //== previousItem

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    //Methods for traversing the list
    abstract ListItem next();  //traverse to next()
    abstract ListItem previous();  //traverse to previous()


    abstract ListItem setNext(ListItem item);
    abstract ListItem setPrevious(ListItem item);

    //An in depth comparison to the object for a sorted list
    abstract int compareTo(ListItem item);


    //Getter and Setter for the value
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
