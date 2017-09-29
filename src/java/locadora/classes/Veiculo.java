/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolocadoracarros.classes;

/**
 *
 * @author gaoli_000
 */
public class Veiculo {
    
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String descricao;
    private boolean arCondicionado;
    private boolean vidroEletrico;
    private boolean travaEletrica;
    private boolean cambioAutomatico;
    private boolean alugado;
    
    public Veiculo(){
        
    }

    public Veiculo(int id, String placa, String marca, String modelo, String cor, String descricao, boolean arCondicionado, boolean vidroEletrico, boolean travaEletrica, boolean cambioAutomatico) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.descricao = descricao;
        this.arCondicionado = arCondicionado;
        this.vidroEletrico = vidroEletrico;
        this.travaEletrica = travaEletrica;
        this.cambioAutomatico = cambioAutomatico;
        this.alugado = false;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public boolean isVidroEletrico() {
        return vidroEletrico;
    }

    public boolean isTravaEletrica() {
        return travaEletrica;
    }

    public boolean isCambioAutomatico() {
        return cambioAutomatico;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public void setVidroEletrico(boolean vidroEletrico) {
        this.vidroEletrico = vidroEletrico;
    }

    public void setTravaEletrica(boolean travaEletrica) {
        this.travaEletrica = travaEletrica;
    }

    public void setCambioAutomatico(boolean cambioAutomatico) {
        this.cambioAutomatico = cambioAutomatico;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
    
    
    
}
