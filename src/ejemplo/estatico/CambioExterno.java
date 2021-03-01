package ejemplo.estatico;

import ejemplo.externo.Exchange;

public class CambioExterno extends Exchange implements Cambio, Comparable<CambioExterno> {

  private static final String[] MONEDAS = new String[] { "$", "€", "L" };
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
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public float getCantidadDestino() {
    // TODO Auto-generated method stub
    return 0;
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
    return "CambioExterno [" + getCantidadOrigen() + getMonedaOrigen() + " a " + FORMATO.format(getCantidadDestino()) + getMonedaDestino() + "]";
  }
  
}
