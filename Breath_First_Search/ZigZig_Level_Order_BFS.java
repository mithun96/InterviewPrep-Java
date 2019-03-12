// Java implementation of a O(n) time  
// method for Zigzag order traversal 
import java.util.*; 
  
class BinaryTree { 
    Node rootNode; 
      
    ArrayList<LinkedList<TreeNode>> printZigZagTraversal2(TreeNode root) { 
          
        // if null then return 
        if (root == null) { 
            return; 
        } 

        ArrayList<LinkedList<TreeNode>> ans = null;

        LinkedList<TreeNode> curr = null;

        curr.add(root);

        while(curr.size() > 0){  // each iteration of the loop is a new level
            ans.add(curr);
            LinkedList<TreeNode> prev = curr;
            curr = new LinkedList<TreeNode>();

            while(TreeNode node : prev) {
                
                if(ans.size() % 2 == 0){
                    if(node.left != null){
                        curr.add(node.left);
                    }
                    if(node.right != null){
                        curr.add(node.right);
                    }
                }
                else{
                    if(node.right != null){
                        curr.add(node.right);
                    }
                    if(node.left != null){
                        curr.add(node.left);
                    }
                }

            }

        }
        return ans;
    }
    // function to print the 
    // zigzag traversal 
    void printZigZagTraversal() { 
          
        // if null then return 
        if (rootNode == null) { 
            return; 
        } 
      
        // declare two stacks 
        Stack<Node> currentLevel = new Stack<>(); 
        Stack<Node> nextLevel = new Stack<>(); 
      
        // push the root 
        currentLevel.push(rootNode); 
        boolean leftToRight = true; 
      
        // check if stack is empty 
        while (!currentLevel.isEmpty()) { 
      
            // pop out of stack 
            Node node = currentLevel.pop(); 
              
            // print the data in it 
            System.out.print(node.data + " "); 
          
            // store data according to current 
            // order. 
            if (leftToRight) { 
                if (node.leftChild != null) { 
                nextLevel.push(node.leftChild); 
                } 
                  
                if (node.rightChild != null) { 
                nextLevel.push(node.rightChild); 
                } 
            } 
            else { 
                if (node.rightChild != null) { 
                nextLevel.push(node.rightChild); 
                } 
                  
                if (node.leftChild != null) { 
                nextLevel.push(node.leftChild); 
                } 
            } 
          
            if (currentLevel.isEmpty()) { 
                leftToRight = !leftToRight; 
                Stack<Node> temp = currentLevel; 
                currentLevel = nextLevel; 
                nextLevel = temp; 
            } 
        } 
    } 


} 
  
public class zigZagTreeTraversal { 
  
    // driver program to test the above function 
    public static void main(String[] args)  
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.rootNode = new Node(1); 
        tree.rootNode.leftChild = new Node(2); 
        tree.rootNode.rightChild = new Node(3); 
        tree.rootNode.leftChild.leftChild = new Node(7); 
        tree.rootNode.leftChild.rightChild = new Node(6); 
        tree.rootNode.rightChild.leftChild = new Node(5); 
        tree.rootNode.rightChild.rightChild = new Node(4); 
      
        System.out.println("ZigZag Order traversal of binary tree is"); 
        tree.printZigZagTraversal(); 
    } 
} 