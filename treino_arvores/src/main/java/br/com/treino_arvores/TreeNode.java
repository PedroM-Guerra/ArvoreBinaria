package br.com.treino_arvores;

import java.util.ArrayList;
import java.util.List;


public class TreeNode {
    
    private int valor;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private List children;

    public TreeNode() {
    }

    public TreeNode(int valor, TreeNode left, TreeNode right, TreeNode parent, List children) {
        this.valor = valor;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.children = children;
    }

    TreeNode(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
