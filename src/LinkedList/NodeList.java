package LinkedList;

public interface NodeList {

    ListItem getRoot();  //head (starting node)

    boolean addItem(ListItem item);

    boolean removeItem(ListItem item);

    void traverse(ListItem root);

}
