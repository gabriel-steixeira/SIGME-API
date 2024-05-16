import java.util.List;

/**
 * Classe que representa o Caixa de uma microempresa.
 */
public class Caixa {
    public double saldo;
    public List<Double> saldoUltimaSemana;
    public List<Double> saldoUltimoMes;   
    public String usuarioalteracao; 
    
    /**
     * Construtor da classe Caixa.
     * @param saldo O saldo inicial do caixa.
     * @param saldoUltimaSemana A lista de saldos da última semana.
     * @param saldoUltimoMes A lista de saldos do último mês.
     * @param usuarioalteracao O usuário que realizou a última alteração no caixa.
     */
    public Caixa(double saldo, List<Double> saldoUltimaSemana, List<Double> saldoUltimoMes, String usuarioalteracao) {
        this.saldo = saldo;
        this.saldoUltimaSemana = saldoUltimaSemana;
        this.saldoUltimoMes = saldoUltimoMes;
        this.usuarioalteracao = usuarioalteracao;
    }

    /**
     * Obtém o saldo do caixa.
     * @return O saldo atual do caixa.
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Define o saldo do caixa.
     * @param saldo O novo saldo do caixa.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /**
     * Obtém a lista de saldos da última semana.
     * @return A lista de saldos da última semana.
     */
    public List<Double> getSaldoUltimaSemana() {
        return saldoUltimaSemana;
    }

    /**
     * Define a lista de saldos da última semana.
     * @param saldoUltimaSemana A nova lista de saldos da última semana.
     */
    public void setSaldoUltimaSemana(List<Double> saldoUltimaSemana) {
        this.saldoUltimaSemana = saldoUltimaSemana;
    }

    /**
     * Obtém a lista de saldos do último mês.
     * @return A lista de saldos do último mês.
     */
    public List<Double> getSaldoUltimoMes() {
        return saldoUltimoMes;
    }

    /**
     * Define a lista de saldos do último mês.
     * @param saldoUltimoMes A nova lista de saldos do último mês.
     */
    public void setSaldoUltimoMes(List<Double> saldoUltimoMes) {
        this.saldoUltimoMes = saldoUltimoMes;
    }

    /**
     * Obtém o usuário que realizou a última alteração no caixa.
     * @return O usuário que realizou a última alteração no caixa.
     */
    public String getUsuarioalteracao() {
        return usuarioalteracao;
    }

    /**
     * Define o usuário que realizou a última alteração no caixa.
     * @param usuarioalteracao O novo usuário que realizou a última alteração no caixa.
     */
    public void setUsuarioalteracao(String usuarioalteracao) {
        this.usuarioalteracao = usuarioalteracao;
    }
    
    /**
     * Adiciona um valor ao saldo do caixa.
     * @param valor O valor a ser adicionado.
     * @return true se o valor foi adicionado com sucesso, false caso contrário.
     */
    public boolean adicionarSaldo(double valor) {
        if (valor < 0) {
            return false; // Não é possível adicionar um valor negativo ao saldo
        }
        this.saldo += valor;
        this.saldoUltimaSemana.add(valor);
        this.saldoUltimoMes.add(valor);
        this.usuarioalteracao = "Admin"; // Por exemplo, aqui você poderia passar o nome do usuário que realizou a alteração
        return true;
    }
    
    /**
     * Remove um valor do saldo do caixa.
     * @param valor O valor a ser removido.
     * @return true se o valor foi removido com sucesso, false caso contrário.
     */
    public boolean removerSaldo(double valor) {
        if (valor < 0 || valor > this.saldo) {
            return false; // Não é possível remover um valor negativo ou maior que o saldo atual
        }
        this.saldo -= valor;
        this.saldoUltimaSemana.add(-valor);
        this.saldoUltimoMes.add(-valor);
        this.usuarioalteracao = "Admin"; // Por exemplo, aqui você poderia passar o nome do usuário que realizou a alteração
        return true;
    }
    
    /**
     * Consulta o saldo atual do caixa.
     * @return O saldo atual do caixa.
     */
    public boolean consultarSaldo() {
        System.out.println("Saldo atual: " + this.saldo);
        return true;
    }
}