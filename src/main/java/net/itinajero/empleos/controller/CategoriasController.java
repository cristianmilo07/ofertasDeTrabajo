package net.itinajero.empleos.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Qualifier("categoriasServiceJpa")
@RequestMapping(value = "/categorias")
public class CategoriasController {

    //@GetMapping("/index")
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String mostrarIndex(Model model){
        return "Categorias/listaCategorias";
    }

    //@GetMapping("/create")
    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String crear(){
        return "Categorias/formCategorias";
    }

    //@PostMapping("/save")
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion){
        System.out.println("Categoria " + nombre);
        System.out.println("Descripcion " + descripcion);
        return "Categorias/listaCategorias";
    }
}
