package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaControllerAdapter {

    private final PessoaServicePort servicePort;

    public PessoaControllerAdapter(PessoaServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> cadastrar(@RequestBody PessoaRequestDTO requestDTO) {
        PessoaBO bo = PessoaDTOMapper.toBO(requestDTO);
        PessoaBO cadastrado = servicePort.cadastrar(bo);
        return ResponseEntity.status(HttpStatus.CREATED).body(PessoaDTOMapper.toDTO(cadastrado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarPorId(@PathVariable UUID id) {
        PessoaBO bo = servicePort.buscarPorId(id);
        return ResponseEntity.ok(PessoaDTOMapper.toDTO(bo));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listarTodas() {
        List<PessoaResponseDTO> pessoas = servicePort.listarTodas()
                .stream()
                .map(PessoaDTOMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pessoas);
    }
}