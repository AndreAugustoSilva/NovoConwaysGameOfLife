public class RegrasConway {
    private int celulasSuperpopulacao;
    private int celulasSubpopulacao;
    private int celulasReproducao;
    private int vaiMorrer;
    private int vaiViver;

    public RegrasConway() {
        this.celulasSuperpopulacao = 3;
        this.celulasSubpopulacao = 2;
        this.celulasReproducao = 3;
        this.vaiMorrer = 3;
        this.vaiViver = 2;
    }

    public int getCelulasSuperpopulacao() {
        return celulasSuperpopulacao;
    }
    public void setCelulasSuperpopulacao(int celulasSuperpopulacao) {
        this.celulasSuperpopulacao = celulasSuperpopulacao;
    }
    public int getCelulasSubpopulacao() {
        return celulasSubpopulacao;
    }
    public void setCelulasSubpopulacao(int celulasSubpopulacao) {
        this.celulasSubpopulacao = celulasSubpopulacao;
    }
    public int getCelulasReproducao() {
        return celulasReproducao;
    }
    public void setCelulasReproducao(int celulasReproducao) {
        this.celulasReproducao = celulasReproducao;
    }
    public int getVaiMorrer() {
        return vaiMorrer;
    }
    public void setVaiMorrer(int vaiMorrer) {
        this.vaiMorrer = vaiMorrer;
    }
    public int getVaiViver() {
        return vaiViver;
    }
    public void setVaiViver(int vaiViver) {
        this.vaiViver = vaiViver;
    }
}
