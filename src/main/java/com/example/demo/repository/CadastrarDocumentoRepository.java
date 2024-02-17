package com.example.demo.repository;

import com.example.demo.model.Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastrarDocumentoRepository extends CrudRepository<Documento, Long> {
}
