public abstract class Dispositivo implements Vendibile {
  protected String proprietario;
  protected String marca;
  protected int livelloBatteria;
  protected boolean surriscaldamento;
  protected boolean usato; // (batteria si scarica il 10% più velocemente)
  protected String modello;
  protected int eta; // (se vecchio meno probabilità di venderlo)
  protected double prezzo;
  protected double memoria; // del telefono (in GB)
  protected int statoBatteria; // (se troppo usurata non vendibile)

  public Dispositivo(String proprietario, String marca, int livelloBatteria, boolean surriscaldamento, boolean usato, String modello, int eta, double prezzo, double memoria, int statoBatteria) {
    this.proprietario = proprietario;
    this.marca = marca;
    this.livelloBatteria = livelloBatteria;
    this.surriscaldamento = surriscaldamento;
    this.usato = usato;
    this.modello = modello;
    this.eta = eta;
    this.prezzo = prezzo;
    this.memoria = memoria;
    this.statoBatteria = statoBatteria;
  }

  public boolean isVendibile() {
    boolean vendibile = false;
    if (!this.surriscaldamento && !this.usato && this.eta < 4 && this.statoBatteria >= 85) {
      vendibile = true;
    }
    return vendibile;
  }

  public abstract double TempoDiUtilizzo();
  
  public String toString() {
    String toReturn = "\nDispositivo di " + this.proprietario + "\nMarca: " + this.marca + "\nModello: " + this.modello
        + "\nLivello batteria: " + this.livelloBatteria + "%" + "\nSurriscaldamento: " + this.surriscaldamento
        + "\nUsato: " + this.usato + "\nAnni di utilizzo: " + this.eta + " anni\nPrezzo: " + this.prezzo + " €\nMemoria: " + this.memoria + " GB\nStato batteria: " + this.statoBatteria + "%\nIl tuo telefono è vendibile: " + isVendibile();

    return toReturn;

  }
}