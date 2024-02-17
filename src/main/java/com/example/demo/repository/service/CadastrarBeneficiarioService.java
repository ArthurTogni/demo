package com.example.demo.repository.service;

import com.example.demo.model.dto.CadastrarBeneficiarioDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.example.demo.model.Beneficiario;
import com.example.demo.repository.CadastrarBeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CadastrarBeneficiarioService{

    @Autowired
    private CadastrarBeneficiarioRepository cadastrarBeneficiarioRepository;

    @HystrixCommand(threadPoolKey = "getByIdThreadPool")
    public Beneficiario getByid(Long id){
        return cadastrarBeneficiarioRepository.findById(id).orElse(new Beneficiario());
    }

    public Beneficiario cadastrarBeneficiario(CadastrarBeneficiarioDTO cadastrarBeneficiarioDTO){

        long currentTimestampMillis = Instant.now().toEpochMilli();
        Timestamp timeNow = new Timestamp(currentTimestampMillis);
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNome(cadastrarBeneficiarioDTO.getNome());
        beneficiario.setTelefone(cadastrarBeneficiarioDTO.getTelefone());
        beneficiario.setDataNascimento(cadastrarBeneficiarioDTO.getDataNascimento());
        beneficiario.setDataInclusao(timeNow);
        cadastrarBeneficiarioRepository.save(beneficiario);

        return beneficiario;
    }


}
