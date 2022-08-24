package BInaryTree;

public class Client {

    public static void main(String[] args) {


        MyTree.TreeNode root = new MyTree.TreeNode(20);
        MyTree tree = new MyTree();

        tree.insert(root,18);
        tree.insert(root,25);
        tree.insert(root,17);
        tree.insert(root,19);
        tree.insert(root,24);
        tree.insert(root,30);
        tree.insert(root,22);
        tree.insert(root,23);
        tree.insert(root,31);

//        System.out.println(tree.diameter(root).dia);
//        tree.getLeftView(root);
//        tree.verticalTraversal(root);
//
//        tree.bottomView(root);
//        System.out.println();
//        tree.topView(root);
//        tree.preOrder(root);
//        System.out.println();
//        tree.inorder(root);
//
//        tree.construct_Bst_From_In_And_Pre();
//        tree.construct_Bst_From_In_And_Post();
            tree.levelOrderTraversal(root);
            tree.rootToLeaf(root,22);
            tree.kthLevel(root,2);
    }

}
