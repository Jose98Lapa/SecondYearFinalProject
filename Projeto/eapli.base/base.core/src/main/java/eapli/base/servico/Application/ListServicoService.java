package eapli.base.servico.Application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.base.servico.domain.Servico;

import java.util.ArrayList;

public class ListServicoService {
    private final ServicoRepository repo = PersistenceContext.repositories().servico();

    public ArrayList<ServicoDTO> IncompleteServicos() {
        ArrayList<ServicoDTO> serv = new ArrayList<>();
        for (Servico ser : repo.incompleteServico()) {
            serv.add(ser.toDTO());
        }
        return serv;
    }

    public ArrayList<ServicoDTO> allServices() {
        ArrayList<ServicoDTO> serv = new ArrayList<>();
        for (Servico ser : repo.findAll()) {
            serv.add(ser.toDTO());
        }
        return serv;
    }

    public Iterable<ServicoDTO> all() {
        ArrayList<ServicoDTO> serv = new ArrayList<>();
        for (Servico ser : repo.findAll()) {
            serv.add(ser.toDTO());
        }
        return  serv;
    }
}
