package com.pedidosVenda.pedidosVenda.controllers;

import com.pedidosVenda.pedidosVenda.dtos.ItemPedidoDto;
import com.pedidosVenda.pedidosVenda.models.ItemPedidoModel;
import com.pedidosVenda.pedidosVenda.services.ItemPedidoService;

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
@RequestMapping("/ItemPedido")
public class ItemPedidoController { 

    
    @Autowired
    private ItemPedidoService ItemPedidoService;


    @PostMapping()
    public @ResponseBody ResponseEntity<Object> addItemPedido (@RequestBody @Valid ItemPedidoDto ItemPedidoDto) {

        ItemPedidoModel ItemPedidoModel = new ItemPedidoModel();
        BeanUtils.copyProperties(ItemPedidoDto, ItemPedidoModel);
        ItemPedidoService.save(ItemPedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(ItemPedidoService.save(ItemPedidoModel));
    }
    
    @GetMapping
    public ResponseEntity<List<ItemPedidoModel>> getAllItemPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(ItemPedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneItemPedido(@PathVariable(value = "id") UUID id) throws InterruptedException, FileNotFoundException{
        Optional<ItemPedidoModel> ItemPedidoModelOptional = ItemPedidoService.findById(id);
        if (!ItemPedidoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ItemPedidoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItemPedido(@PathVariable(value = "id") UUID id){
        Optional<ItemPedidoModel> ItemPedidoModelOptional = ItemPedidoService.findById(id);
        if (!ItemPedidoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        StringBuilder SucessfullMessage = new StringBuilder();
        UUID skill = ItemPedidoService.delete(ItemPedidoModelOptional.get());
        SucessfullMessage.append("Skill ").append(skill).append(" deleted successfully.");
        
         
        return ResponseEntity.status(HttpStatus.OK).body(SucessfullMessage);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchItemPedido(@PathVariable(value = "id") UUID id, @RequestBody @Valid Map<Object, Object> ItemPedidoDto){
        Optional<ItemPedidoModel> ItemPedidoModelOptional = ItemPedidoService.findById(id);
        if(!ItemPedidoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        ItemPedidoDto.forEach((key, value) ->{
            String keyName = (String) key;
            Field field = org.springframework.util.ReflectionUtils.findField(ItemPedidoModel.class,  keyName.toLowerCase());
            ReflectionUtils.setField(field, ItemPedidoModelOptional.get(), value);
        });
        var ItemPedidoModel = new ItemPedidoModel();
        BeanUtils.copyProperties(ItemPedidoModelOptional.get(), ItemPedidoModel);
        return ResponseEntity.status(HttpStatus.OK).body(ItemPedidoService.save(ItemPedidoModel));
        
    }
}
