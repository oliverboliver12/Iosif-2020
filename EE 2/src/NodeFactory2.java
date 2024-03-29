/*Program Information
Author:
Oliver Szavuj
22.04.2019
*/


public class NodeFactory2<Item>{
	public BinaryNode root;
	public int spaceCount = 3; 
	boolean changedRoot = false;
	//public ArrayList<BinaryNode> BinaryNodeArrayList = new ArrayList<BinaryNode>();
	int nodeCount = 0;
	
	
	public class BinaryNode{
		public Item item;
		BinaryNode left = null;
		BinaryNode right = null;
		BinaryNode parent = null;
		public int height;
		public BinaryNode(Item newItem, BinaryNode parent){
			this.item = newItem;
			this.left =null;
			this.right = null;
			this.parent = parent;
		}
		public BinaryNode(){
			this.item =null;
			this.left =null;
			this.right = null;
			this.parent = null;
		}
	}


	public void insert(BinaryNode currentNode, Item newItem) {
		if(root == null) {
			insertRoot(newItem);
			return;
		}
		if(Integer.valueOf(currentNode.item.toString()) > Integer.valueOf(newItem.toString())) {
			if (currentNode.left != null) {
				insert(currentNode.left, newItem);
			} else {
				currentNode.left = new BinaryNode(newItem, currentNode);
				return;
			}
		}
		else if(Integer.valueOf(currentNode.item.toString()) < Integer.valueOf(newItem.toString())) {
			if (currentNode.right != null) {
				insert(currentNode.right, newItem);
			} else {
				currentNode.right = new BinaryNode(newItem, currentNode);

				return;
			}
		}
	}
	
	public void insertRoot(Item newItem) {
		root = new BinaryNode();
		root.item = newItem;
		root.height = 1;
	}


//	public void printInorder(BinaryNode current){ 
//		BinaryNode pRoot = new BinaryNode();
//        if (current == null) 
//            return; 
//        printInorder(current.left);
//        
//        //BinaryNodeArrayList.add(current);
//        pRoot.right = current;
//  
//        printInorder(current.right);
//        print2D(pRoot);
//    }
	
	public void print2DUtil(BinaryNode root, int space)  {   
	    if (root == null)  
	        return;  
	    space += spaceCount;
	    print2DUtil(root.right, space);  
 
	    System.out.print("\n");  
	    for (int i = spaceCount; i < space; i++)  
	        System.out.print(" ");  
	    System.out.print(root.item );  
	    
	    print2DUtil(root.left, space); 
	    System.out.print("\n"); 
	}  
	  
