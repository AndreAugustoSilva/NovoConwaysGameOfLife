import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Conway conway = new Conway();

        System.out.println("Digite o tamanho do tabuleiro: ");
        int tamanhoTabuleiro = sc.nextInt();
        
        conway.comecar(tamanhoTabuleiro);

        sc.close();
    }
}
