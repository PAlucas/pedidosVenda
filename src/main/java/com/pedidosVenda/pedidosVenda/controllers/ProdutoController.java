package com.pedidosVenda.pedidosVenda.controllers;

import com.pedidosVenda.pedidosVenda.dtos.ProdutoDto;
import com.pedidosVenda.pedidosVenda.models.ProdutoModel;
import com.pedidosVenda.pedidosVenda.services.ProdutoService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Produto")
public class ProdutoController { 

    
    @Autowired
    private ProdutoService produtoService;


    @PostMapping()
    public @ResponseBody ResponseEntity<Object> addProduto (@RequestBody @Valid ProdutoDto ProdutoDto) {
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(ProdutoDto, produtoModel);
        produtoModel.setPreco(Double.parseDouble(ProdutoDto.getPreco()));
        produtoModel.setQtdeDisponivel(Integer.parseInt(ProdutoDto.getQtdeDisponivel()));
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoModel));
    }
    
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> ConsultaProduto(@PathVariable(value = "id") UUID id) throws InterruptedException, FileNotFoundException{
        Optional<ProdutoModel> ProdutoModelOptional = produtoService.findById(id);
        if (!ProdutoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao localizado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ProdutoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") UUID id){
        Optional<ProdutoModel> ProdutoModelOptional = produtoService.findById(id);
        if (!ProdutoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao localizado");
        }
        StringBuilder SucessfullMessage = new StringBuilder();
        UUID skill = produtoService.delete(ProdutoModelOptional.get());
        SucessfullMessage.append("Skill ").append(skill).append(" deleted successfully.");
        
         
        return ResponseEntity.status(HttpStatus.OK).body(SucessfullMessage);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchProduto(@PathVariable(value = "id") UUID id, @RequestBody @Valid Map<Object, Object> ProdutoDto){
        Optional<ProdutoModel> ProdutoModelOptional = produtoService.findById(id);
        if(!ProdutoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao localizado");
        }
        ProdutoDto.forEach((key, value) ->{
            String keyName = (String) key;
            Field field = org.springframework.util.ReflectionUtils.findField(ProdutoModel.class,  keyName.toLowerCase());
            ReflectionUtils.setField(field, ProdutoModelOptional.get(), value);
        });
        var ProdutoModel = new ProdutoModel();
        BeanUtils.copyProperties(ProdutoModelOptional.get(), ProdutoModel);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(ProdutoModel));
        
    }
}
