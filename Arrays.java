package TareaSemana3;

// Atributos o propiedades 
public class Arrays {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String[] telefonos;

    // Constructor que recibe los datos y los guarda en los atributos
    public Arrays(int id, String nombre, String apellido, String direccion, String[] telefonos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    // Método para mostrar los datos del estudiante
    public void mostrarDatos() {
        System.out.println("===== DATOS DEL ESTUDIANTE =====");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Dirección: " + direccion);
        System.out.print("Teléfonos: ");
        for (String tel : telefonos) {
            System.out.print(tel + " ");
        }
        System.out.println("\n===============================");
    }
}
