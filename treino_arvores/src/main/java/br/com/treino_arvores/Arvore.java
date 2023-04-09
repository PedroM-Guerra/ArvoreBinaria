package br.com.treino_arvores;

public class Arvore {

    private TreeNode root;

    public Arvore(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void addNode(int valor) {
        TreeNode novo = new TreeNode(valor);
        if (getRoot() == null) {
            this.root = novo;
        } else {
            TreeNode atual = root;
            TreeNode anterior;
            while (true) {
                anterior = atual;
                if (novo.getValor() <= atual.getValor()) {
                    atual = atual.getLeft();
                    if (atual == null) {
                        anterior.setLeft(novo);
                        return;
                    }
                } else {
                    atual = atual.getRight();
                    if (atual == null) {
                        anterior.setRight(novo);
                        return;
                    }
                }
            }

        }
    }

    public boolean deleteNode(int valor) {
        TreeNode atual = new TreeNode(root.getValor());
        TreeNode paiAtual = null;
        while (atual != null) {
            if (atual.getValor() == valor) {
                break;
            } else if (valor > atual.getValor()) {
                paiAtual = atual;
                atual = atual.getLeft();
            } else {
                paiAtual = atual;
                atual = atual.getRight();
            }

        }
        //verifica se elemento existe
        if (atual != null) {

            if (atual.getRight() != null) {
                
                TreeNode substituto = atual.getRight();
                TreeNode paiSubstituto = atual;
                
                while (substituto.getLeft() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getLeft();
                }
                substituto.setLeft(atual.getLeft());
                if (paiAtual != null) {
                    if (atual.getValor() < paiAtual.getValor()) {
                        paiAtual.setLeft(substituto);
                    } else {
                        paiAtual.setRight(substituto);
                    }
                } else {
                    this.root = substituto;
                    paiSubstituto.setLeft(null);
                    this.root.setRight(paiSubstituto);
                    this.root.setLeft(atual.getLeft());
                }

                if (substituto.getValor() < paiSubstituto.getValor()) {
                    substituto.setLeft(null);
                } else {
                    paiSubstituto.setRight(null);
                }

            } else if (atual.getLeft() != null) {
                TreeNode substituto = atual.getLeft();
                TreeNode paiSubstituto = atual;
                while (substituto.getRight() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getRight();
                }
                if (paiAtual != null) {
                    if (atual.getValor() < paiAtual.getValor()) {
                        paiAtual.setLeft(substituto);
                    } else {
                        paiAtual.setRight(substituto);
                    }
                } else {
                    this.root = substituto;
                }

                if (substituto.getValor() < paiSubstituto.getValor()) {
                    paiSubstituto.setLeft(null);
                } else {
                    paiSubstituto.setRight(null);
                }

            } else {
                if (paiAtual != null) {
                    if (atual.getValor() < paiAtual.getValor()) {
                        paiAtual.setLeft(null);
                    } else {
                        paiAtual.setRight(null);
                    }
                } else {
                    this.root = null;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void emOrdem(TreeNode atual) {
        if (atual != null) {
            emOrdem(atual.getLeft());
            System.out.println(atual.getValor());
            emOrdem(atual.getRight());
        }
    }

    public void preOrdem(TreeNode atual) {
        if (atual != null) {
            System.out.println(atual.getValor());
            preOrdem(atual.getLeft());
            preOrdem(atual.getRight());
        }
    }

    public void posOrdem(TreeNode atual) {
        if (atual != null) {
            posOrdem(atual.getLeft());
            posOrdem(atual.getRight());
            System.out.println(atual.getValor());
        }
    }

}
