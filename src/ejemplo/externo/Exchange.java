package ejemplo.externo;

public class Exchange {

  public static final int DOLLAR = 0;
  public static final int EURO = 1;
  public static final int LIBRA = 2;
  
  private int from, to, centsFrom, centsTo = -1;

  public int getFrom() {
    return from;
  }

  protected void setFrom(int from) {
    this.from = from;
  }

  public int getTo() {
    return to;
  }

  protected void setTo(int to) {
    this.to = to;
  }

  public int getCentsFrom() {
    return centsFrom;
  }

  protected void setCentsFrom(int centsFrom) {
    this.centsFrom = centsFrom;
  }

  public int getCentsTo() {
    return centsTo;
  }

  protected void setCentsTo(int centsTo) {
    this.centsTo = centsTo;
  }

  public Exchange(int from, int to, int centsFrom) {
    super();
    this.from = from;
    this.to = to;
    this.centsFrom = centsFrom;
  }
  
}
