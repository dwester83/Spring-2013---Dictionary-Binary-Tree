import java.util.LinkedList;

public class BinaryTree
{

	private LinkedList<WordADT> list;

	//Definition of the node
	protected class BinaryTreeNode
	{
		WordADT info;
		BinaryTreeNode llink;
		BinaryTreeNode rlink;
	} 

	protected BinaryTreeNode root;

	//default constructor 
	//Postcondition: root = null;
	public BinaryTree()  
	{
		root = null;
	}

	//copy constructor
	public BinaryTree(BinaryTree otherTree) 
	{
		if(otherTree.root == null) //otherTree is empty
			root = null;
		else
			root = copy(otherTree.root);
	}

	//Method to determine whether the binary tree is empty.
	//Postcondition: Returns true if the binary tree is empty;
	//               otherwise, returns false.    
	public boolean isEmpty()
	{
		return (root == null);
	}

	//Method to do an inorder traversal of the binary tree.
	//Postcondition: The nodes of the binary tree are output
	//               in the inorder sequence.
	public LinkedList<WordADT> inorderTraversal()
	{
		list = new LinkedList<WordADT>();
		inorder(root);
		return list;
	}

	//Method to do a preorder traversal of the binary tree.
	//Postcondition: The nodes of the binary tree are output
	//               in the preorder sequence.
	public LinkedList<WordADT> preorderTraversal()
	{
		list = new LinkedList<WordADT>();
		preorder(root);
		return list;
	}

	//Method to do a postorder traversal of the binary tree.
	//Postcondition: The nodes of the binary tree are output
	//               in the postorder sequence.       
	public LinkedList<WordADT> postorderTraversal()
	{
		list = new LinkedList<WordADT>();
		postorder(root);
		return list;
	}

	//Method to determine the height of the binary tree.
	//Postcondition: The height of the binary tree is returned.    
	public int treeHeight()
	{
		return height(root);
	}

	//Method to determine the number of nodes in the 
	//binary tree.
	//Postcondition: The number of nodes in the binary tree
	//               is returned.       
	public int treeNodeCount()
	{
		return nodeCount(root);
	}

	//Method to determine the number of leaves in the 
	//binary tree.
	//Postcondition: The number of leaves in the binary tree
	//               is returned.       
	public int treeLeavesCount()
	{
		return leavesCount(root);
	}

	//Method to destroy the binary tree.
	//Postcondition: root = null     
	public void destroyTree()
	{
		root = null;
	}

	//Method to make a copy of the binary tree 
	//specified by otherTree points. 
	//Postcondition: A copy of otherTree is assigned to
	//               this binary tree.   
	public void copyTree(BinaryTree otherTree)
	{ 

		if(this != otherTree) //avoid self-copy
		{
			root = null;   

			if(otherTree.root != null) //otherTree is nonempty
				root = copy(otherTree.root);
		}

	}

	//Method to make a copy of the binary tree to 
	//which otherTreeRoot points. 
	//Postcondition: A copy of the binary tree to which
	//               otherTreeRoot is created and the reference of
	//               the root node of the copied binary tree
	//               is returned.
	private BinaryTreeNode copy(BinaryTreeNode otherTreeRoot)
	{
		BinaryTreeNode temp;

		if(otherTreeRoot == null)
			temp = null;
		else
		{
			temp = new BinaryTreeNode();
			temp.info = otherTreeRoot.info.getCopy();
			temp.llink = copy(otherTreeRoot.llink);
			temp.rlink = copy(otherTreeRoot.rlink);
		}

		return temp;
	}//end copy

	//Method to do an inorder traversal of the binary
	//tree to which p points.  
	//Postcondition: The nodes of the binary tree to which p
	//               points are output in the inorder sequence.    
	private void inorder(BinaryTreeNode p)
	{
		if(p != null)
		{
			inorder(p.llink);
			WordADT word = p.info.getCopy();
			list.add(word);
			inorder(p.rlink);
		}
	}

	//Method to do a preorder traversal of the binary
	//tree to which p points.  
	//Postcondition: The nodes of the binary tree to which p
	//               points are output in the preorder sequence.       
	private void preorder(BinaryTreeNode p)
	{
		if(p != null)
		{
			WordADT word = p.info.getCopy();
			list.add(word);
			preorder(p.llink);
			preorder(p.rlink);
		}
	}

	//Method to do a postorder traversal of the binary
	//tree to which p points.  
	//Postcondition: The nodes of the binary tree to which p
	//               points are output in the postorder sequence.      
	private void postorder(BinaryTreeNode p)
	{
		if(p != null)
		{
			postorder(p.llink);
			postorder(p.rlink);
			WordADT word = p.info.getCopy();
			list.add(word);
		}
	}

	//Method to determine the height of the binary tree
	//to which p points. 
	//Postcondition: The height of the binary tree to which p
	//               points is returned.   
	private int height(BinaryTreeNode p)
	{
		if(p == null)
			return 0;
		else
			return 1 + max(height(p.llink), height(p.rlink));
	}

	//Method to determine the larger of x and y.
	//Postcondition: The larger of x and y is returned.    
	private int max(int x, int y)
	{
		if(x >= y)
			return x;
		else
			return y;
	}

	//Method to determine the number of nodes in the binary 
	//tree to which p points. 
	//Postcondition: The number of nodes in the binary tree
	//               to which p points is returned.    
	private int nodeCount(BinaryTreeNode p)
	{
		System.out.println("See Programming Exercise 1.");
		return 0;
	}
	//Method to determine the number of leaves in the binary 
	//tree to which p points.
	//Postcondition: The number of leaves in the binary tree
	//               to which p points is returned.    
	private int leavesCount(BinaryTreeNode p)
	{
		System.out.println("See Programming Exercise 2.");
		return 0;
	}
}