package net.itinajero.empleos.service.db;

import net.itinajero.empleos.model.Categoria;
import net.itinajero.empleos.repository.CategoriasRepository;
import net.itinajero.empleos.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primar
public class CategoriaServiceJpa implements ICategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepo;

    @Override
    public List<Categoria> buscarTodas() {
        return (List<Categoria>) categoriasRepo.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
        if (optional.isPresent()) {
            return  optional.get();
        }
        return null;
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriasRepo.save(categoria);
    }
}
