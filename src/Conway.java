public class Conway {
    public void comecar(int tamanhoTabuleiro) throws Exception {
        int[][] tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
        boolean tudoVazio = true;
        
        for(int contadorLinha = 0; contadorLinha < tamanhoTabuleiro; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tamanhoTabuleiro; contadorColuna++) {
                if(Math.random() <= 0.3) {
                    tabuleiro[contadorLinha][contadorColuna] = 1;
                } else {
                    tabuleiro[contadorLinha][contadorColuna] = 0;
                }
            }
        }

        do{
            tabuleiro = reorganizarTabuleiro(tabuleiro);
            tudoVazio = checarVazio(tabuleiro);
            mostrarTabuleiro(tabuleiro);
            Thread.sleep(100);
        } while(tudoVazio == false);
    }

    public int[][] reorganizarTabuleiro(int[][] tabuleiro) {
        for(int contadorLinha = 0; contadorLinha < tabuleiro.length; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tabuleiro.length; contadorColuna++) {
                int contagemCasasVizinhas = 0;

                if(contadorColuna - 1 >= 0 && contadorLinha - 1 >= 0 && (tabuleiro[contadorLinha-1][contadorColuna-1] == 1 || tabuleiro[contadorLinha-1][contadorColuna-1] == 3)) {
                    contagemCasasVizinhas++;
                }
                if(contadorLinha - 1 >= 0 && (tabuleiro[contadorLinha-1][contadorColuna] == 1 || tabuleiro[contadorLinha-1][contadorColuna] == 3)) {
                    contagemCasasVizinhas++;
                }
                if(contadorLinha - 1 >= 0 && contadorColuna + 1 < tabuleiro.length && (tabuleiro[contadorLinha-1][contadorColuna+1] == 1 || tabuleiro[contadorLinha-1][contadorColuna+1] == 3)) {
                    contagemCasasVizinhas++;
                }
                if(contadorColuna + 1 < tabuleiro.length && (tabuleiro[contadorLinha][contadorColuna+1] == 1 || tabuleiro[contadorLinha][contadorColuna+1] == 3)) {
                    contagemCasasVizinhas++;
                }
                if(contadorLinha + 1 < tabuleiro.length && contadorColuna + 1 < tabuleiro.length && (tabuleiro[contadorLinha+1][contadorColuna+1] == 1 || tabuleiro[contadorLinha+1][contadorColuna+1] == 3)) {
                    contagemCasasVizinhas++;
                }
                if(contadorLinha + 1 < tabuleiro.length && (tabuleiro[contadorLinha+1][contadorColuna] == 1 || tabuleiro[contadorLinha+1][contadorColuna] == 3)) {
                    contagemCasasVizinhas++;
                }
                if(contadorColuna - 1 >= 0 && contadorLinha + 1 < tabuleiro.length && (tabuleiro[contadorLinha+1][contadorColuna-1] == 1 || tabuleiro[contadorLinha+1][contadorColuna-1] == 3)) {
                    contagemCasasVizinhas++;
                }
                if(contadorColuna - 1 >= 0 && (tabuleiro[contadorLinha][contadorColuna-1] == 1 || tabuleiro[contadorLinha][contadorColuna-1] == 3)) {
                    contagemCasasVizinhas++;
                }

                if(tabuleiro[contadorLinha][contadorColuna] == 0) {
                    if(contagemCasasVizinhas == 3) {
                        tabuleiro[contadorLinha][contadorColuna] = 2;
                    }
                } else {
                    if(contagemCasasVizinhas < 2 || contagemCasasVizinhas > 3) {
                        tabuleiro[contadorLinha][contadorColuna] = 3;
                    }
                }
            }
        }

        for(int contadorLinha = 0; contadorLinha < tabuleiro.length; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tabuleiro.length; contadorColuna++) {
                if(tabuleiro[contadorLinha][contadorColuna] == 3) {
                    tabuleiro[contadorLinha][contadorColuna] = 0;
                } else if(tabuleiro[contadorLinha][contadorColuna] == 2) {
                    tabuleiro[contadorLinha][contadorColuna] = 1;
                }
            }
        }

        return tabuleiro;
    }

    public void mostrarTabuleiro(int[][] tabuleiro) {
        System.out.println("\033[H");
        for(int contadorLinha = 0; contadorLinha < tabuleiro.length; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tabuleiro.length; contadorColuna++) {
                String indiceTabuleiro = (tabuleiro[contadorLinha][contadorColuna] == 1 ? "#" : ".");
                System.out.print(indiceTabuleiro + " ");
            }
            System.out.println("");
        }
    }

    public boolean checarVazio(int[][] tabuleiro) {
        boolean vazio = true;

        for(int contadorLinha = 0; contadorLinha < tabuleiro.length; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tabuleiro.length; contadorColuna++) {
                if(tabuleiro[contadorLinha][contadorColuna] == 1) {
                    vazio = false;
                }
            }
        }

        return vazio;
    }
}
