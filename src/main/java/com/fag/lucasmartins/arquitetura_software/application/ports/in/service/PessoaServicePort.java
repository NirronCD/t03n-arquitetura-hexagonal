package com.fag.lucasmartins.arquitetura_software.application.ports.in.service;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import java.util.List;
import java.util.UUID;

public interface PessoaServicePort {
    PessoaBO cadastrar(PessoaBO pessoaBO);
    PessoaBO buscarPorId(UUID id);
    List<PessoaBO> listarTodas();
}