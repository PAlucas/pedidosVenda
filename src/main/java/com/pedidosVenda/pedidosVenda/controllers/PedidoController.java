package com.pedidosVenda.pedidosVenda.controllers;

import com.pedidosVenda.pedidosVenda.dtos.PedidoDto;
import com.pedidosVenda.pedidosVenda.models.PedidoModel;
import com.pedidosVenda.pedidosVenda.services.PedidoService;

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
@RequestMapping("/Pedido")
public class PedidoController { 

    
    @Autowired
    private PedidoService PedidoService;


    @PostMapping()
    public @ResponseBody ResponseEntity<Object> addNewUser (@RequestBody @Valid PedidoDto PedidoDto) {

        PedidoModel PedidoModel = new PedidoModel();
        BeanUtils.copyProperties(PedidoDto, PedidoModel);
        PedidoService.save(PedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoService.save(PedidoModel));
    }
    
    @GetMapping
    public ResponseEntity<List<PedidoModel>> getAllPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(PedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) throws InterruptedException, FileNotFoundException{
        Optional<PedidoModel> PedidoModelOptional = PedidoService.findById(id);
        if (!PedidoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        return ResponseEntity.status(HttpStatus.OK).body(PedidoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id){
        Optional<PedidoModel> PedidoModelOptional = PedidoService.findById(id);
        if (!PedidoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        StringBuilder SucessfullMessage = new StringBuilder();
        UUID skill = PedidoService.delete(PedidoModelOptional.get());
        SucessfullMessage.append("Skill ").append(skill).append(" deleted successfully.");
        
         
        return ResponseEntity.status(HttpStatus.OK).body(SucessfullMessage);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchSkill(@PathVariable(value = "id") UUID id, @RequestBody @Valid Map<Object, Object> PedidoDto){
        Optional<PedidoModel> PedidoModelOptional = PedidoService.findById(id);
        if(!PedidoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        PedidoDto.forEach((key, value) ->{
            String keyName = (String) key;
            Field field = org.springframework.util.ReflectionUtils.findField(PedidoModel.class,  keyName.toLowerCase());
            ReflectionUtils.setField(field, PedidoModelOptional.get(), value);
        });
        var PedidoModel = new PedidoModel();
        BeanUtils.copyProperties(PedidoModelOptional.get(), PedidoModel);
        return ResponseEntity.status(HttpStatus.OK).body(PedidoService.save(PedidoModel));
        
    }
}
