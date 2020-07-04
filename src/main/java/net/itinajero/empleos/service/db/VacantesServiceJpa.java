package net.itinajero.empleos.service.db;

import net.itinajero.empleos.model.Vacante;
import net.itinajero.empleos.repository.VacantesRepository;
import net.itinajero.empleos.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VacantesServiceJpa implements IVacanteService {

    @Autowired
    private VacantesRepository vacantesRepo;
    @Override
    public List<Vacante> buscarTodas() {
        return vacantesRepo.findAll();
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
        Optional<Vacante> optional = vacantesRepo.findById(idVacante);
        if (optional.isPresent()){
            optional.get();
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        vacantesRepo.save(vacante);
    }
}
