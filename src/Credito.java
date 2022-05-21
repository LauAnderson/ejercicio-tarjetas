import java.sql.SQLOutput;
import java.time.LocalDate;

public class Credito extends Tarjeta {
    private Double limite;
    private Double saldoUtilizado;

    //Constructor

    public Credito(Long numerosFrente, int codigoSeguridad, LocalDate fechaExpiracion, Double importe, Double limite, Double saldoUtilizado) {
        super(numerosFrente, codigoSeguridad, fechaExpiracion);
        this.limite = limite;
        this.saldoUtilizado = saldoUtilizado;
    }

    //Getters and Setters
    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(Double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }


    //Métodos

    @Override
    protected boolean recibirAutorizacion(Double importe) {
        Double saldo = limite - saldoUtilizado;
        return (importe < saldo);
    }

    @Override
    protected void procesadorPago(Tarjeta tarjeta, Double importe) {
        Double saldo = limite - saldoUtilizado;
        if (saldo >= importe){
             saldoUtilizado += importe;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
