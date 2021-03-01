package ejemplo.estatico;

public interface Cambio extends Comparable<Cambio> {

  String getMonedaOrigen();

  String getMonedaDestino();

  float getCantidadOrigen();

  float getCantidadDestino();

  void realizarConversionEn(PuestoCambio puesto);
  
  @Override
  default int compareTo(Cambio otro) {
    return getMonedaOrigen().compareTo(otro.getMonedaOrigen());
  }

}