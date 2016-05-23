package facebook;

import java.util.*;

/**
 * Created by jun on 5/18/16.
 */
public class AllPath {

    public static class Node {
        Node left, right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        n4.left = n5;
        n4.right = n6;

        List<List<Node>> list = allPaths(n1);
        for (List<Node> l : list) {
            for (Node n : l)
                System.out.print(n.val);
            System.out.println();

        }


    }

    public static List<List<Node>> allPaths(Node node) {
        List<List<Node>> result = new LinkedList<>();
        LinkedList<Node> currPath = new LinkedList<>();

        helper(node, currPath, result);
        return result;

    }

    public static void helper(Node node, LinkedList<Node> currPath, List<List<Node>> result) {
        if (node==null)
            return ;

        if (node.left == null && node.right == null) {
            currPath.add(node);
            result.add(new LinkedList<Node>(currPath));
            currPath.removeLast();
            return;
        }

        currPath.add(node);
        if (node.left != null)
            helper(node.left, currPath, result);

        if (node.right != null)
            helper(node.right, currPath, result);
        currPath.removeLast();
    }
}
