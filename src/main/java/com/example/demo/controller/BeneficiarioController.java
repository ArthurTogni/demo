package com.example.demo.controller;

import com.example.demo.model.Beneficiario;
import com.example.demo.model.dto.CadastrarBeneficiarioDTO;
import com.example.demo.repository.service.CadastrarBeneficiarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastrar-beneficiario")
public class BeneficiarioController {

    @Autowired
    private CadastrarBeneficiarioService cadastrarBeneficiarioService;

    @ApiOperation(value = "Retorna o beneficiario pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o pedido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces="application/json")
    public Beneficiario findBeneficiario(@PathVariable("id") Long id){
        return cadastrarBeneficiarioService.getByid(id);

    }

    @ApiOperation(value = "Realiza um cadastro de beneficiario" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o pedido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public Beneficiario realizaCompra(@RequestBody CadastrarBeneficiarioDTO cadastrarBeneficiarioDTO) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return cadastrarBeneficiarioService.cadastrarBeneficiario(cadastrarBeneficiarioDTO);
    }

}
