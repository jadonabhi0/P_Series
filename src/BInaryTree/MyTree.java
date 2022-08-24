package BInaryTree;

import java.util.*;

public class MyTree {

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(){};
    }

    // main root deceleration
    private TreeNode root;



    // recursive way of inserting data
    public TreeNode insert(TreeNode root ,int val){

        if(root == null) root = new TreeNode(val);
        else if(root.val > val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;

    }

    // iterative way of inserting data;
    public TreeNode insert_itr(TreeNode root, int val){

        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        while(true){

            if(val < cur.val){
                if(cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }else {
                if(cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }


//    ================== -->  recursive ways of traversals <-- ====================

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }


    public void preOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void postOrder(TreeNode root){
        if (root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val+" ");

    }

    //    ================== -->  iterative ways of traversals <-- ====================

    public void inOrder_itr(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(cur != null || st.size() > 0){

            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }

            cur = st.pop();
            System.out.print(cur.val+" ");
            cur = cur.right;

        }

    }


    public void preOrder_itr(TreeNode root){
        if (root == null) return ;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){

            root = st.pop();
            System.out.print(root.val+" ");
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);

        }
    }



    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public void levelOrderTraversal(TreeNode root){
        if(root  == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){

            TreeNode cur = q.poll();

            if(cur != null){
                System.out.print(cur.val+" ");
                if(cur.left != null){
                    q.add(cur.left);
                }
                if (cur.right != null){
                    q.add(cur.right);
                }
            }else{
                System.out.println();
                if (q.isEmpty()) break;
                else q.add(null);
            }

        }


    }


    public void getLevelElements(TreeNode root, int level){

        if (root == null) return;
        if (level == 0) System.out.print(root.val +" ");
        if (level > 0){
            getLevelElements(root.left,level-1);
            getLevelElements(root.right,level-1);
        }
    }



    static class DiaPair{
        int ht;
        int dia;
    }

    public DiaPair diameter(TreeNode root){
        if(root == null) return new DiaPair();
        DiaPair left = diameter(root.left);
        DiaPair right = diameter(root.right);
        DiaPair ans  = new DiaPair();
        ans.ht = Math.max(left.ht , right.ht) +1;
        int dia = left.ht + right.ht + 1;
        ans.dia = Math.max(dia, Math.max(left.ht, right.ht));
        return ans;
    }

    private void leftView(TreeNode root, int level, ArrayList<Integer> list){

        if (root == null) return;

        if (list.size() == level){
            System.out.println(root.val+" ");
            list.add(root.val);
        }
        leftView(root.left, level+1, list);
        leftView(root.right, level+1, list);
    }

    public void getLeftView(TreeNode root){
        leftView(root, 0, new ArrayList<>());
    }



    static class vPair{
        TreeNode node;
        int dis;

        public vPair(TreeNode node , int dis){
            this.node = node ;
            this.dis = dis;
        }

    }


    public void verticalTraversal(TreeNode root){

        Queue<vPair> q = new LinkedList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        int mindis = 0;
        int maxdis = 0;

        q.offer(new vPair(root, 0));

        while(q.size() != 0){

//            int size = q.size();

//            while(size-- > 0){
                vPair node = q.poll();
                map.putIfAbsent(node.dis, new ArrayList<>());
                map.get(node.dis).add(node.node.val);
                mindis = Math.min(mindis, node.dis);
                maxdis = Math.max(maxdis, node.dis);

                if (node.node.left != null) q.offer(new vPair(node.node.left, node.dis-1));
                if (node.node.right != null) q.offer(new vPair(node.node.right, node.dis+1));
//            }


        }

        for (int i = mindis ; i <= maxdis ; i++){
            System.out.println(map.get(i));
        }

    }


    private void widthOfTree(TreeNode root, int hl, int[] array){
        if(root == null) return;

        array[0] = Math.min(array[0], hl);
        array[1] = Math.max(array[1], hl);
        widthOfTree(root.left,hl-1,array);
        widthOfTree(root.right,hl+1,array);
    }


    public int hasWidth(TreeNode root){
        int[] array = new int[]{0,0};
        widthOfTree(root,0,array );
        return array[1] - array[0] +1;
    }


    static class Pair_{
        TreeNode node;
        int dis ;

        public Pair_(TreeNode node, int dis){
            this.node  = node;
            this.dis = dis;
        }
    }

    public void bottomView(TreeNode root){

        if(root == null) return ;
        int mindis = 0;
        int maxdis = 0;
        Queue<Pair_> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.offer(new Pair_(root, 0));

        while(!q.isEmpty()){

            Pair_ rmpair = q.poll();
            map.put(rmpair.dis,rmpair.node.val);
            mindis = Math.min(mindis, rmpair.dis);
            maxdis = Math.max(maxdis, rmpair.dis);

            if(rmpair.node.left != null) q.offer(new Pair_(rmpair.node.left, rmpair.dis - 1));
            if(rmpair.node.right != null) q.offer(new Pair_(rmpair.node.right, rmpair.dis + 1));

        }

        for (int i = mindis; i <= maxdis ; i++){
            System.out.print(map.get(i)+" ");
        }

    }


    public void topView(TreeNode root){

        if(root == null) return ;
        int mindis = 0;
        int maxdis = 0;
        Queue<Pair_> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.offer(new Pair_(root, 0));

        while(!q.isEmpty()){

            Pair_ rmpair = q.poll();
            map.putIfAbsent(rmpair.dis,rmpair.node.val);
            mindis = Math.min(mindis, rmpair.dis);
            maxdis = Math.max(maxdis, rmpair.dis);

            if(rmpair.node.left != null) q.offer(new Pair_(rmpair.node.left, rmpair.dis - 1));
            if(rmpair.node.right != null) q.offer(new Pair_(rmpair.node.right, rmpair.dis + 1));

        }

        for (int i = mindis; i <= maxdis ; i++){
            System.out.print(map.get(i)+" ");
        }

    }

//    ========================== --> TREE CONSTRUCTION  <-- ============================================================

    private TreeNode Bst_From_In_And_Pre(int[] preorder, int prestart, int preens, int[] inorder, int instart, int inend){
        if (instart > inend) return null;
        int idx = instart;
        int ele = preorder[prestart];
        while (ele != inorder[idx]) idx++;
        int count = idx - instart;

        TreeNode node = new TreeNode(ele);
        node.left = Bst_From_In_And_Pre(preorder, prestart+1, prestart+count, inorder, instart, idx-1);
        node.right = Bst_From_In_And_Pre(preorder,prestart+count+1, preens, inorder, idx+1, inend);
        return node;
    }

    public void construct_Bst_From_In_And_Pre(){
        int[] pre = {20, 18, 17, 19, 25, 24, 22, 23, 30, 31};
        int[] in = {17, 18, 19, 20, 22, 23, 24, 25, 30, 31};
        int n = pre.length;
        TreeNode ans = Bst_From_In_And_Pre(pre,0,n-1, in, 0, n-1);
        inorder(ans);
        System.out.println();
        System.out.println("done successfully ");
    }


    private TreeNode Bst_From_In_And_Post(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend){

        if (instart > inend) return null;

        int idx = instart;
        TreeNode node  = new TreeNode(postorder[postend]);
        while(postorder[postend] != inorder[idx] && idx < inend) ++idx;
        int count = idx - instart;

//        System.out.println("jjhjkh");
        node.left = Bst_From_In_And_Post(postorder, poststart,poststart+count-1, inorder, instart, idx-1);
        node.right = Bst_From_In_And_Post(postorder, poststart+count,postend-1, inorder, idx+1, inend);
        return node;
    }

    public void construct_Bst_From_In_And_Post(){
        int[] post = {18, 17, 19, 25, 24, 22, 23, 30, 31, 20};
        int[] in =   {17, 18, 19, 20, 22, 23, 24, 25, 30, 31};
        int n = post.length;
        TreeNode ans = Bst_From_In_And_Post(post,0, n-1, in, 0, n-1);
        inorder(ans);
        System.out.println();
        System.out.println("not working fine ");
    }


    private boolean rootToLeaf_(TreeNode root, int target,List<Integer> list){
        if (root == null) return false;
        if (root.val == target) {
            list.add(root.val);
            return true;
        }
        boolean res = rootToLeaf_(root.left,target,list) || rootToLeaf_(root.right, target, list);
        if(res)list.add(root.val);
        return res;
    }

    public void rootToLeaf(TreeNode root, int tar){
        List<Integer> list = new ArrayList<>();
        rootToLeaf_(root,tar,list);
        System.out.println(list);
    }

    private void kthLevel_(TreeNode root, int level, List<Integer> list){
        if (root == null || level < 0) return;
        if (level == 0) list.add(root.val);
        kthLevel_(root.left, level-1, list);
        kthLevel_(root.right, level-1, list);
    }

    public void kthLevel(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        kthLevel_(root,k,list);
        System.out.println(list);
    }


} // end of class
