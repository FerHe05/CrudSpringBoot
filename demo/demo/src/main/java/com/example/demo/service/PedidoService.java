package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus("Aberto");
        return repository.save(pedido);
    }

    public List<Pedido> listarPedidos(String status) {
        return repository.findByStatus(status);
    }

    public Optional<Pedido> atualizarStatus(Long id, String status) {
        Optional<Pedido> pedido = repository.findById(id);
        pedido.ifPresent(p -> {
            p.setStatus(status);
            repository.save(p);
        });
        return pedido;
    }

    public void excluirPedido(Long id) {
        repository.deleteById(id);
    }
}
