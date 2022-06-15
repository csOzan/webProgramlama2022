package technxt.service;

import java.util.List;

import technxt.model.Xmap_ps;



public interface TechNXTXpsService {

	public abstract void addxps(Xmap_ps xps);
	public abstract List<Xmap_ps> getallxps();
	public abstract List<Xmap_ps> getBestxmapPS();
	public abstract List<Xmap_ps> getProductbyProductId(String pid);
	public abstract List<Xmap_ps> getProductbyXpsId(String xps_id);
	public abstract void deleteXPS(String xps_id);
	public abstract void updateXPS(Xmap_ps xps);
	public abstract Xmap_ps getXPSbyId(String xps_id);
}
