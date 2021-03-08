package ejemplo.estatico;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import ejemplo.externo.Exchange;

public class PuestoCambio {
  
  private static PuestoCambio puestoCambioSINGLETON = new PuestoCambio();
  
  private float dollarToEuro = 1.3f;
  
  public float getDollarToEuro() {
    return dollarToEuro;
  }
  
  public void setDollarToEuro(float dollarToEuro) {
    this.dollarToEuro = dollarToEuro;
  }

  public static void main(String[] args) {
    
    Cambio cambio = new CambioImpl("$", "€", 10);
    System.out.println(cambio);
    
    Cambio cambio2 = new CambioImpl("L", "$", 20);
    System.out.println(cambio);
    System.out.println(cambio2);
    
    Cambio cambio3 = new CambioExterno(Exchange.DOLLAR, Exchange.EURO, 1010);
    Cambio cambio4 = new CambioExterno(Exchange.LIBRA, Exchange.EURO, 2000);
    
    PuestoCambio puesto = new PuestoCambio();
    PuestoCambio puesto2 = new PuestoCambio() {
      @Override
      public float getDollarToEuro() {
        return 1.4f;
      }
    };
    
//    System.out.println(getFactorConversion("$", "€"));
    System.out.println(puesto.getFactorConversion(cambio.getMonedaOrigen(), cambio.getMonedaDestino()));
    
    // Cambia el dia y la conversion
    puesto.setDollarToEuro(1.32f);
    cambio.realizarConversionEn(puesto2);
    
    System.out.println(puesto.getFactorConversion(cambio));
    System.out.println(cambio);
    
    System.out.println(puesto.getFactorConversion(cambio3));
    
    List<Cambio> cambios = Arrays.asList(cambio, cambio2, cambio4, cambio3);
    cambios.forEach(System.out::println);
    cambios.sort(Comparator.naturalOrder());
    System.out.println("Lista ordenada");
    cambios.forEach(System.out::println);
  }

  public float getFactorConversion(Cambio cambio) {
    return getFactorConversion(cambio.getMonedaOrigen(), cambio.getMonedaDestino());
  }
  
  private float getFactorConversion(String monedaOrigen, String monedaDestino) {
    float conversion = -1;
    if (Objects.equals(monedaOrigen, "$") && "€".equals(monedaDestino)) {
      conversion = getDollarToEuro();
    }
    return conversion;
  }
}
