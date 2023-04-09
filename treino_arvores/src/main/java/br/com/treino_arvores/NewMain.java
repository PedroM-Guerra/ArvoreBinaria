
package br.com.treino_arvores;


public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode raiz = new TreeNode(10);
        Arvore arvore = new Arvore(raiz);
        
        //System.out.println(arvore.getRoot().getValor());
        
        arvore.addNode(9);
        arvore.addNode(11);
        arvore.addNode(8);
        arvore.addNode(18);
        arvore.addNode(12);
        
        arvore.emOrdem(raiz);
        System.out.println("----");
        System.out.println(arvore.deleteNode(9));
        
        arvore.emOrdem(raiz);

    }
    
}
