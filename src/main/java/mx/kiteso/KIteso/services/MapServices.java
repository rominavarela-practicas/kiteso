package mx.kiteso.KIteso.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
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
import mx.kiteso.KIteso.model.adapter.PathAdapter;
import mx.kiteso.KIteso.model.serial.out.Map;
import mx.kiteso.KIteso.model.serial.out.Path;
import mx.kiteso.KIteso.model.serial.out.Route;
import mx.kiteso.KIteso.model.serial.out.Status;

@Controller
@RequestMapping("KItesoServices/map")
public class MapServices {
	
	private static final Logger log = Logger.getLogger(BaseServices.class);
	
	@PostConstruct
	public void init() throws FileNotFoundException {
		log.info("init Demo Controller");
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
			map.setStatus(Status.STATUS_OK);
			
		} catch(Exception ex) {
			map.setMsg(ex.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping(value="/shortest/route/{sourceId}/{targetId}", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Route shortestRoute(@PathVariable int sourceId,@PathVariable int targetId,
			@CookieValue(value = "session", defaultValue = "{}") String sessionCookie,
			HttpServletRequest req, HttpServletResponse res)
	{
		Route route = new Route();
		
		try {
			Dijkstra d= DijkstraImpl.getInstance(sourceId);
			route.setRoute(d.getShortestRoute(targetId));
			route.setStatus(Status.STATUS_OK);
			
		} catch(Exception ex) {
			route.setMsg(ex.getMessage());
		}
		
		return route;
	}
}