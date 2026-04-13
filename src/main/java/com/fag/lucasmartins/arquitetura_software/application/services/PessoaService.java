package com.fag.lucasmartins.arquitetura_software.application.services;


import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort repositoryPort;

    public PessoaService(PessoaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public PessoaBO cadastrar(PessoaBO pessoaBO) {
        return repositoryPort.salvar(pessoaBO);
    }

    @Override
    public PessoaBO buscarPorId(UUID id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new DomainException("Pessoa não foi encontrada."));
    }

    @Override
    public List<PessoaBO> listarTodas() {
        return repositoryPort.listarTodas();
    }
}