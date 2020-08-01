package challenge;

import java.util.*;

public class Vagas{
    private List<Carro> listaCarros = new ArrayList<Carro>();

   public boolean add(Carro carro){
        if (lotado()) {
            if (remove() != null) {
                return listaCarros.add(carro);
            }
            throw new EstacionamentoException("Carro não entrou");
        }
        return listaCarros.add(carro);
   }

    public Carro remove(){
        Carro carroParaSair = getCarroComPrioridadeDeSaida();
        if (carroParaSair != null)
            listaCarros.remove(carroParaSair);
        else
            throw new EstacionamentoException("Carro não saiu");
        return carroParaSair;
    }

    public int qtdCarros(){
       return listaCarros.size();
    }

    public boolean contemCarro (Carro carro){
       return listaCarros.contains(carro);
    }

    private Carro getCarroComPrioridadeDeSaida(){
        return listaCarros.parallelStream().
                filter(carro -> carro.getMotorista().getIdade() < 56).findFirst().orElse(null);
    }

    private boolean lotado(){
        return listaCarros.size() == 10;
    }

    @Override
    public String toString(){
       String lista = "";
        for (Carro carro : listaCarros) {
            lista += carro + "----------------------\n";
        }
       return lista;
    }
}
