package com.gfive.pacientes.workflow.reportes;

import java.util.Optional;

import com.gfive.pacientes.negocio.Almacen;
import com.gfive.pacientes.negocio.Medico;

/**
 * Flujo de trabajos del reporte que lista los pacientes por m�dico.
 * @author nicolas
 *
 */
public class WorkflowPacientesPorMedico implements Runnable {

    @Override
    public void run() {
        final Optional<Medico> medico = Almacen.instancia.obtenerMedico();
        if (!medico.isPresent())
            return;
        System.out.println("::: El medico " + medico.get().nombre + " atiende a los siguientes pacientes: ");
        
        Almacen.instancia.obtenerSituaciones(situacion -> situacion.medico.equals(medico.get()))
                         .forEach(situacion -> System.out.println(situacion.paciente));
    }

}
