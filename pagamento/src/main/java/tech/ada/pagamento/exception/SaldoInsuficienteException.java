package tech.ada.pagamento.exception;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException() {
        super("Saldo Insuficiente");
    }

}
