import java.util.HashMap;

import javax.swing.JOptionPane;

public class Mascota {
	HashMap<String, Mascota> mapaMascotas;
	String nombre,especie,id;
	int cantidadMascotas, edad;
	boolean estadoMascota = false;
	
	
	public Mascota () {
		mapaMascotas = new HashMap<String, Mascota>();
	}
	
	public Mascota (String id, String nombre, int edad, String especie) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.especie = especie;
	}
	
	
	public void mostrarInformacion () {
		System.out.println("ID mascota:"+ id);
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Especie: " + especie);
		
	}
	
	public void hacerSonido () {
		
		if (especie.equalsIgnoreCase("Perro")) {
			System.out.println("¡Guau guau!");
		}
		else if (especie.equalsIgnoreCase("gato")) {
			System.out.println("¡Miau Miau!");
		}
		
	}
	
	public void ingresarMascota () {
		
		cantidadMascotas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mascotas"));
		
		Mascota mascota;
		
		for (int i = 0; i < cantidadMascotas; i++) {
			id = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota");
			nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota");
			edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota"));
			especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota");
			mascota = new Mascota(id, nombre, edad, especie);
			mapaMascotas.put(id, mascota);
		}
	}
	
	public void consultarMascota () {
		
		String buscarId = JOptionPane.showInputDialog("Ingrese el documento de la mascota a buscar");
		Mascota mascotaTemporal;
		boolean encontrado = false;
		for (String id : mapaMascotas.keySet()) {
			if (id.equalsIgnoreCase(buscarId)) {
				mascotaTemporal = mapaMascotas.get(id);
				mascotaTemporal.mostrarInformacion();
				mascotaTemporal.estadoMascota();
				mascotaTemporal.jugarMascota();
				mascotaTemporal.estadoMascota();
				encontrado = true;
			} 
		}
		
		if (!encontrado) {
			System.out.println("No se encuentra registrado la mascota con identificacion: "+ buscarId);
		}
			
	}
	
	public void imprimirListaCompleta () {
		for (Mascota mascota : mapaMascotas.values()) {
			System.out.println("---------Informacion Mascota------------");
			mascota.mostrarInformacion();
			System.out.println("-----------------------------------------");
		}
	}
	
	public void actualizarMascota() {
		
		String buscarId = JOptionPane.showInputDialog("Ingrese el documento de la mascota actualizar");
		
		Mascota mascotaTemporal;
		
		for (String id : mapaMascotas.keySet()) {
			if (id.equalsIgnoreCase(buscarId)) {
				mascotaTemporal = mapaMascotas.get(id);
				String menu = "Que desea actualizar de la mascota"+"\n";
				menu += "1. nombre"+"\n";
				menu += "2. edad"+"\n";
				menu += "3. especie"+"\n";
				
				int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
				switch (opcion) {
				case 1:
					String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre para la mascota");
					mascotaTemporal.nombre = nuevoNombre;
					break;
				case 2:
					int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad de la mascota"));
					mascotaTemporal.edad = edad;
					break;
				case 3:
					String especie = JOptionPane.showInputDialog("Ingrese la nueva especie la mascota");
					mascotaTemporal.especie = especie;
					break;

				default:
					System.out.println("Opcion invalida");
					break;
				}
				
				break;
			} else {
				System.out.println("No se encuentra registrado la mascota con identificacion: "+ buscarId);
			}
			
		}
		
	}
	
	private void jugarMascota() {
		estadoMascota = true;
		System.out.println("Estoy jugando con mi mascota "+ nombre);

	}
	
	
	private void estadoMascota() {
		if (estadoMascota == false) {
			System.out.println("¡Tu mascota esta triste debes jugar con ella!");
		} else {
			System.out.println("¡Tu mascota esta feliz junto a tu lado!");
		}

	}
	
	public HashMap<String, Mascota> retornarHashMap() {
		return mapaMascotas;
	}
	
	
	
}
