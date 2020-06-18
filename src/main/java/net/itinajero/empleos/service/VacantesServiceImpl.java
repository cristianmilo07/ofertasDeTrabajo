package net.itinajero.empleos.service;

import net.itinajero.empleos.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantesServiceImpl implements  IVacanteService{

    private List<Vacante> lista = null;

    public VacantesServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<Vacante>();
        try {
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero civil");
            vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("08-02-2020"));
            vacante1.setSalario(8500.0);
            vacante1.setDestacado(1);

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador publico");
            vacante2.setDescripcion("Solicitamos Contador publico");
            vacante2.setFecha(sdf.parse("15-07-2020"));
            vacante2.setSalario(12200.0);
            vacante2.setDestacado(0);

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Eléctrico");
            vacante3.setDescripcion("Solicitamos Ingeniero Eléctrico");
            vacante3.setFecha(sdf.parse("25-12-2020"));
            vacante3.setSalario(12200.0);
            vacante3.setDestacado(1);

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);

        } catch (ParseException e) {
            System.out.print("Error" + e.getMessage());
        }

    }


    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {

        for (Vacante v: lista){
            if(v.getId()==idVacante){
                return v;
            }
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        lista.add(vacante);
    }
}
