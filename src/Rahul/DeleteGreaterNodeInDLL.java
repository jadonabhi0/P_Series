package Rahul;/*
    @author jadon
*/


    public class DeleteGreaterNodeInDLL {

        Node head;
        class Node{
            Node next,pre;
            int data;
            Node(int d){
                data=d;
            }
        }

//        public Node DeleteNode(Node head2,Node del){
//            if(head2==null || del==null){
//                return null;
//            }
//            if(head2==del){
//                head2=del.next;
//            }
//            if(del.next!=null){
//                del.next.pre=del.pre;
//            }
//            if(del.pre!=null){
//                del.pre.next=del.next;
//            }
//            return head2;
//        }

        public Node DeleteGreaterNode(Node head1, int x){
            Node temp=head1;
            Node curr;
            while(temp!=null){

                if(temp.data>x){
                    if(temp.pre == null){
                        temp = temp.next;
                    }
                    else {
                        temp.pre.next = temp.next;
                    }
                }
                temp = temp.next;

            }
            return head1;
        }
        public void push(int data){
            Node new_node=new Node(data);
            new_node.next=head;
            new_node.pre=null;
            if(head!=null)
                head.pre=new_node;
            head=new_node;
        }
        public void Print(Node node){
            Node last=null;
            System.out.println("Traversal in forward direction:");
            while(node!=null){
                System.out.print(node.data+" ");
                last=node;
                node=node.next;
            }
            System.out.println();
            System.out.println("Traversal in backward direction:");
            while(last!=null){
                System.out.print(last.data+" ");
                last=last.pre;
            }
            System.out.println();
        }


        public static void main(String[] args) {
            DeleteGreaterNodeInDLL dg=new DeleteGreaterNodeInDLL();
            dg.push(1);
            dg.push(12);
            dg.push(6);
            dg.push(3);
            dg.push(4);
            dg.push(7);
            dg.Print(dg.head);
            dg.Print(dg.DeleteGreaterNode(dg.head,3));
//        dg.Print(dg.head);
            
        }
    }



