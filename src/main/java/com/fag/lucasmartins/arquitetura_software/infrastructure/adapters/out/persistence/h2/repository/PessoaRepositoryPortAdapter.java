package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;


import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper.PessoaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryPortAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository jpaRepository;

    public PessoaRepositoryPortAdapter(PessoaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        PessoaEntity entity = PessoaMapper.toEntity(pessoaBO);


        PessoaEntity savedEntity = jpaRepository.save(entity);

        return PessoaMapper.toBO(savedEntity);
    }

    @Override
    public Optional<PessoaBO> buscarPorId(UUID id) {
        return jpaRepository.findById(id).map(PessoaMapper::toBO);
    }

    @Override
    public List<PessoaBO> listarTodas() {
        return jpaRepository.findAll()
                .stream()
                .map(PessoaMapper::toBO)
                .collect(Collectors.toList());
    }
}