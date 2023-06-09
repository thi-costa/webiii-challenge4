package com.example.mercado.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.mercado.model.Mercado;
import com.example.mercado.repository.MercadoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MercadoService {
    private MercadoRepository repository;

    public MercadoService(MercadoRepository mercadoRepository) {
        this.repository = mercadoRepository;
    }
    public Mono<Mercado> salvar(Mercado mercado) {
        return repository.save(mercado);
    }
    public Mono<Mercado> atualizar(Mercado mercado, String id) {
        return repository.findById(id)
                .flatMap(atual -> repository.save(atual.update(mercado)));
    }
    public Mono<?> remover(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Mercado not found id" + id)))
                .flatMap(u -> repository.deleteById(id))
                .then();
    }
    public Mono<Mercado> buscarPorId(String id) {
        return repository.findById(id);
    }
    public Flux<Mercado> listarTodos() {
        return repository.findAll();
    }
    public Flux<Mercado> buscarPorNomes(String nomeMercado) {
        return repository.findMercadosByNome(nomeMercado);
    }
    public Flux<Object> cotacao(String nomeMoeda){
        WebClient webClient = WebClient.create("https://economia.awesomeapi.com.br");

        Flux<Object> cotacao = webClient.get()
            .uri(uriBuilder -> uriBuilder
                    .path("/" + nomeMoeda + "/")
                    .build())
                    .retrieve().bodyToFlux(Object.class);
        
        return cotacao;

    }
}
