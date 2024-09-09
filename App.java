public class App{

  protected String nome;
  protected double peso; //in GB
  protected int consumoBatteriaH; //in % all'ora

  public App(String nome, double peso, int consumoBatteriaH){
  this.nome = nome;
  this.peso = peso;
  this.consumoBatteriaH = consumoBatteriaH;
  }

  public String toString(){
    return "\nNome dell'app: " + this.nome + "\nPeso in GB: " + this.peso + " GB" + "\nConsumo batteria: " + this.consumoBatteriaH + " %";
  }


}
