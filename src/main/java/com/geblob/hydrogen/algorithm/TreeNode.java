package com.geblob.hydrogen.algorithm;

import lombok.Data;

@Data
public class TreeNode {
    public final int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
