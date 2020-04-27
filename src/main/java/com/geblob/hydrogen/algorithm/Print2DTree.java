package com.geblob.hydrogen.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Print2DTree {


    public List<List<String>> printTree(TreeNode root) {
        int rows = root == null ? 1 : getHeight(root);
        int cols = (1 << rows) - 1;
        List<List<String>> list = new ArrayList<>();
        List<String> row = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            row.add("");
        }
        for (int i = 0; i < rows; i++) {
            list.add(new ArrayList<>(row));
        }
        dfs(root, rows, 0, 0, cols - 1, list);
        return list;
    }

    public void dfs(TreeNode root, int rows, int row, int i, int j, List<List<String>> list) {
        if (row == rows || root == null) {
            return;
        }
        list.get(row).set((i + j) / 2, Integer.toString(root.val));
        dfs(root.left, rows, row + 1, i, (i + j) / 2 - 1, list);
        dfs(root.right, rows, row + 1, (i + j) / 2 + 1, j, list);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.right), getHeight(root.left));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        root.setLeft(left);
        root.setRight(right);
        left.setRight(leftRight);
        left.setLeft(leftLeft);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        List<List<String>> list = new Print2DTree().printTree(root);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            List<String> row = list.get(i);
            System.out.print("[");
            for (int j = 0; j < row.size(); j++) {
                System.out.print("\"" + row.get(j) + "\"");
                if (j < row.size() - 1) {
                    System.out.print(",");
                }
            }
            if (i < list.size() - 1) {
                System.out.println("],");
            } else {
                System.out.print("]");
            }
        }
        System.out.println("]");
    }
}
