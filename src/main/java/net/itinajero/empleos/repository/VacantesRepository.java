package net.itinajero.empleos.repository;

import net.itinajero.empleos.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacantesRepository  extends JpaRepository<Vacante, Integer> {
    List<Vacante> findByEstatus(String estatus);

    List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);

    List<Vacante> findBySalarioBetween(double s1, double s2);

    List<Vacante> findByEstatusIn(String[] estatus);
}
