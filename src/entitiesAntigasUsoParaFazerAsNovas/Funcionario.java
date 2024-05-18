/**
 * Classe Funcionario representando a entidade do funcionário.
 */
public class Funcionario {
    public String nomeFuncionario; 
    public String cpfFuncionario; 
    public String codigoCtps; 
    public String cargo; 
    public double salario; 
    public int idFuncionario; 

    /**
     * Construtor para criar um novo objeto Funcionario.
     *
     * @param nomeFuncionario Nome do funcionário
     * @param cpfFuncionario CPF do funcionário
     * @param codigoCtps Número CTPS do funcionário
     * @param cargo Cargo do funcionário
     * @param salario Salário do funcionário
     * @param idFuncionario ID do funcionário
     */
    public Funcionario(String nomeFuncionario, String cpfFuncionario,
                       String codigoCtps, String cargo, double salario, int idFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.codigoCtps = codigoCtps;
        this.cargo = cargo;
        this.salario = salario;
        this.idFuncionario = idFuncionario;
    }

    /**
     * Obtém o nome do funcionário.
     * @return O nome do funcionário.
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * Obtém o CPF do funcionário.
     * @return O CPF do funcionário.
     */
    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    /**
     * Obtém o número da CTPS do funcionário.
     * @return O número da CTPS do funcionário.
     */
    public String getCodigoCtps() {
        return codigoCtps;
    }

    /**
     * Obtém o cargo do funcionário.
     * @return O cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Obtém o salário do funcionário.
     * @return O salário do funcionário.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Obtém o ID do funcionário.
     * @return O ID do funcionário.
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Define o nome do funcionário.
     * @param nomeFuncionario O novo nome do funcionário.
     * @return true se o nome foi definido com sucesso, false caso contrário.
     */
    public boolean setNomeFuncionario(String nomeFuncionario) {
        if (nomeFuncionario != null && !nomeFuncionario.isEmpty()) {
            this.nomeFuncionario = nomeFuncionario;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Define o CPF do funcionário.
     * @param cpfFuncionario O novo CPF do funcionário.
     * @return true se o CPF foi definido com sucesso, false caso contrário.
     */
    public boolean setCpfFuncionario(String cpfFuncionario) {
        if (cpfFuncionario != null && !cpfFuncionario.isEmpty()) {
            this.cpfFuncionario = cpfFuncionario;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Define o número da CTPS do funcionário.
     * @param codigoCtps O novo número da CTPS do funcionário.
     * @return true se o número da CTPS foi definido com sucesso, false caso contrário.
     */
    public boolean setCodigoCtps(String codigoCtps) {
        if (codigoCtps != null && !codigoCtps.isEmpty()) {
            this.codigoCtps = codigoCtps;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Define o cargo do funcionário.
     * @param cargo O novo cargo do funcionário.
     * @return true se o cargo foi definido com sucesso, false caso contrário.
     */
    public boolean setCargo(String cargo) {
        if (cargo != null && !cargo.isEmpty()) {
            this.cargo = cargo;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Define o salário do funcionário.
     * @param salario O novo salário do funcionário.
     * @return true se o salário foi definido com sucesso, false caso contrário.
     */
    public boolean setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
            return true;
        } else {
            return false;
        }
    }

     /**
     * Define o ID do funcionário.
     * @param idFuncionario O novo ID do funcionário.
     * @return true se o ID foi definido com sucesso, false caso contrário.
     */
    public boolean setIdFuncionario(int idFuncionario) {
        if (idFuncionario >= 0) {
            this.idFuncionario = idFuncionario;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Edita os detalhes deste funcionário.
     * @param nomeFuncionario O novo nome do funcionário.
     * @param cpfFuncionario O novo CPF do funcionário.
     * @param codigoCtps O novo código da CTPS do funcionário.
     * @param cargo O novo cargo do funcionário.
     * @param salario O novo salário do funcionário.
     * @param idFuncionario O novo ID di funcionário.
     * @return true se a edição foi realizada com sucesso, false caso contrário.
     */
    public boolean editarFuncionario(String nomeFuncionario, String cpfFuncionario, String codigoCtps, String cargo, double salario, int idFuncionario) {
        // Chamando os métodos setter para definir os novos valores
        return setNomeFuncionario(nomeFuncionario) &&
                setCpfFuncionario(cpfFuncionario) &&
                setCodigoCtps(codigoCtps) &&
                setCargo(cargo) &&
                setSalario(salario) &&
                setIdFuncionario(idFuncionario);
    }

    /**
     * Inativa este funcionário.
     * @return true se o funcionário foi inativado com sucesso, false caso contrário.
     */
    public boolean inativarFuncionario() {
        this.salario = 0;
        return true;
    }

    /**
     * Paga o salário deste funcionário.
     * @return true para indicar que o salário foi pago com sucesso.
     */
    public boolean pagarSalario() {
        this.salario = 1; // Define o salário como zero após o pagamento
        return true; // Retorna true para indicar que o salário foi pago com sucesso
    }
    
}