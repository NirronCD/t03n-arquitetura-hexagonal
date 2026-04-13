package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {

    public static PessoaEntity toEntity(PessoaBO bo) {
        return new PessoaEntity(
                bo.getId(),
                bo.getNomeCompleto(),
                bo.getCpf(),
                bo.getDataNascimento(),
                bo.getEmail(),
                bo.getTelefone()
        );
    }

    public static PessoaBO toBO(PessoaEntity entity) {
        return new PessoaBO(
                entity.getId(),
                entity.getNomeCompleto(),
                entity.getCpf(),
                entity.getDataNascimento(),
                entity.getEmail(),
                entity.getTelefone()
        );
    }
}