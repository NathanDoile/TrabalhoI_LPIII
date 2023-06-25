package br.com.ifsul.service;

import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Service
public class BuscarTreinadorService {

    @Autowired
    private TreinadorRepository treinadorRepository;

    public Treinador porId(Long id) {
        return treinadorRepository.findById(id).orElseThrow(()->
            new RuntimeException("Não foi possível buscar o treinador.")
        );
    }

}
