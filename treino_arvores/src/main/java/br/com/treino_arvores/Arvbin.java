package br.com.treino_arvores;

public class Arvbin<T extends Comparable<T>> {

    private T val;

    private Arvbin<T> esq, dir;

    public Arvbin(T valor) {
        val = valor;
        esq = null;
        dir = null;
    }

    public Arvbin(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir) {
        val = valor;
        esq = arvEsq;
        dir = arvDir;
    }

    public void mostra() {
        System.out.println("(" + val);
        if (esq != null) {
            esq.mostra();
        }
        if (dir != null) {
            dir.mostra();
        }
        System.out.println(")");
    }

    public int calculaAltura() {
        int altEsq = 0, altDir = 0;

        if ((esq == null) && (dir == null)) {
            return 0;
        }
        if (esq != null) {
            altEsq = esq.calculaAltura();
        }
        if (dir != null) {
            altDir = dir.calculaAltura();
        }
        return 1 + Math.max(altDir, altDir);
    }

    public T calculaMaximo() {
        if ((esq == null) && (dir == null)) {
            return val;
        }

        T maiorGeral, maiorEsq, maiorDir;

        if ((esq != null) && (dir == null)) {
            maiorGeral = esq.calculaMaximo();
        } else if ((esq == null) && (dir != null)) {
            maiorGeral = dir.calculaMaximo();
        } else {
            maiorEsq = esq.calculaMaximo();
            maiorDir = dir.calculaMaximo();

            if (maiorEsq.compareTo(maiorDir) > 0) {
                maiorGeral = maiorEsq;
            } else {
                maiorGeral = maiorDir;
            }
        }

        if (maiorGeral.compareTo(val) > 0) {
            return maiorGeral;
        }

        return val;
    }

    /* Verifica se um valor está na árvore. Se estiver, retorna um ponteiro para o
       o nó que tem esse valor. Caso contrário, retorna null. */
    public Arvbin<T> busca(T valor) {

        Arvbin<T> ret;

        /* Se é igual ao valor armazenado, não precisa procurar mais. O nó é a raiz. */
        if (valor.compareTo(val) == 0) {
            return this;
        }

        /* Senão, começa procurando na sub-árvore esquerda. */
        if (esq != null) {
            ret = esq.busca(valor);
            if (ret != null) {
                return ret;
            }
        }

        /* Se chega a esse ponto, estará na árvore se, e somente se, 
         estiver na sub-árvore direita */
        if (dir != null) {
            return dir.busca(valor);
        }
        return null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Arvbin<T> getEsq() {
        return esq;
    }

    public void setEsq(Arvbin<T> esq) {
        this.esq = esq;
    }

    public Arvbin<T> getDir() {
        return dir;
    }

    public void setDir(Arvbin<T> dir) {
        this.dir = dir;
    }

}
