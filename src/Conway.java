public class Conway {
    public void comecar(int tamanhoTabuleiro, double porcentagemCelulasVivas, int taxaAtualizacao) throws Exception {
        int[][] tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
        boolean tudoVazio = true;
        RegrasConway regras = new RegrasConway();
        ConsoleView console = new ConsoleView();
        
        for(int contadorLinha = 0; contadorLinha < tamanhoTabuleiro; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tamanhoTabuleiro; contadorColuna++) {
                if(Math.random() <= porcentagemCelulasVivas) {
                    tabuleiro[contadorLinha][contadorColuna] = 1;
                } else {
                    tabuleiro[contadorLinha][contadorColuna] = 0;
                }
            }
        }

        do{
            tabuleiro = reorganizarTabuleiro(tabuleiro, regras);
            tudoVazio = checarVazio(tabuleiro);
            console.mostrarTabuleiro(tabuleiro);
            Thread.sleep(taxaAtualizacao);
        } while(tudoVazio == false);
    }

    public int[][] reorganizarTabuleiro(int[][] tabuleiro, RegrasConway regras) {
        int contadorVizinhos = 0;
        
        for(int contadorLinha = 0; contadorLinha < tabuleiro.length; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tabuleiro.length; contadorColuna++) {
                try {
                    contadorVizinhos = calcularVizinhos(tabuleiro, contadorLinha, contadorColuna, regras);
                } catch (CalculoVizinhosException e) {
                    System.out.println("Erro: " + e);
                }
                
                // Valores temporários para não interferirem na próxima célula
                if(tabuleiro[contadorLinha][contadorColuna] == 0) {
                    if(contadorVizinhos == regras.getCelulasReproducao()) {
                        tabuleiro[contadorLinha][contadorColuna] = regras.getVaiViver();
                    }
                } else {
                    if(contadorVizinhos < regras.getCelulasSubpopulacao() || contadorVizinhos > regras.getCelulasSuperpopulacao()) {
                        tabuleiro[contadorLinha][contadorColuna] = regras.getVaiMorrer();
                    }
                }
            }
        }

        // Reajuste dos valores
        for(int contadorLinha = 0; contadorLinha < tabuleiro.length; contadorLinha++) {
            for(int contadorColuna = 0; contadorColuna < tabuleiro.length; contadorColuna++) {
                if(tabuleiro[contadorLinha][contadorColuna] == regras.getVaiMorrer()) {
                    tabuleiro[contadorLinha][contadorColuna] = 0;
                } else if(tabuleiro[contadorLinha][contadorColuna] == regras.getVaiViver()) {
                    tabuleiro[contadorLinha][contadorColuna] = 1;
                }
            }
        }

        return tabuleiro;
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

    public int calcularVizinhos(int[][] tabuleiro, int contadorLinha, int contadorColuna, RegrasConway regras) throws CalculoVizinhosException{
        int contagemCasasVizinhas = 0;

        if((contadorLinha < 0 || contadorLinha > tabuleiro.length) || (contadorColuna < 0 || contadorColuna > tabuleiro.length)) {
            throw new CalculoVizinhosException("A contagem dos vizinhos de uma célula atingiu coordenadas inválidas. Tente novamente.");
        }

        if(contadorColuna - 1 >= 0 && (tabuleiro[contadorLinha-1][contadorColuna-1] == 1 || tabuleiro[contadorLinha-1][contadorColuna-1] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }
        if(contadorLinha - 1 >= 0 && (tabuleiro[contadorLinha-1][contadorColuna] == 1 || tabuleiro[contadorLinha-1][contadorColuna] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }
        if(contadorLinha - 1 >= 0 && contadorColuna + 1 < tabuleiro.length && (tabuleiro[contadorLinha-1][contadorColuna+1] == 1 || tabuleiro[contadorLinha-1][contadorColuna+1] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }
        if(contadorColuna + 1 < tabuleiro.length && (tabuleiro[contadorLinha][contadorColuna+1] == 1 || tabuleiro[contadorLinha][contadorColuna+1] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }
        if(contadorLinha + 1 < tabuleiro.length && contadorColuna + 1 < tabuleiro.length && (tabuleiro[contadorLinha+1][contadorColuna+1] == 1 || tabuleiro[contadorLinha+1][contadorColuna+1] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }
        if(contadorLinha + 1 < tabuleiro.length && (tabuleiro[contadorLinha+1][contadorColuna] == 1 || tabuleiro[contadorLinha+1][contadorColuna] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }
        if(contadorColuna - 1 >= 0 && contadorLinha + 1 < tabuleiro.length && (tabuleiro[contadorLinha+1][contadorColuna-1] == 1 || tabuleiro[contadorLinha+1][contadorColuna-1] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }
        if(contadorColuna - 1 >= 0 && (tabuleiro[contadorLinha][contadorColuna-1] == 1 || tabuleiro[contadorLinha][contadorColuna-1] == regras.getVaiMorrer())) {
            contagemCasasVizinhas++;
        }

        return contagemCasasVizinhas;
    }
}
