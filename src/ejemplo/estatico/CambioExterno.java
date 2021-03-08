package ejemplo.estatico;

import ejemplo.externo.Exchange;

public class CambioExterno extends Exchange implements Cambio {

  private String monedaOrigen, monedaDestino;
  
  private static String[] getMonedas() {
    return MONEDAS;
  }

  @Override
  public String getMonedaOrigen() {
    return getMonedas()[getFrom()];
  }

  @Override
  public String getMonedaDestino() {
    return monedaDestino;
  }

  @Override
  public float getCantidadOrigen() {
    return getCentsFrom()/100f;
  }

  @Override
  public float getCantidadDestino() {
    return getCentsTo()/100f;
  }

  @Override
  public void realizarConversionEn(PuestoCambio puesto) {
    // TODO Auto-generated method stub
  }
  
  public CambioExterno(int from, int to, int centsFrom) {
    super(from, to, centsFrom);
    monedaDestino = getMonedas()[getTo()];
  }
  
  @Override
  public String toString() {
    return cambioToString();
  }
  
}
