package mx.kiteso.KIteso.services;

import java.io.FileNotFoundException;
import java.util.List;

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

import com.google.gson.Gson;

import mx.kiteso.KIteso.graph.Graph;
import mx.kiteso.KIteso.model.Node;
import mx.kiteso.KIteso.model.Status;
import mx.kiteso.KIteso.model.adapter.Vertex;

@Controller
@RequestMapping("KItesoServices/map")
public class MapServices {
	
	private static final Logger log = Logger.getLogger(BaseServices.class);
	
	@PostConstruct
	public void init() throws FileNotFoundException {
		log.info("init Demo Controller");
	}
	
	@RequestMapping(value="/shortest/path/{sourceId}/{targetId}", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Status shortestPath(@PathVariable int sourceId,@PathVariable int targetId,
			@CookieValue(value = "session", defaultValue = "{}") String sessionCookie,
			HttpServletRequest req, HttpServletResponse res)
	{
		Status status = new Status();
		
		try {
			Graph graph= Graph.getInstance();
			Vertex source= graph.getVertices().get(sourceId-1);
			Vertex target= graph.getVertices().get(targetId-1);
			List<Node> path= graph.getShortestPath(source, target);
			
			Gson gson = new Gson();
			String json = gson.toJson(path);
			status.setMsg(json);
		    status.setStatus(Status.STATUS_OK);
			
		} catch(Exception ex) {
			status.setMsg(ex.getMessage());
		}
		
		return status;
	}
}