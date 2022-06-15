/*package technxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTVwXmapPSDao;
import technxt.model.VwXmapPS;

@Service
public class TechNXTVwXmapPSServiceImpl implements TechNXTVwXmapPSService {
	
	@Autowired
	private TechNXTVwXmapPSDao vwxpsdao;

	public List<VwXmapPS> getVwPs() {
		
		return vwxpsdao.getVwPs();
	}

	public List<VwXmapPS> getBestVwPs() {
		
		return vwxpsdao.getBestVwPs();
	}

	public List<VwXmapPS> getProductbyProductId(String pid) {
	
		return vwxpsdao.getProductbyProductId(pid);
	}

	public List<VwXmapPS> getProductbyXpsId(String xps_id) {
		
		return vwxpsdao.getProductbyXpsId(xps_id);
	}

}
*/