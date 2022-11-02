package br.com.alura.comex.cliente.dto;

import br.com.alura.comex.cliente.model.Cliente;

public class ClienteOutputDto {

    private String nome;
    private String cpf;
    private String telefone;
    private String local;

    public ClienteOutputDto() {
    }

    public ClienteOutputDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.local = cliente.getRua() + ", Nº " +
                        cliente.getNumero() + ", " +
                        cliente.getComplemento() + ", " +
                        cliente.getBairro() + ", " +
                        cliente.getCidade() + ", " +
                        cliente.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
