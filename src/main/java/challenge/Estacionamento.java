package challenge;

public class Estacionamento {

    private Vagas vagas = new Vagas();

    public void estacionar(Carro carro) {
        if(temMotorista(carro) &&
                motoristaLegal(carro.getMotorista()) &&
                !habilitacaoSuspensa(carro.getMotorista()))
            vagas.add(carro);
        else
            throw new EstacionamentoException("Carro não pode estacionar!");
    }

    public int carrosEstacionados() {
        return vagas.qtdCarros();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contemCarro(carro);
    }

    @Override
    public String toString(){
        return vagas.toString();
    }

    private boolean temMotorista(Carro carro){
        return carro.getMotorista() != null;
    }

    private boolean motoristaLegal(Motorista motorista){
        return motorista.getIdade() >= 18 &&
                motorista.getHabilitacao() != null;
    }

    private boolean habilitacaoSuspensa(Motorista motorista){
        return motorista.getPontos() > 20;
    }
}
