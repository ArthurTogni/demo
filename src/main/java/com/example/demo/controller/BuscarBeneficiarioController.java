package com.example.demo.controller;

import com.example.demo.model.Beneficiario;
import com.example.demo.repository.service.CadastrarBeneficiarioService;
import com.example.demo.repository.service.CadastrarDocumentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/buscar-beneficiario")
@Api(value = "Buscar Beneficiario", tags = "Buscar Beneficiario")
public class BuscarBeneficiarioController {

    @Autowired
    private CadastrarBeneficiarioService cadastrarBeneficiarioService;

    @ApiOperation(value = "Retorna o beneficiario pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o pedido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Beneficiario> findAllBeneficiarios(){
        return cadastrarBeneficiarioService.getFindAllBeneficiarios();
    }

}
