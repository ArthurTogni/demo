package com.example.demo.repository;

import com.example.demo.model.Beneficiario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastrarBeneficiarioRepository extends CrudRepository<Beneficiario, Long> {

}
