import java.util.*;

public class Main {

  public static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println(
        "Salve, benvenuto/a nel nostro programma!\n\nGrazie al nostro aiuto puoi dare una seconda vita al tuo telefono diminuendo la produzione e il consumo di telefoni che impattano negativamente sull'ambiente.\nIn base ad alcuni dati che ti chiederemo in input, saremo in grado di capire se il tuo telefono è nelle condizioni di essere venduto e quindi riutilizzato.\nInserendo vari dati, possiamo anche darti un resoconto del tempo di utilizzo del tuo telefono e in caso aiutarti a disintossicarti.\nGrazie per aver scelto di supportare il nostro programma e goditi l'esperienza!\n");

    List<Persona> persone = new ArrayList<Persona>();

    boolean farePersona = true;
    
    while (farePersona) {
      String nome = chiedi("\nCiao, come ti chiami?", false);
      persone.add(new Persona(nome));
      
      farePersona = Boolean.parseBoolean(chiedi("\nVuoi controllare un'altra persona?", true));
    }
  } // end main

  public static String chiedi(String domanda, boolean si) {
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

} // end class Main