	public void print2D(BinaryNode root){  
	    print2DUtil(root, 0);  
	} 

	
//	BinaryNode sortedListToBalancedTree(int start, int end) { 
//		if (start > end) { 
//			return null; 
//		} 
//		int mid = (start + end) / 2; 
//        BinaryNode node = new BinaryNode(BinaryNodeArrayList.get(mid).item); 
//		node.left = sortedListToBalancedTree(start, mid - 1); 
//		node.right = sortedListToBalancedTree(mid + 1, end);   
//		return node; 
//    } 
  
      
	//Flight stuff
	
//	public  void treeToVine() {
//		BinaryNode tail = root;
//		BinaryNode rest = tail.right;
//		while(rest!= null) {
//			System.out.println(rest.item);
//			if(rest.left == null) {
//				tail = rest;
//				rest = rest.right;
//			}else {
//				BinaryNode temp = rest.left;
//				rest.left = temp.right;
//				temp.right = rest;
//				rest = temp;
//				tail.right = temp;	
//			}
//		}
	
//	public int max(int a, int b) { 
//        return (a > b) ? a : b; 
//    } 
//	public boolean checkConditions(BinaryNode pivot) {
//		if(pivot.parent != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	
	public void rightRotate(BinaryNode pivot) {
		BinaryNode parent = pivot.parent;
		BinaryNode pivotRightChild = pivot.right;
		BinaryNode grandParent = null;
		if(parent.parent != null) {
			grandParent = parent.parent;
		}

		pivot.parent = parent.parent;
		parent.parent  = pivot;
		parent.left = null;
		parent.left = pivotRightChild;//will be null if pivotRightChild is null
		if(pivotRightChild != null)//only will be entered in there is a pivotRightChild to be assigned
			pivotRightChild.parent = parent;
		pivot.right = parent;
		
		if(grandParent != null) {
			if(grandParent.left != null) {
				if (grandParent.left.item.toString().equals(parent.item.toString())) 
					grandParent.left = pivot;
			}
			else{
				grandParent.right = pivot;
			}
		}
		else if(parent.item.toString().equals(root.item.toString())) {
			root.parent = pivot;
			root = pivot;
		}
	}

	
	
//	public void leftRotate(BinaryNode y) {
//		BinaryNode doubleParent = null;
//		BinaryNode parent = y.parent;
//		BinaryNode yLeftChild = y.left;
//		
////		try {
//		if(y.parent != null) {
//			y.parent = parent.parent;
//			if(parent.parent != null) {
//				doubleParent = parent.parent;
//				//System.out.println("PARENT ASSIGNED");
//				//System.out.println(doubleParent);
//			}
//			
//		
//		parent.parent  = y;
//		parent.right = null;
//		parent.right = yLeftChild;
//		//yRightChild.parent = null;
//		if(yLeftChild != null)
//			yLeftChild.parent = parent;
//		y.left = parent;
////		} catch(NullPointerException e) {
////			System.out.println("EXCEPTION");
////		}
//		//SWITCH PARENTS
//		if (parent.item.toString().equals(root.item.toString())) {
//			//System.out.println("changedRoot");
//			changedRoot = true;
//			root.parent = y;
//			root = y;
//		}
//		if(doubleParent != null) {
//			//System.out.println("null1 entered: " + doubleParent.item);
//			if(doubleParent.left != null) {
//				//System.out.println("null2 entered");
//				if (doubleParent.left.item.toString().compareTo(parent.item.toString()) == 0) {
//					//System.out.println("DING2");
//					doubleParent.left = y;
//				}
//			}
//			if(doubleParent.right != null) {
//				//System.out.println("null3 entered");
//				 if (doubleParent.right.item.toString().compareTo(parent.item.toString()) == 0){
//					 //System.out.println("DING3");
//					 doubleParent.right = y;
//				 }
//			}
//			
//		}
//		} else if (y.parent == null) {
//			BinaryNode yRightChild = y.right;
//			
//			y.parent = yRightChild;
//			yRightChild.left = y;
//			y.right = null;
//			root = yRightChild;
//			root.parent = null;
//		}		
//	}
	
//	public BinaryNode leftRotateAdapted(BinaryNode n) {
//		if(n.right != null) {
//			BinaryNode rightChild = n.right;
//			n.right = rightChild.right;
//			rightChild.right = rightChild.left;
//			rightChild.left = n.left;
//			n.left = rightChild;
//			
//			String temp = n.item.toString();
//			n.item = rightChild.item;
//			rightChild.item = (Item) temp;
//			
//		}
//		return n;
//		
//	}
	
//	void rightRotateSimplified(BinaryNode pivot) {
//	    try {
//		    	BinaryNode root = pivot.parent;
//		    	BinaryNode pivotRightChild = pivot.right;
//		    	pivot.parent = root.parent;
//		    	pivotRightChild.parent = root;
//		    	root.left = pivotRightChild;
//		    	pivot.right = root;
//		    	root.parent = pivot;
//	    	}
//	    catch(NullPointerException e) {
//	    
//	    }
//	}
	    
