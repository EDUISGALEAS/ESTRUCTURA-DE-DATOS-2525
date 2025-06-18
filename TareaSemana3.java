package ec.uea.tareasemana3;

public class TareaSemana3 {

    /* Manejar el registro de un estudiante que posea los siguientes datos
       (id, nombres, apellidos, dirección y tres teléfonos). */
    
    public static void main(String[] args) {
        String[] telefonos = {"0986258571", "3016789", "0989345033"};

        // Creamos un objeto llamado estudiante que pertenece a la clase Estudiante
        Arrays estudiantes = new Arrays(1721297255, "Eduardo", "Galeas", "Vargas", telefonos);
        estudiantes.mostrarDatos();
    }
}
