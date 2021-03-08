package ejemplo.estatico;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public interface Cambio extends Comparable<Cambio> {
  static final DecimalFormat FORMATO = new DecimalFormat("0.0#", DecimalFormatSymbols.getInstance());
  static final String[] MONEDAS = new String[] { "$", "€", "L" };
  
  static int ordenMonedaString(String moneda) {
    int resultado = -1;
    for (int i = 0; i < MONEDAS.length; i++) {
      if (MONEDAS[i].equals(moneda)) {
        resultado = i;
        break;
      }
    }
    return resultado;
  }
  
  String getMonedaOrigen();

  String getMonedaDestino();

  float getCantidadOrigen();

  float getCantidadDestino();
  
  default int ordenMonedaOrigen() {
    return ordenMonedaString(getMonedaOrigen());
  }
  
  default int ordenMonedaDestino() {
    return ordenMonedaString(getMonedaDestino());
  }

  void realizarConversionEn(PuestoCambio puesto);
  
  @Override
  default int compareTo(Cambio otro) {
    int ordenMonedaOrigen = ordenMonedaOrigen();
    int otroOrdenMonedaOrigen = otro.ordenMonedaOrigen();
//    int comparacion = (ordenMonedaOrigen() + ordenMonedaDestino()) - (otro.ordenMonedaOrigen() + otro.ordenMonedaDestino());
    int comparacion = Integer.compare(ordenMonedaOrigen + ordenMonedaDestino(), otroOrdenMonedaOrigen + otro.ordenMonedaDestino());
    if (comparacion == 0) {
      comparacion = Integer.compare(ordenMonedaOrigen, otroOrdenMonedaOrigen);
    }
    if (comparacion == 0) {
      comparacion = -Float.compare(getCantidadOrigen(), otro.getCantidadOrigen());
    }
    return comparacion;
  }
  
  default String cambioToString() {
    return "Cambio [" + getCantidadOrigen() + getMonedaOrigen() + " a " + FORMATO.format(getCantidadDestino()) + getMonedaDestino() + "]";
  }
}