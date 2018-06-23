package Tree;

import java.util.Stack;

/**
 * 二叉树的链式存储
 * @author wyong
 *
 */
public class BinaryTree {

	private TreeNode root = null;
	
	public BinaryTree(){
		root = new TreeNode(1,"rootNode(A)");
	}
	/**
	 * 创建二叉树
	 * 			A
	 * 		B		C
	 *  D	    E		F
	 * @param args
	 */
	public void createBinTree(TreeNode root){
		TreeNode newNodeB = new TreeNode(2, "B");
		TreeNode newNodeC = new TreeNode(3, "C");
		TreeNode newNodeD = new TreeNode(4, "D");
		TreeNode newNodeE = new TreeNode(5, "E");
		TreeNode newNodeF = new TreeNode(5, "F");
		root.leftchild = newNodeB;
		root.rightchild = newNodeC;
		root.leftchild.leftchild = newNodeD;
		root.leftchild.rightchild = newNodeE;
		root.rightchild.rightchild = newNodeF;
	}
	
	public boolean isEmpty(){ 		//判断树是否为空
		return root == null;
	}
	   // 树的高度
    public int height() {
        return height(root);
    }

    // 节点个数
    public int size() {
        return size(root);
    }
	
	public int height(TreeNode subTree){ //求树的高度
		if(subTree == null){
			return 0; //树的高度为0
		}else{
			int i = height(subTree.leftchild);
			int j = height(subTree.rightchild);
			return (i<j)?(j+1):(i+1);
		}
	}
	
	public int size(TreeNode subTree){		//求树的节点的个数
		if(subTree == null){
			return 0;
		}else{
			return 1 + size(subTree.leftchild) + size(subTree.rightchild); 
		}
	}
	
	public TreeNode parent(TreeNode subTree,TreeNode element){
		if(subTree == null){
			return null;
		}
		if(subTree.leftchild == element||subTree.rightchild == element){
			return subTree;		//返回父节点
		}
		TreeNode p;
		if((p = parent(subTree.leftchild,element))!=null){	//递归在左子树中查找
			return p;
		}else{
			return parent((subTree.rightchild),element);	//递归在右子树中查找
		}
	}
	
	public void destroy(TreeNode subTree){
 		if(subTree!=null){
			destroy(subTree.leftchild);
			destroy(subTree.rightchild);
			subTree = null;
		}
	}

    // 前序遍历      根左右
    public void preOrder(TreeNode subTree) {
        if (subTree != null) {
            visted(subTree);
            preOrder(subTree.leftchild);
            preOrder(subTree.rightchild);
        }
    }

    // 中序遍历    左根右
    public void inOrder(TreeNode subTree) {
        if (subTree != null) {
            inOrder(subTree.leftchild);
            visted(subTree);
            inOrder(subTree.rightchild);
        }
    }

    // 后续遍历	左右根
    public void postOrder(TreeNode subTree) {
        if (subTree != null) {
            postOrder(subTree.leftchild);
            postOrder(subTree.rightchild);
            visted(subTree);
        }
    }

    // 前序遍历的非递归实现  根左右
    public void nonRecPreOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = p;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                visted(node);
                stack.push(node);    
                node = node.leftchild;
            }
            while (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightchild;
            }
        }
    }

    // 中序遍历的非递归实现  左根右
    public void nonRecInOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<Tree.TreeNode>();
        TreeNode node = p;
        while (node != null || stack.size() > 0) {
            // 存在左子树
            while (node != null) {
                stack.push(node);
                node = node.leftchild;
            }
            // 栈非空
            if (stack.size() > 0) {
                node = stack.pop();
                visted(node);
                node = node.rightchild;
            }
        }
    }

    // 后序遍历的非递归实现 左右根
    public void noRecPostOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<Tree.TreeNode>();
        TreeNode node = p;
        while (p != null) {
            // 左子树入栈
            for (; p.leftchild != null; p = p.leftchild) {
                stack.push(p);
            }
            // 当前结点无右子树或右子树已经输出
            while (p != null && (p.rightchild == null || p.rightchild == node)) {
                visted(p);
                // 纪录上一个已输出结点
                node = p;
                if (stack.empty())
                    return;
                p = stack.pop();
            }
            // 处理右子树
            stack.push(p);
            p = p.rightchild;
        }
    }

    public void visted(TreeNode subTree) {
        subTree.isVisted = true;
        System.out.println("key:" + subTree.key + "--name:" + subTree.data);
    }
	public static void main(String[] args) {
	      BinaryTree bt = new BinaryTree();
	        bt.createBinTree(bt.root);
	        System.out.println("树中节点的个数 " + bt.size());
	        System.out.println("树的高度 " + bt.height());

	        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
	        bt.preOrder(bt.root);

	        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
	        bt.inOrder(bt.root);

	        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
	        bt.postOrder(bt.root);

	        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
	        bt.nonRecPreOrder(bt.root);

	        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
	        bt.nonRecInOrder(bt.root);

	        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");
	        bt.noRecPostOrder(bt.root);

	}

}
