package net.itinajero.empleos.repository;

import net.itinajero.empleos.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
}
