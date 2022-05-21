import java.time.LocalDate;

public class Debito extends Tarjeta {
    private Double saldoDisponible;

    //Constructor


    public Debito(Long numerosFrente, int codigoSeguridad, LocalDate fechaExpiracion, Double importe, Double saldoDisponible) {
        super(numerosFrente, codigoSeguridad, fechaExpiracion);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    protected boolean recibirAutorizacion(Double importe) {

        return this.saldoDisponible - importe > 0;
    }

    @Override
    protected void procesadorPago(Tarjeta tarjeta, Double importe) {
        if (this.recibirAutorizacion(importe)) {
            saldoDisponible -= importe;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
