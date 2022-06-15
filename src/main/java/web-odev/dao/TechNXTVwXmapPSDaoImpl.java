/*package technxt.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import technxt.model.VwXmapPS;

@Repository
public class TechNXTVwXmapPSDaoImpl implements TechNXTVwXmapPSDao {
	
	@Autowired
	public SessionFactory sf;

	public List<VwXmapPS> getVwPs() {
		Session ses = sf.openSession();
		Query qr = ses.createQuery("from VwXmapPS");
		List<VwXmapPS> data = qr.list();
		ses.close();
		return data;
	}

	public List<VwXmapPS> getBestVwPs() {
		Session ses = sf.openSession();
		String qry = "from VwXmapPS x1 where xps_price=(select min(xps_price) from VwXmapPS x2 where x1.product_id=x2.product_id)";
		Query qr = ses.createQuery(qry);
		List<VwXmapPS> data = qr.list();
		ses.close();
		return data;
	}

	public List<VwXmapPS> getProductbyProductId(String pid) {
		Session ses = sf.openSession();
		String qry = "from VwXmapPS where product_id=? ORDER BY xps_price ASC";		
		Query qr = ses.createQuery(qry);
		qr.setParameter(0, pid);
		List<VwXmapPS> data = qr.list();
		ses.close();		
		return data;
	}

	public List<VwXmapPS> getProductbyXpsId(String xps_id) {
		Session ses = sf.openSession();
		String qry = "from VwXmapPS where xps_id=?";		
		Query qr = ses.createQuery(qry);
		qr.setParameter(0, xps_id);
		List<VwXmapPS> data = qr.list();
		ses.close();		
		return data;
	}
	
	
	
	

}
*/