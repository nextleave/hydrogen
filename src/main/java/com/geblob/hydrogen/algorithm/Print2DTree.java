package com.geblob.hydrogen.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Print2DTree {


    public List<List<String>> convertTree2Matrix(TreeNode root) {
        int rowNum = root == null ? 1 : getHeight(root);
        int colNum = (1 << rowNum) - 1;
        List<List<String>> matrix = new ArrayList<>(rowNum);
        List<String> row = new ArrayList<>(colNum);
        for (int i = 0; i < colNum; i++) {
            row.add("");
        }
        for (int i = 0; i < rowNum; i++) {
            matrix.add(new ArrayList<>(row));
        }
        fillMatrixRecursive(root, rowNum, 0, 0, colNum - 1, matrix);
        return matrix;
    }

    public void fillMatrixRecursive(TreeNode root, int rowNum, int nthRow, int leftMarginIndex, int rightMarginIndex, List<List<String>> matrix) {
        if (nthRow == rowNum || root == null) {
            return;
        }
        matrix.get(nthRow).set((leftMarginIndex + rightMarginIndex) / 2, Integer.toString(root.val));
        fillMatrixRecursive(root.left, rowNum, nthRow + 1, leftMarginIndex, (leftMarginIndex + rightMarginIndex) / 2 - 1, matrix);
        fillMatrixRecursive(root.right, rowNum, nthRow + 1, (leftMarginIndex + rightMarginIndex) / 2 + 1, rightMarginIndex, matrix);
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
        List<List<String>> list = new Print2DTree().convertTree2Matrix(root);
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
