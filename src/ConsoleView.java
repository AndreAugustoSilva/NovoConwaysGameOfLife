public class ConsoleView {
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
}
