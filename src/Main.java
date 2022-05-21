import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       Credito tarjetaCredito = new Credito((long)1122334455, 123, LocalDate.of(2022, 12, 30), 40000.00 , 100000.00, 15000.00);
       Debito tarjetaDebito = new Debito((long)1122328488, 436, LocalDate.of(2021, 12, 30), 20000.00, 30000.00);

       tarjetaCredito.realizarPago(20000.00, LocalDate.of(2022, 12, 28), tarjetaCredito );
       tarjetaDebito.realizarPago(20000.00, LocalDate.of(2022, 12, 28), tarjetaDebito);


    }
}
