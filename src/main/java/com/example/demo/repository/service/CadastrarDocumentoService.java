package com.example.demo.repository.service;

import com.example.demo.model.Documento;
import com.example.demo.model.dto.CadastrarDocumentoDTO;
import com.example.demo.repository.CadastrarDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CadastrarDocumentoService {

    @Autowired
    private CadastrarDocumentoRepository cadastrarDocumentoRepository;

    public Documento getById(Long id){
        return cadastrarDocumentoRepository.findById(id).orElse(new Documento());
    }

    public Documento cadastrarDocumento(CadastrarDocumentoDTO cadastrarDocumentoDTO){

        long currentTimestampMillis = Instant.now().toEpochMilli();
        Timestamp timeNow = new Timestamp(currentTimestampMillis);
        Documento documento = new Documento();
        documento.setTipoDocumento(cadastrarDocumentoDTO.getTipoDocumento());
        documento.setDescricao(cadastrarDocumentoDTO.getDescricao());
        documento.setDatainclusao(timeNow);
        cadastrarDocumentoRepository.save(documento);

        return documento;
    }
    public Documento atualizarDocumento(CadastrarDocumentoDTO cadastrarDocumentoDTO){

        long currentTimestampMillis = Instant.now().toEpochMilli();
        Timestamp timeNow = new Timestamp(currentTimestampMillis);
        Documento documento = new Documento();
        documento.setTipoDocumento(cadastrarDocumentoDTO.getTipoDocumento());
        documento.setDescricao(cadastrarDocumentoDTO.getDescricao());
        documento.setDataAtualizacao(timeNow);
        cadastrarDocumentoRepository.save(documento);

        return documento;
    }

    public void excluirDocumento(Documento documento){
        cadastrarDocumentoRepository.delete(documento);
    }


}
