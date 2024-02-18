package com.example.demo.controller;

import com.example.demo.model.Beneficiario;
import com.example.demo.model.Documento;
import com.example.demo.repository.service.CadastrarBeneficiarioService;
import com.example.demo.repository.service.CadastrarDocumentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excluir-beneficiario")
@Api(value = "Excluir Beneficiario", tags = "Excluir Beneficiario")
public class DeletarBeneficiarioController {

    @Autowired
    private CadastrarBeneficiarioService cadastrarBeneficiarioService;

    @Autowired
    private CadastrarDocumentoService cadastrarDocumentoService;


    @ApiOperation(value = "Realiza um cadastro de beneficiario" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o pedido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public String excluirBeneficiarioDocumento(@RequestBody Long id) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Beneficiario beneficiario = new Beneficiario();
        Documento documento = new Documento();

        beneficiario = cadastrarBeneficiarioService.getByid(id);
        documento = cadastrarDocumentoService.getById(id);

        cadastrarBeneficiarioService.excluirBeneficiario(beneficiario);
        cadastrarDocumentoService.excluirDocumento(documento);
        return "Beneficiario Excluido";
    }
}
