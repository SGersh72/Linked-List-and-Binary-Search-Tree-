package BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);


        intTree.traverseInOrder();
        System.out.println();
//
//        System.out.println(intTree.get(27));
//        System.out.println(intTree.get(32));
//        System.out.println(intTree.get(888));

//        System.out.println(intTree.getMin());
//        System.out.println(intTree.getMax());

        //intTree.delete(15); // 17 replaces that
        //intTree.delete(17); //17 is a leaf => no replacement
        //intTree.delete(25);  //we chose a right subtree replacement => 26, but it could have been a left replacement of 22
        intTree.delete(888); // test a non-existing node => no deletions, nothing returned
        intTree.traverseInOrder();
        System.out.println();
//        intTree.delete(17);
//        intTree.delete(25);









    }
}
