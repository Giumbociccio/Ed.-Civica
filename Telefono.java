import java.util.*;

public class Telefono extends Dispositivo {

  private List<App> app = new ArrayList<App>();

  public Telefono(String proprietario, String marca, int livelloBatteria, boolean surriscaldamento, boolean usato,
      String modello, int eta, double prezzo, double memoria, int statoBatteria, List<App> app) {
    super(proprietario, marca, livelloBatteria, surriscaldamento, usato, modello, eta, prezzo, memoria, statoBatteria);
    this.app = app;
  }

  public double TempoDiUtilizzo() {
    double tempo = 0.0;
    if (super.livelloBatteria <= 15) {
      tempo = 8.0;
    } else if (super.livelloBatteria <= 25) {
      tempo = 6.5;
    } else if (super.livelloBatteria <= 50) {
      tempo = 4.0;
    } else if (super.livelloBatteria <= 70) {
      tempo = 3.0;
    } else if (super.livelloBatteria <= 85) {
      tempo = 1.5;
    } else if (super.livelloBatteria < 100) {
      tempo = 0.5;
    }
    if (super.surriscaldamento) {
      tempo = tempo * 1.5;
    }
    return tempo;
  }

  public String toString() {
    String toReturn = super.toString();
    double tUtilizzo = TempoDiUtilizzo();
    toReturn += "\nTempo di utilizzo: " + tUtilizzo + " ore";
    if (tUtilizzo == 8.0) {
      toReturn += "\nAHIA! Il tuo tempo di utilizzo è troppo elevato! :(";
      // x += 6 → x = x + 6
    } else if (tUtilizzo == 6.5) {
      toReturn += "\nMHH! Il tuo tempo di utilizzo è elevato! :/";
    } else if (tUtilizzo == 4.0) {
      toReturn += "\nMHH! Il tuo tempo di utilizzo è più o meno elevato! :/";
    } else if (tUtilizzo == 3.0) {
      toReturn += "\nCI SIAMO QUASI! Il tuo tempo di utilizzo è nella media! :>";
    } else if (tUtilizzo == 1.5) {
      toReturn += "\nBENE! Il tuo tempo di utilizzo è molto buono! :)";
    } else if (tUtilizzo == (0.5)) {
      toReturn += "\nFANTASTICO! Il tuo tempo di utilizzo è impeccabile! :)";
    } else {
      toReturn += "\nWOW! Non hai utilizzato il tuo telefono oggi!! XD";
    }
    toReturn += "\nApp: " + this.app;
    return toReturn;
  }

}