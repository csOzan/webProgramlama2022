package technxt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import technxt.model.Product;
import technxt.model.Xmap_ps;


@Repository
public class TechNXTXpsDaoImpl implements TechNXTXpsDao {

	@Autowired
	private SessionFactory sf;
	 
	@Transactional
	public void addxps(Xmap_ps xps) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		xps.setXps_id(generateXpsId());
		ses.save(xps);
		tr.commit();
		ses.close();

	}
	
	@Transactional
	public List<Xmap_ps> getallxps() {
		Session ses = sf.openSession();
		Query qr = ses.createQuery("from Xmap_ps");
		List<Xmap_ps> xpslist = qr.list();
		ses.close();
		return xpslist;
	}

	@Transactional
	private String generateXpsId(){
		
		String newPid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from Xmap_ps");
		List<Product> data = qr.list();
		s.close();
		if(data.size()==0){
			newPid="XPS00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(xps_id) from Xmap_ps");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newPid="XPS0000"+id;
			else if(id<=99)
				newPid="XPS000"+id;
			else if(id<=999)
				newPid="XPS00"+id;
			else if(id<=9999)
				newPid="XPS0"+id;
			else
				newPid="XPS"+id;		
			System.out.print("\nGenerated : "+newPid);		
			ss.close();		
		}
			return newPid;
	}

	public void deleteXPS(String xps_id) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Xmap_ps xps = ses.get(Xmap_ps.class, xps_id);
		ses.delete(xps);
		tr.commit();
		ses.close();
		
	}

	public void updateXPS(Xmap_ps xps) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(xps);
		tr.commit();
		ses.close();
	}

	public Xmap_ps getXPSbyId(String xps_id) {
		Session ses = sf.openSession();
		Xmap_ps temp = ses.get(Xmap_ps.class, xps_id);
		ses.close();		
		return temp;
	}

	public List<Xmap_ps> getBestxmapPS() {
		Session ses = sf.openSession();
		String qry = "from Xmap_ps x1 where xps_price=(select min(xps_price) from Xmap_ps x2 where x1.product.product_id=x2.product.product_id)";
		Query qr = ses.createQuery(qry);
		List<Xmap_ps> data = qr.list();
		ses.close();
		return data;
	}

	public List<Xmap_ps> getProductbyProductId(String pid) {
		Session ses = sf.openSession();
		String qry = "from Xmap_ps where product.product_id=? ORDER BY xps_price ASC";		
		Query qr = ses.createQuery(qry);
		qr.setParameter(0, pid);
		List<Xmap_ps> data = qr.list();
		ses.close();		
		return data;
	}

	public List<Xmap_ps> getProductbyXpsId(String xps_id) {
		Session ses = sf.openSession();
		String qry = "from Xmap_ps where xps_id=?";		
		Query qr = ses.createQuery(qry);
		qr.setParameter(0, xps_id);
		List<Xmap_ps> data = qr.list();
		ses.close();		
		return data;
	}
	
}
