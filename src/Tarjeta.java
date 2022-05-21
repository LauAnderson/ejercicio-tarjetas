import java.time.LocalDate;
import java.time.Period;

public abstract class Tarjeta {
    private Long numerosFrente;
    private int codigoSeguridad;
    private LocalDate fechaExpiracion;


    //Constructor
    public Tarjeta(Long numerosFrente, int codigoSeguridad, LocalDate fechaExpiracion) {
        this.numerosFrente = numerosFrente;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
    }
    //Getters and Setters.
    public Long getNumerosFrente() {
        return numerosFrente;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    //Métodos
    public void realizarPago(Double importe, LocalDate fecha, Tarjeta tarjeta){
        if (recibirAutorizacion(importe) && validarFechaExpiracion(fecha)){
            procesadorPago(tarjeta, importe);
        }else {
            System.out.println("No es posible realizar el pago");
        }
    }

    //Métodos a sobreescribir.
    protected abstract void procesadorPago(Tarjeta tarjeta, Double importe);


    protected abstract boolean recibirAutorizacion(Double importe);

    private boolean validarFechaExpiracion(LocalDate fecha){
        return Period.between(fechaExpiracion, fecha).getDays() > 0;
    }
}
