package br.com.ifsul.service;

import br.com.ifsul.domain.Treinador;
import br.com.ifsul.domain.enums.Sexo;
import br.com.ifsul.repository.TreinadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarTreinadorService {

    @Autowired
    private TreinadorRepository treinadorRepository;

    @Transactional
    public Treinador criarTreinador(String nome, Sexo sexo) {
        Treinador treinador = Treinador
                .builder()
                .nome(nome)
                .sexo(sexo)
                .build();
        treinadorRepository.save(treinador);
        return treinador;
    }
}
