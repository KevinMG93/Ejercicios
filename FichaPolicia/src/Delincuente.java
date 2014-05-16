
public class Delincuente {
	//Falta por crear
	//Atributos para guardar
	//Tienen que ser los atributos de la pantalla
	
	private String Nombre;
	private String Apellidos;
	private int Edad;
	private int Altura;
	private String Crimen;
	
	
	public Delincuente() {
		
		Nombre="Mariano";
		Apellidos="Rajoy";
		Edad=5;
		Altura=140;
		Crimen="Robo a mano armada";	
	}
	
	public Delincuente(String Nom,String Ape,int Ed,int Altu,String Cri) {
		
	// Inicializamos
		
		Nombre=Nom;
		Apellidos=Ape;
		Edad=Ed;
		Altura=Altu;
		Crimen=Cri;
		
	}
	//Falta por crear
	//Los métodos de guardado y recuperación
	
	
	
	public void setNombre (String Nom){
	Nombre=Nom;
	}
	
	public String getNombre (){
		return Nombre;
	}
	
	public void setApellidos (String Ape){
		Apellidos=Ape;
	}
	
	public String getApellidos (){
		return Apellidos;
	}
	
	public void setEdad (int Ed){
		Edad=Ed;
	}
	
	public int getEdad (){
		return Edad;
	}
	
	public void setAltura (int Altu){
		Altura=Altu;
	}
	
	public int getAltura (){
		return Altura;
	}
	
	public void setCrimen (String Cri){
		Crimen=Cri;
	}
	
	public String getCrimen (){
		return Crimen;
	}
	
	
	//Falta por crear
	//El método toString para que aparezca en el comboBox
	
	public String toString(){
		
		// Pueden aparecer mas datos en el titulo si concatenas
		
		return Nombre;
	}

}
