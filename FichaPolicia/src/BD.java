import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BD {
	
	Connection conexion = null; //maneja la conexi�n
	Statement instruccion = null;// instrucci�n de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados

	public BD() {
		// TODO Auto-generated constructor stub
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexi�n a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			conjuntoResultados = instruccion.executeQuery("SELECT idLiga,Nombre FROM liga");
			//Mostrar por pantalla
			while (conjuntoResultados.next())
			{
			   System.out.println("id="+conjuntoResultados.getObject("idLiga")+
			      ", Nombre="+conjuntoResultados.getObject("Nombre"));
			}
			conjuntoResultados.close();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch
	}

}
