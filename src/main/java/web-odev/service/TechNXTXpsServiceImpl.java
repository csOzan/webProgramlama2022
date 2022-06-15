package technxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTXpsDao;
import technxt.model.Xmap_ps;



@Service
public class TechNXTXpsServiceImpl implements TechNXTXpsService {

	@Autowired
	private TechNXTXpsDao technxtXD;
	
	public void addxps(Xmap_ps xps) {
		technxtXD.addxps(xps);

	}

	public List<Xmap_ps> getallxps() {
		
		return technxtXD.getallxps();
	}

	public void deleteXPS(String xps_id) {
		
		technxtXD.deleteXPS(xps_id);
	}

	public void updateXPS(Xmap_ps xps) {
		
		technxtXD.updateXPS(xps);
	}

	public Xmap_ps getXPSbyId(String xps_id) {
		// TODO Auto-generated method stub
		return technxtXD.getXPSbyId(xps_id);
	}

	public List<Xmap_ps> getBestxmapPS() {
		// TODO Auto-generated method stub
		return technxtXD.getBestxmapPS();
	}

	public List<Xmap_ps> getProductbyProductId(String product_id) {
		// TODO Auto-generated method stub
		return technxtXD.getProductbyProductId(product_id);
	}

	public List<Xmap_ps> getProductbyXpsId(String xps_id) {
		// TODO Auto-generated method stub
		return technxtXD.getProductbyXpsId(xps_id);
	}

}
