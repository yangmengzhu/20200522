import java.util.*;

/*
 * @program: 2020518
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -18 13 :56
 */
class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val=val;
    }
}
public class BinaryTree {
   public Node build(){
           Node A=new Node('A');
           Node B=new Node('B');
           Node C=new Node('C');
           Node D=new Node('D');
           Node E=new Node('E');
           Node F=new Node('F');
           Node G=new Node('G');
           Node H=new Node('H');
           A.left=B;
           A.right=C;
           B.left=D;
           B.right=E;
           E.right=H;
           C.left=F;
           C.right=G;
           return A;
       }
       //前序遍历
       public void preorderTree(Node root){
       if(root==null){
           return;
       }
           System.out.print(root.val+" ");
           preorderTree(root.left);
           preorderTree(root.right);
   }
   //中序遍历左=》根=》右
    public void inorderTree(Node root){
       if(root==null) {
           return;
       }
        inorderTree(root.left);
        System.out.print(root.val+ " ");
        inorderTree(root.right);
    }
    //后序遍历
    public void postorderTree(Node root){
       if(root==null){
           return;
       }
        postorderTree(root.left);
        postorderTree(root.right);
        System.out.print(root.val+ " ");
    }
    //求节点个数
    public int getSize(Node root){
       if(root==null){
           return 0;
       }
       //左树和右树节点个数+1
        return getSize(root.left)+getSize(root.right)+1;
    }
    //叶子节点个数
    public int getLeafSize(Node root){
       //其中一个为空，返回0，两个为空返回1
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
       //左右叶子个数之和
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    //最大高度
    public int getHeight(Node root){
       //左右子树最大高度+1（根节点）
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    //第K层节点个数
    public int getLeavesSize(Node root,int k){
       if(root==null){
           return 0;
       }
       if(k==1){
           return 1;
       }
       //左右各递归k-1次
       return getLeavesSize(root.left,k-1)+getLeavesSize(root.right,k-1);
    }
    //两棵树是否相同
    public boolean isSameTree(Node p,Node q){
       if((p!=null&&q==null)||p==null&&q!=null){
           return false;
       }
       if(p==null&&q==null){
           return true;
       }
       if(p.val==q.val){
           return true;
       }
       return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //另一棵树的子树
    public boolean isSubTree(Node s,Node t){
       if(t==null||s==null){
           return false;
       }
       if(t==null&&s==null){
           return true;
       }
       if(isSameTree(t,s)){
           return true;
       }
       if(isSubTree(s.left,t)){
           return true;
       }
       if(isSubTree(s.right,t)){
           return true;
       }
       return false;
    }
    //是否为平衡树
    public boolean isBalanced(Node root){
       //根节点为空平衡
        if(root==null){
            return true;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
       return  Math.abs(left-right)<=1 &&
               isBalanced(root.left)&&isBalanced(root.right);
    }
    //是否为对称树
    public boolean isSymmetric(Node root){
       if(root==null){
           return true;
       }
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(Node leftTree,Node rightTree){
       if((leftTree!=null&&rightTree==null)
               ||(leftTree==null&&rightTree!=null)){
           return false;
       }
       if(leftTree==null&&rightTree==null){
           return true;
       }
       //根节点值必须相同三者必须同时满足
        return (leftTree.val==rightTree.val)
                &&isSymmetricChild(leftTree.left,rightTree.right)
                &&isSymmetricChild(leftTree.right,rightTree.left);
    }

//层序遍历二叉树
    /*public List<List<Character>> func(Node root){
       List<List<Character>> ret=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return ret;
        }
        queue.offer(root);
        Node cur=queue.poll();
        while(!queue.isEmpty()){
            //1.求当前队列的size
            int size=queue.size();
            List<Character> list=new ArrayList<>();
           while(size>0){
               cur=queue.poll();
               if(cur.left !=null){
                   queue.offer(cur.left);
               }
              if(cur.right !=null){
                  queue.offer(cur.right);
              }
               list.add(cur.val);
              size--;
           }
            ret.add(list);
        }
        return ret;
    }
    //是否是完全二叉树
    public boolean isCompleteTree(Node root){
       Queue<Node> queue=new LinkedList<>();
       if(root==null){
           return true;
       }
       queue.offer(root);
       while(!queue.isEmpty()){
           Node cur2=queue.poll();
           if(cur2!=null){
               queue.offer(cur2.left);
               queue.offer(cur2.right);
           }else{
               break;
           }
       }
       //cur2为空，判断队列是否全部都为空
        while(!queue.isEmpty()){
            Node cur3=queue.peek();
            if(cur3!=null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }
    //非递归中序遍历
    public void inorderNor(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=stack.push(root);
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                cur=cur.left;
                stack.push(cur);
            }
            //cur为空
            System.out.println(cur.val);
            Node top=stack.pop();
            cur=top.right;
        }
    }
    public void preorderNor(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=stack.push(root);
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                cur=cur.left;
                stack.push(cur);
            }
            //cur为空
            System.out.println(cur.val);
            Node top=stack.pop();
            cur=top.right;
        }
    }*/
    //层序遍历二叉树
    public void Tree(Node root){
        Queue<Node> queue=new LinkedList<>();
         //判断根节点不为空
        if(root==null){
            return;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(cur!=null){
                System.out.print(cur.val+" ");
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println();
    }
    public List<List<Character>> funcTree(Node root){
        List<List<Character>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Character> list=new ArrayList<>();
            while(size>0){
                Node cur=queue.poll();
                if(cur!=null){
                    list.add(cur.val);
                    if(cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                    }
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }
    //判断一棵树是否是完全二叉树
    public boolean isCompleted(Node root){
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return true;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            Node cur2=queue.peek();
            if(cur2!=null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }
    //非递归前序遍历二叉树
    public void preorderNor(Node root){
        Stack<Node> stack=new Stack<>();
        if(root==null){
            return;
        }
        Node cur=root;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
        System.out.println();
    }
//非递归中序遍历二叉树
    public void inorderNor(Node root){
        Stack<Node> stack=new Stack<>();
        if(root==null){
            return;
        }
        Node cur=root;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            System.out.print(top.val+" ");
            cur=top.right;
        }
    }
    //中序  后序  构建二叉树
    /*int postIndex=0;
    public Node buildTreeChild
            (char[] inorder,char[] postorder,int postbegin,int postend ){
        if(postbegin>postend){
            return null;
        }
        Node root=new Node(postorder[postIndex]);
        int rootIndex=findIndex(inorder,postbegin,postend,postorder[postIndex]);
        postIndex--;
        if(rootIndex==-1){
            return null;
        }
        root.right=buildTreeChild(inorder,postorder,postbegin,postIndex-1);
        root.left=buildTreeChild(inorder,postorder,postIndex-1,postend);
        return root;
    }
    public int findIndex(char[] inorder,int postbegin,int postend,int val){
        for (int i = postbegin; i >=postend; i--) {
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    public Node buildTree(char[] inorder,char[] postorder){
        if(inorder==null&&postorder==null){
            return null;
        }
        if(inorder==null||postorder==null){
            return null;
        }
        postIndex=postorder.length-1;
        return buildTreeChild(inorder,postorder,postIndex,0);
    }*/
    
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        Node root=binaryTree.build();
        binaryTree.preorderNor(root);
        binaryTree.inorderNor(root);
    }
}
