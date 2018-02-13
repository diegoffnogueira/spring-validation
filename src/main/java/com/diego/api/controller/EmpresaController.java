package com.diego.api.controller;

import com.diego.api.dto.EmpresaDTO;
import com.diego.api.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @PostMapping
    public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresaDTO,
                                                          BindingResult result){
        Response<EmpresaDTO> response = new Response<>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        empresaDTO.setId(1L);
        response.setResultado(empresaDTO);
        return ResponseEntity.ok(response);
    }

}