	public void leftRotate(BinaryNode grandParent, BinaryNode parent, BinaryNode rightChild) {
		if (null != grandParent) {
			grandParent.right = rightChild;
		} else {
			root = rightChild;
		}
		parent.right = rightChild.left;
		rightChild.left = parent;
	}
  
    
	void scripted(){

		Item b = (Item) "B";
		Item a = (Item) "A";
		Item d = (Item) "d";
		Item c = (Item) "c";
		Item y = (Item) "y";
		//Item o = (Item) "o";
		//Item p = (Item) "p";
	
		insertRoot(b);
		root.left = new BinaryNode(a, root);
		root.left.left = new BinaryNode(d, root.left);
		root.left.right = new BinaryNode(c, root.left);
		root.right = new BinaryNode(y, root.right);
		//root.left.right.left = new BinaryNode(o, root.left.right, 4);
		//root.left.left.right = new BinaryNode(p, root.left.left, 4);
		print2D(root);
		//rightRotateSimplified(root.left);
		print2D(root.parent);
		//leftRotate(root.right);
		print2D(root);

	}
	public void search(Item searchItem) {
		BinaryNode currentNode = root;
		while (currentNode.item.toString().compareTo(searchItem.toString()) !=0) {
			if(currentNode.item.toString().compareTo(searchItem.toString()) == 0)
				return;
			//System.out.println(currentNode.item);
			if(Integer.valueOf(currentNode.item.toString()) > Integer.valueOf(searchItem.toString())) {
				currentNode = currentNode.left;
			}
			else if(Integer.valueOf(currentNode.item.toString()) < Integer.valueOf(searchItem.toString())) {
				currentNode = currentNode.right;
			}

		}
	}
	void treeToVine (BinaryNode curent) {
		BinaryNode currentNode = curent;
		while (currentNode != null) {
			
			while(currentNode.left != null) {
				rightRotate(currentNode.left);
				currentNode = currentNode.parent;
//				System.out.println("currently" + currentNode.item);
//				System.out.println("_______________________");
//				print2D(root);
//				System.out.println("_______________________");
			}
			
	
			currentNode = currentNode.right;
			nodeCount++;
		}	
		System.out.println(nodeCount);
	}
	
//	void t2v(BinaryNode root) {
//		BinaryNode tail = root;
//		BinaryNode rest = tail.right;
//		while (rest != null) {
//			if (rest.left == null) {
//				tail = rest;
//				rest = rest.right;
//			} else {
//				BinaryNode temp = rest.left;
//				rest.left = temp.right;
//				temp.right = rest;
//				rest = temp;
//				tail.right = temp;
//			}
//		}
//	}
	
//	void rebuildTree() {
//		double expected = 2;
//		//double expected = (nodeCount - Math.pow(2,((Math.log(nodeCount) / Math.log(2)))));
//		System.out.println("   " + expected);
//		BinaryNode currentNode1 = root;
//		for(int i = 0; i< expected; i++) {
//			if(i==0) {
//				leftRotate(currentNode1);
//				currentNode1 = root;
//				print2D(root);
//				//System.out.println(root.right.item);
//			} else {
//				leftRotateAdapted(currentNode1.right);
//				currentNode1 = currentNode1.right;
//			}
//		}
//		int count = nodeCount; 
//		while (count > 1) {
//			count /= 2;
//			leftRotateAdapted(root);
//			BinaryNode currentNode2 = root;
//			for(int i = 0; i < count - 1; i++) {
//				leftRotateAdapted(currentNode2.right);
//				currentNode2 = currentNode2.right;
//			}
//		}
//		
//		
//		
////		for(int i = 0; i <expected; i++) {
////			newRoot = leftRoateCopy(newRoot);
////			root = newRoot.right;
////			for(int j = 0; j < nodeCount / 2 - 1; j++) {
////				root = leftRoateCopy(root);
////				root = root.right;
////			}
////			nodeCount >>=1;
////		}
////		print2D(root);
//
//	}
	
	public void vineToBST(){
		int log2Val = greatestPower2LessN(nodeCount + 1) - 1;
		makeRotations(nodeCount - log2Val);
		while (log2Val > 1)
			makeRotations(log2Val /= 2);
	}
	
	public int greatestPower2LessN(int n){
		int p = (int)(Math.log(n)/Math.log(2));
		return (int)Math.pow(2, p);
	} 
	
	public void makeRotations(int bound){
		BinaryNode parent = root;
		BinaryNode child = root.right;
		BinaryNode grandParent = null;
		for (; bound > 0; bound--) { 
			if (null != child) {
				leftRotate(grandParent, parent, child);
				grandParent = child;
				parent = grandParent.right;
				child = parent.right;
			} else {
				break;
			}
		}
	}
}