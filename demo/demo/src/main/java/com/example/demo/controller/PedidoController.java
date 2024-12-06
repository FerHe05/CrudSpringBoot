package com.example.demo.controller;

import com.example.demo.model.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return service.criarPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listarPedidos(@RequestParam(required = false) String status) {
        return status != null ? service.listarPedidos(status) : service.listarPedidos("Aberto");
    }

    @PutMapping("/{id}")
    public Optional<Pedido> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return service.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id) {
        service.excluirPedido(id);
    }
}
