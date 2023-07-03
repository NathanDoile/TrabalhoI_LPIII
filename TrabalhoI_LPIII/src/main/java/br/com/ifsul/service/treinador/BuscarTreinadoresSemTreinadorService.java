package br.com.ifsul.service.treinador;

import br.com.ifsul.domain.Treinador;
import br.com.ifsul.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTreinadoresSemTreinadorService {

    @Autowired
    private TreinadorRepository treinadorRepository;

    public List<Treinador> semTreinador(Treinador treinador){
        return treinadorRepository.findAllByIdNotIn(List.of(treinador.getId()));
    }
}
