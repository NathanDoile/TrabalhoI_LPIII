package br.com.ifsul.service;

import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTreinadoresService {

    @Autowired
    private TreinadorRepository treinadorRepository;

    public List<Treinador> listarTodos() {
        return treinadorRepository.findAll();
    }

}
