package com.melalex.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CountSmaller {

  static final class Tree {

    private Tree left;
    private Tree right;
    private int height = 1;
    private final int value;

    Tree(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "IndexTree{" +
          "value=" + value +
          '}';
    }
  }

  public List<Integer> countSmaller(int[] nums) {
    if (nums.length == 0) {
      return List.of();
    }

    var visited = new TreeSet<Integer>();
    var result = new ArrayList<Integer>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      result.add(0);
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      var value = nums[i];
      result.set(i,  visited.headSet(value, false).size());
      visited.add(value);
    }

    return result;
  }

//  public List<Integer> countSmaller(int[] nums) {
//    if (nums.length == 0) {
//      return List.of();
//    }
//
//    var root = new Tree(nums[nums.length - 1]);
//    var result = new ArrayList<Integer>(nums.length);
//
//    for (int i = 0; i < nums.length; i++) {
//      result.add(0);
//    }
//
//    for (int i = nums.length - 2; i >= 0; i--) {
//      result.set(i, addToTree(root, nums[i], 0));
//    }
//
//    return result;
//  }

  private int addToTree(Tree tree, int value, int acc) {
    tree.height++;
    if (value > tree.value) {
      var newAcc = acc + 1 + extractHeight(tree.left);
      if (tree.right == null) {
        tree.right = new Tree(value);

        return newAcc;
      } else {
        return addToTree(tree.right, value, newAcc);
      }
    } else {
      if (tree.left == null) {
        tree.left = new Tree(value);

        return acc;
      } else {
        return addToTree(tree.left, value, acc);
      }
    }
  }

  private int extractHeight(Tree tree) {
    if (tree == null) return 0;
    else return tree.height;
  }

//  public List<Integer> countSmaller(int[] nums) {
//    if (nums.length == 0) {
//      return List.of();
//    }
//
//    var result = new ArrayList<Integer>(nums.length);
//    var root = new IndexTree(null, null, 0);
//
//    for (int i = 0; i < nums.length; i++) {
//      result.add(0);
//    }
//
//    for (var i = 1; i < nums.length; i++) {
//      addToTree(root, i, nums, result);
//    }
//
//    return result;
//  }
//
//  private void addToTree(IndexTree tree, int i, int[] nums, ArrayList<Integer> result) {
//    if (nums[tree.index] > nums[i]) {
//      result.set(tree.index, result.get(tree.index) + 1);
//      increment(tree.right, result);
//
//      if (tree.left != null) {
//        addToTree(tree.left, i, nums, result);
//      } else {
//        tree.left = new IndexTree(null, null, i);
//      }
//    } else if (tree.right != null) {
//      addToTree(tree.right, i, nums, result);
//    } else {
//      tree.right = new IndexTree(null, null, i);
//    }
//  }
//
//  private void increment(IndexTree tree, ArrayList<Integer> result) {
//    if (tree != null) {
//      result.set(tree.index, result.get(tree.index) + 1);
//
//      increment(tree.left, result);
//      increment(tree.right, result);
//    }
//  }

//  public List<Integer> countSmaller(int[] nums) {
//    var valueToIndex = new HashMap<Integer, List<Integer>>();
//
//    for (int i = 0; i < nums.length; i++) {
//      var value = nums[i];
//
//      if (!valueToIndex.containsKey(value)) {
//        valueToIndex.put(value, new LinkedList<>());
//      }
//
//      valueToIndex.get(value).add(i);
//    }
//
//    var sorted = Arrays.stream(nums).distinct().sorted().toArray();
//    var result = new ArrayList<Integer>(nums.length);
//
//    for (int i = 0; i < nums.length; i++) {
//      result.add(0);
//    }
//
//    for (int value : sorted) {
//
//    }
//
//    return result;
//  }

  public static void main(String[] args) {
    System.out.println(new CountSmaller().countSmaller(new int[]{5, 2, 6, 1}));
    System.out.println(new CountSmaller().countSmaller(new int[]{-1, -1}));
    System.out.println(new CountSmaller().countSmaller(new int[]{2, 0, 1}));
  }
}
