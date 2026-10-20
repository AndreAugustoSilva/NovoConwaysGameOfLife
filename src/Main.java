import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Conway conway = new Conway();

        System.out.println("Olá, bem vindo ao Conway's Game Of Life!\nDigite o tamanho do tabuleiro: ");
        int tamanhoTabuleiro = sc.nextInt();
        System.out.println("Digite a porcentagem de células vivas (1 - 100):");
        double porcentagemCelulasVivas = (sc.nextDouble()/100);
        
        conway.comecar(tamanhoTabuleiro, porcentagemCelulasVivas);

        sc.close();
    }
}
