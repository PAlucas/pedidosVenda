package com.pedidosVenda.pedidosVenda.controllers;

import com.pedidosVenda.pedidosVenda.Classes.Cliente;
import com.pedidosVenda.pedidosVenda.dtos.ClienteDto;
import com.pedidosVenda.pedidosVenda.models.ClienteModel;
import com.pedidosVenda.pedidosVenda.services.ClienteService;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Cliente")
public class ClienteController { 

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> saveUser (@RequestBody @Valid ClienteDto clienteDto) throws ParseException {

        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setStatus((clienteDto.getStatus().equals("") ? 0 : 1));
        clienteModel.setLimiteCartao(Double.parseDouble(clienteDto.getLimiteCartao()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCliente(@PathVariable(value = "id") UUID id) throws InterruptedException, FileNotFoundException{
        Optional<ClienteModel> ClienteModelOptional = clienteService.findById(id);
        if (!ClienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ClienteModelOptional.get());
    }

    @GetMapping("/Cartao/{id}") 
    public ResponseEntity<Object> cartaoValidado(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id nao identificado no banco dedos");
        }
        Cliente cliente = new Cliente(null, null, 0, null, false, 0, null);
        cliente.setCartaoCredito(clienteModelOptional.get().getCartaoCredito());
        return ResponseEntity.status(HttpStatus.OK).body(cliente.validaCartao());
    }

    @GetMapping("/Idade/{id}")
    public ResponseEntity<Object> getIdadeCliente(@PathVariable(value = "id") UUID id) throws InterruptedException, FileNotFoundException, ParseException{
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id nao identificado no banco dedos");
        }
        Cliente cliente = new Cliente(null, null, 0, null, false, 0, null);
        
        BeanUtils.copyProperties(clienteModelOptional, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente.calcularIdade());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> ClienteModelOptional = clienteService.findById(id);
        if (!ClienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        StringBuilder SucessfullMessage = new StringBuilder();
        UUID skill = clienteService.delete(ClienteModelOptional.get());
        SucessfullMessage.append("Skill ").append(skill).append(" deleted successfully.");
        
         
        return ResponseEntity.status(HttpStatus.OK).body(SucessfullMessage);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchCliente(@PathVariable(value = "id") UUID id, @RequestBody @Valid Map<Object, Object> ClienteDto){
        Optional<ClienteModel> ClienteModelOptional = clienteService.findById(id);
        if(!ClienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found in data base");
        }
        ClienteDto.forEach((key, value) ->{
            String keyName = (String) key;
            Field field = org.springframework.util.ReflectionUtils.findField(ClienteModel.class,  keyName.toLowerCase());
            ReflectionUtils.setField(field, ClienteModelOptional.get(), value);
        });
        var ClienteModel = new ClienteModel();
        BeanUtils.copyProperties(ClienteModelOptional.get(), ClienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(ClienteModel));
        
    }
}
