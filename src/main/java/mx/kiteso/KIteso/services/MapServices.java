package mx.kiteso.KIteso.services;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.kiteso.KIteso.algorithm.Dijkstra;
import mx.kiteso.KIteso.algorithm.impl.DijkstraImpl;
import mx.kiteso.KIteso.graph.Edge;
import mx.kiteso.KIteso.graph.Graph;
import mx.kiteso.KIteso.graph.Vertex;
import mx.kiteso.KIteso.model.adapter.PathAdapter;
import mx.kiteso.KIteso.model.serial.out.Map;
import mx.kiteso.KIteso.model.serial.out.Path;
import mx.kiteso.KIteso.model.serial.out.Status;

@Controller
@RequestMapping("KItesoServices/map")
public class MapServices {
	public static Logger log = Logger.getLogger(BaseServices.class);
	
	public Connection connection;
	
	@PostConstruct
	public void init() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Diseno_Software", "root", "toor");
		
		log.info("init Demo Controller");
	}
	
	@PreDestroy
	public void destroy() throws Exception {
		if(connection != null){
			connection.close();
		}
		
		log.info("Database connection closed");
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map getMap(
			@CookieValue(value = "session", defaultValue = "{}") String sessionCookie,
			HttpServletRequest req, HttpServletResponse res)
	{
		Map map = new Map();
		
		try {
			Graph graph= Graph.getInstance();
			ArrayList<Path> paths= new ArrayList<Path>();
			for(Edge e: graph.getEdges())
				paths.add(new PathAdapter(e));
			
			map.setPaths(paths);
			map.setLocations(graph.getLocations());
			map.setStatus(Status.STATUS_OK);
			
		} catch(Exception ex) {
			map.setMsg(ex.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping(value="/shortest/path/{sourceIndex}/{targetIndex}", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map shortestRoute(@PathVariable int sourceIndex,@PathVariable int targetIndex,
			@CookieValue(value = "session", defaultValue = "{}") String sessionCookie,
			HttpServletRequest req, HttpServletResponse res)
	{
		Map map = new Map();
		
		try {
			Dijkstra d= DijkstraImpl.getInstance(sourceIndex);
			List<Integer> route= d.getShortestRoute(targetIndex);
			ArrayList<Path> routePaths= new ArrayList<Path>();
			
			List<Vertex> vertices= Graph.getInstance().getVertices();
			Vertex source = vertices.get(sourceIndex);
			for(int index: route)
			{
				Vertex target= vertices.get(index);
				routePaths.add(new PathAdapter(source, target));
				
				source= target;
			}
			
			map.setPaths(routePaths);
			map.setStatus(Status.STATUS_OK);
			
		} catch(Exception ex) {
			map.setMsg(ex.getMessage());
		}
		
		return map;
	}
}