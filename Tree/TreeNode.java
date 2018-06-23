
/**
 * @author wyong
 *二叉树的节点的数据结构
 */
package Tree;
public class TreeNode{
	public  int key = 0;              //记录二叉树的层数
	public String data = null;  		// 节点的数据域
	public TreeNode leftchild = null;
	public TreeNode rightchild = null;
	public boolean isVisted = false;
	
	public TreeNode(int key,String data){
		this.key = key;
		this.data = data;
		this.leftchild = null;
		this.rightchild = null;
	}
}