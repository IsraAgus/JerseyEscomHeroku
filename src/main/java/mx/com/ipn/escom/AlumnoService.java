package mx.com.ipn.escom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST; //Post es para guardar Put es para actualizar
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/*Con esto exponemos nuesto web service*/
@Path("/alumnos") //Donde va a buscar
@Produces(MediaType.APPLICATION_JSON) //Lo que queremos que nos produzca
@Consumes(MediaType.APPLICATION_JSON) //Lo que tenemos que mandarle

public class AlumnoService {
	/*Esta clase simula la base de datos par ale sistema*/
	//Se crea un mapa donde se va a guardar el id y el alumno
	private static Map<Integer,Alumno> alumnos = new HashMap<>();
	//Se crea un bloque estatico, ayuda a cargar valores y solo se ejecutan una vez
	static {
		Alumno eduardo = 
				new Alumno(2014630510,"Israel Agustin", "Vargas Monroy","Sistemas","vargasmonroyisraelagustin@gmail.com");
	    Alumno paola = 
	    		new Alumno(2014630262,"Anayantzin Poala", "Lopez Juarez", "Sistemas","paop9503@gmail.com");
	    
	    alumnos.put(1,eduardo);
	    alumnos.put(2, paola);
	}
	
	/**
	 *Este metodo nos regresara la lista de todos los clientes existentes en la base de datos 
	 */
	@GET
	public List<Alumno> getAlumnos(){
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/**
	 *Este metodo es para guardar los datos de un alumno nuevo que resive como parametro un objeto alumno
	 *
	 */
	@POST
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumnos.size()+1, alumno);
	}
	
	/**
	 * Este metodo sirve para eliminar un alumno
	 * @param id
	 */
	@DELETE
	@Path("/{alumnoId}")
	public void deleteAlumno(@PathParam("alumnoId") int id){
		alumnos.remove(id);
	}
}



