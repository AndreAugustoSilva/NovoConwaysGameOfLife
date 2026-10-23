public class CalculoVizinhosException extends Exception{
    String mensagem;
    
    public CalculoVizinhosException(String mensagem) {
        this.mensagem = mensagem;
    }
}
