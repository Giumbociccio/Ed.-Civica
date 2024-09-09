import java.util.*;
public class Persona{
  private String nome;
  public List<Telefono> telefoni;
  private Scanner s = new Scanner(System.in);

  public Persona(String nome){
    this.nome = nome;
    this.telefoni = new ArrayList<Telefono>();
    
    boolean fareTel = true;
    while (fareTel) {
      this.telefoni.add(faiTelefono());
      fareTel = Boolean.parseBoolean(chiedi("\nVuoi controllare un'altro telefono?", true));
    }
    
  }

  public Telefono faiTelefono() {

    String marca = chiedi("Di che marca è il telefono?", false);

    String modello = chiedi("Di che modello è il telefono?", false);

    int livelloBatteria = Integer.parseInt(chiedi("Qual è il livello attuale di batteria del telefono?", false));

    while (livelloBatteria < 0 || livelloBatteria > 100) {
      System.out.println("ERRORE! Il livello di batteria non può superare 100%");
      livelloBatteria = Integer.parseInt(chiedi("Qual è il livello di batteria del telefono?", false));
      break;
    }

    // Integer.parseInt("3") dice che traformo la stringa in un intero
    // Boolean.parseBoolean("true") dice che traformo la stringa in un booleano

    boolean surriscaldamento = Boolean.parseBoolean(chiedi("Il telefono è in surriscaldamento? (sì/no).", true));

    boolean usato = Boolean.parseBoolean(chiedi("Il telefono è stato acquistato usato? (sì/no)", true));

    int eta = Integer.parseInt(chiedi("Quanti anni di utilizzo ha il telefono?", false));

    double prezzo = Double.parseDouble(chiedi("Quanto costa il telefono (€)?", false));

    double memoria = Double.parseDouble(chiedi("Quanta memoria ha il telefono (GB)?", false));

    int statoBatteria = Integer.parseInt(chiedi("Stato corrente della batteria?", false));

    while (statoBatteria < 0 || statoBatteria > 100) {
      System.out.println("ERRORE! Lo stato di batteria non può superare 100%");
      statoBatteria = Integer.parseInt(chiedi("Qual è lo stato corrente di batteria del telefono?", false));
    }

    List<App> app = new ArrayList<App>();

    boolean controllaApp = true;
    while (controllaApp) {
      String nome = chiedi("\nCome si chiama l'app che usi più frequentemente?", false);
      double peso = Double.parseDouble(chiedi("Quanto pesa l'app (GB)?", false));
      int consumoBatteriaH = Integer.parseInt(chiedi("Quanta percentuale di batteria consuma l'app in un'ora?", false));

      app.add(new App(nome, peso, consumoBatteriaH));
      System.out.println(app);

      controllaApp = Boolean.parseBoolean(chiedi("\nVuoi controllare un'altra app?", true));
    }

    Telefono t1 = new Telefono(this.nome, marca, livelloBatteria, surriscaldamento, usato, modello, eta, prezzo,
        memoria, statoBatteria, app);

    System.out.println(t1);

    return t1;
  }

  public String chiedi(String domanda, boolean si) {
    System.out.println(domanda);
    String risposta = "";
    if (si) {
      risposta = s.nextLine();
      while (!risposta.equalsIgnoreCase("si") && !risposta.equalsIgnoreCase("sì") && !risposta.equalsIgnoreCase("no")) {
        System.out.println("ERRORE! scrivere solo si o no.");
        risposta = s.nextLine();
      } // Ignorecase indica che non cambia se i caratteri sono maiuscoli o minuscoli
      if (risposta.equalsIgnoreCase("no")) {
        risposta = "false"; // string non boolean perchè chiedi restituisce solo string
      } else {
        risposta = "true";
      }
    } else {
      risposta = s.nextLine();
    }

    return risposta;
  }
  
  
  public String toString(){
    return this.nome;
  }
}