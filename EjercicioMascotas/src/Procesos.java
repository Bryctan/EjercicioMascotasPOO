import javax.swing.JOptionPane;

public class Procesos {
	String menu ="";
	int opcion;
	Mascota mascotaAcceso;
	public Procesos() {
		mascotaAcceso = new Mascota();
		menuPrograma();
	}
	
	private void menuPrograma() {
		menu += "---------Bienvenido al programa de mascotas---------"+"\n";
		menu += "1. Registrar mascotas"+"\n";
		menu += "2. Imprimir Lista Completa"+"\n";
		menu += "3. Consultar mascota"+"\n";
		menu += "4. Actualizar mascota"+"\n";
		menu += "5. Salir"+"\n";
		
		do {
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch (opcion) {
		case 1:
			mascotaAcceso.ingresarMascota();
			break;
		case 2:
			if (!mascotaAcceso.retornarHashMap().isEmpty()) {
				mascotaAcceso.imprimirListaCompleta();
			} else 
			{
				JOptionPane.showMessageDialog(null, "No hay mascota registradas","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 3:
			if (!mascotaAcceso.retornarHashMap().isEmpty()) {
				mascotaAcceso.consultarMascota();
			} else 
			{
			JOptionPane.showMessageDialog(null, "No hay mascota registradas","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 4:
			if (!mascotaAcceso.retornarHashMap().isEmpty()) {
				mascotaAcceso.actualizarMascota();
			} else 
			{
				JOptionPane.showMessageDialog(null, "No hay mascota registradas","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 5:
			JOptionPane.showMessageDialog(null,"¡Gracias por usar el programa!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "¡Opcion invalida!");
			break;
		}
		} while (opcion != 5);
		
	}
	
	
}
