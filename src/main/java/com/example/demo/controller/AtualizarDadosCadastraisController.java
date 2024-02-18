package com.example.demo.controller;

import com.example.demo.model.dto.AtualizarBeneficiarioDocumentoDTO;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atualizar-documento-beneficiario")
@Api(value = "Atualizar Documento Beneficiario", tags = "Atualizar Documento Beneficiario")
public class AtualizarDadosCadastraisController {

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
    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public AtualizarBeneficiarioDocumentoDTO atualizarBeneficiarioDocumento(@RequestBody AtualizarBeneficiarioDocumentoDTO atualizarBeneficiarioDocumentoDTO) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CadastrarBeneficiarioDTO cadastrarBeneficiarioDTO = new CadastrarBeneficiarioDTO();
        CadastrarDocumentoDTO cadastrarDocumentoDTO = new CadastrarDocumentoDTO();

        cadastrarBeneficiarioDTO.setId(atualizarBeneficiarioDocumentoDTO.getId());
        cadastrarBeneficiarioDTO.setNome(atualizarBeneficiarioDocumentoDTO.getNome());
        cadastrarBeneficiarioDTO.setTelefone(atualizarBeneficiarioDocumentoDTO.getTelefone());

        cadastrarDocumentoDTO.setId(atualizarBeneficiarioDocumentoDTO.getId());
        cadastrarDocumentoDTO.setTipoDocumento(atualizarBeneficiarioDocumentoDTO.getTipoDocumento());
        cadastrarDocumentoDTO.setDescricao(atualizarBeneficiarioDocumentoDTO.getDescricao());

        cadastrarBeneficiarioService.atualizarBeneficiario(cadastrarBeneficiarioDTO);
        cadastrarDocumentoService.atualizarDocumento(cadastrarDocumentoDTO);
        return atualizarBeneficiarioDocumentoDTO;
    }
}
