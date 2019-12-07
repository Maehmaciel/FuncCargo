
package Modelo.Negocio;

import java.util.ArrayList;
import java.util.List;


public class Cargo {
    private int id;
    private String cargo;
    private int salario;
    private List<Funcionario> funcionario;

    public Cargo() {
        this.funcionario = new ArrayList();
    }
    
    
    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        
        this.funcionario = funcionario;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    
}
