package ejemplo.estatico;

public class CambioImpl extends Object implements Cambio {

//  static Cambio cambio = new Cambio("F", "D", 3);
  private String monedaOrigen, monedaDestino;
  private float cantidadOrigen, cantidadDestino;
  
  @Override
  public String getMonedaOrigen() {
    return monedaOrigen;
  }

  @Override
  public String getMonedaDestino() {
    return monedaDestino;
  }

  @Override
  public float getCantidadOrigen() {
    return cantidadOrigen;
  }
  
  private void setCantidadOrigen(float cantidadOrigen) {
    this.cantidadOrigen = cantidadOrigen > 0 ? cantidadOrigen : 0;
  }

  @Override
  public float getCantidadDestino() {
    return cantidadDestino;
  }

  private void setCantidadDestino(float cantidadDestino) {
    this.cantidadDestino = cantidadDestino;
  }
  
  public CambioImpl(String monedaOrigen, String monedaDestino, float cantidadOrigen) {
    this.monedaOrigen = monedaOrigen;
    this.monedaDestino = monedaDestino;
    this.cantidadOrigen = cantidadOrigen;
  }

  @Override
  public String toString() {
    return cambioToString();
  }
  
  @Override
  public void realizarConversionEn(PuestoCambio puesto) {
    realizarConversionPor(puesto.getFactorConversion(this));
  }
  
  private void realizarConversionPor(float conversion) {
    setCantidadDestino(getCantidadOrigen() * conversion);
  }
  
}
