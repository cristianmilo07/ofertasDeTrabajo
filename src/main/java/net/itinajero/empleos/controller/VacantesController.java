package net.itinajero.empleos.controller;

import net.itinajero.empleos.model.Vacante;
import net.itinajero.empleos.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacanteService serviceVacantes;

    @GetMapping("/create")
    public String crear() {
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante){
        serviceVacantes.guardar(vacante);
        System.out.println("Vacante: " + vacante );
        return "vacantes/listVacantes";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam ("id")  int idVacante, Model model ){
        System.out.println("Borarando vacante con id:" + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model){
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        System.out.println("Vacante" + vacante);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
