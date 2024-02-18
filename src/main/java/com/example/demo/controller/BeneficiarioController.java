package com.example.demo.controller;

import com.example.demo.model.Beneficiario;
import com.example.demo.model.dto.CadastrarBeneficiarioDTO;
import com.example.demo.model.dto.CadastrarDocumentoDTO;
import com.example.demo.model.dto.CadastroBeneficiarioDocumentoDTO;
import com.example.demo.repository.service.CadastrarBeneficiarioService;
import com.example.demo.repository.service.CadastrarDocumentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cadastrar-beneficiario")
@Api(value = "Beneficiario", tags = "Beneficiario")
public class BeneficiarioController {

    @Autowired
    private CadastrarBeneficiarioService cadastrarBeneficiarioService;

    @Autowired
    private CadastrarDocumentoService cadastrarDocumentoService;

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
    public CadastroBeneficiarioDocumentoDTO cadastrarBeneficiarioDocumento(@RequestBody CadastroBeneficiarioDocumentoDTO cadastroBeneficiarioDocumentoDTO) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CadastrarBeneficiarioDTO cadastrarBeneficiarioDTO = new CadastrarBeneficiarioDTO();
        CadastrarDocumentoDTO cadastrarDocumentoDTO = new CadastrarDocumentoDTO();

        cadastrarBeneficiarioDTO.setNome(cadastroBeneficiarioDocumentoDTO.getNome());
        cadastrarBeneficiarioDTO.setTelefone(cadastroBeneficiarioDocumentoDTO.getTelefone());

        cadastrarDocumentoDTO.setTipoDocumento(cadastroBeneficiarioDocumentoDTO.getTipoDocumento());
        cadastrarDocumentoDTO.setDescricao(cadastroBeneficiarioDocumentoDTO.getDescricao());

        cadastrarBeneficiarioService.cadastrarBeneficiario(cadastrarBeneficiarioDTO);
        cadastrarDocumentoService.cadastrarDocumento(cadastrarDocumentoDTO);
        return cadastroBeneficiarioDocumentoDTO;
    }

}
