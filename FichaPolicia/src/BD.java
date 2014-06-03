import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;


public class BD {
	
	
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultadoslk´
	JComboBox <Delincuente> listadoDelincuentes;

	
		public BD(JComboBox <Delincuente> delincuentes) {
			// TODO Auto-generated constructor stub
			crearConexion();
			// Sirve para que pueda ver el comboBox
			this.listadoDelincuentes=delincuentes;
	}

		private void crearConexion(){
			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/fichapolicial","root","tonphp");
			
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch
		
	
		}
	
		
		public void leerDelincuentes (){
			
			try {
			// crea objeto Statement para consultar la base de datos
				instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
				conjuntoResultados = instruccion.executeQuery("SELECT * FROM fichadelincuentes");
			//Mostrar por pantalla
				while (conjuntoResultados.next())
				{
				System.out.println("id="+conjuntoResultados.getObject("idDelincuentes")+
				", Nombre="+conjuntoResultados.getObject("Nombre"));
				
				//Muestra el contenido de delincuentes de nuestra base de datos
					Delincuente D =new Delincuente
					//Coje los datos para mostrarlos
					((int)conjuntoResultados.getObject("IdDelincuentes"),
					(String)conjuntoResultados.getObject("Nombre"),
					(String)conjuntoResultados.getObject("Apellidos"),
					(int)conjuntoResultados.getObject("Edad"),
					(int)conjuntoResultados.getObject("Altura"),
					(String)conjuntoResultados.getObject("Crimen"));
					listadoDelincuentes.addItem(D);
				
				}
				conjuntoResultados.close();
				
			
			}catch( SQLException excepcionSql ){
				excepcionSql.printStackTrace();
			}// fin de catch
		
			}
	
		public void insertarDelincuentes (String Nombre,String Apellidos,int Edad,int Altura,String Crimen){
			
			// crea objeto Statement para consultar la base de datos
			try {
				instruccion = (Statement) conexion.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// insercion en base de datos
			try {
				String sql="INSERT INTO `fichapolicial`.`fichadelincuentes` ( Nombre, Apellidos, Edad, Altura, Crimen) VALUES ("
				//+ "'"+idDelincuentes+"',"
				+ "'"+Nombre+"',"
				+ "'"+Apellidos+"',"
				+ "'"+Edad+"',"
				+ "'"+Altura+"'," 
				+ "'"+Crimen+"');";
				
				
				instruccion.executeUpdate(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Compruebo la insercion
		
			//listadoDelincuentes.removeAllItems();
			//leerDelincuentes(listadoDelincuentes);
		
		}
		
		public void modificarDelincuentes (int ID,String Nombre,String Apellidos,int Edad,int Altura,String Crimen){
			
		// crea objeto Statement para consultar la base de datos
			try {
			instruccion = (Statement) conexion.createStatement();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			// insercion en base de datos
				try {
					
				String sql= " UPDATE  `fichapolicial`.`fichadelincuentes` SET " 
						
				+ "'Nombre' =  '"+Nombre+"',"
				+ "'Apellidos = '"+Apellidos+"',"
				+ "'Edad =  '"+Edad+"',"
				+ "'Altura =  '"+Altura+"',"
				+ "'Crimen =  '"+Crimen+"'" +
				" WHERE  `fichadelincuentes`.`ID` ="+ID+"";

				instruccion.executeUpdate(sql);
							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			//Compruebo la insercion
					
			//listadoDelincuentes.removeAllItems();
			//leerDelincuentes(listadoDelincuentes);
						
			}
	
	}
	
	
	
	
	


