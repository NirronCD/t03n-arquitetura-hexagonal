package com.fag.lucasmartins.arquitetura_software.core.domain.bo;


import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {
    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        validarCpf(cpf);
        validarMaioridade(dataNascimento);
        validarEmail(email);
        validarTelefone(telefone);

        this.id = id != null ? id : UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    private void validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new DomainException("CPF obrigatório e com tamanho exatamente 11.");
        }
    }

    private void validarMaioridade(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            throw new DomainException("Data de nascimento é obrigatória.");
        }
        if (Period.between(dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new DomainException("Idade mínima de 18 anos.");
        }
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new DomainException("E-mail: obrigatório e com formato básico (conter \"@\").");
        }
    }

    private void validarTelefone(String telefone) {
        if (telefone == null || telefone.length() != 11 || !telefone.matches("\\d{11}")) {
            throw new DomainException("Telefone: exatamente 11 caracteres (apenas dígitos).");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}