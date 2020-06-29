package net.itinajero.empleos.service;

import net.itinajero.empleos.model.Categoria;

import java.util.List;

public interface ICategoriasService {
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);
    void guardar(Categoria categoria);
}
