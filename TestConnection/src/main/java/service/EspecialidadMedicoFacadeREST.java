/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.gonet.testconn.EspecialidadMedico;
import com.gonet.testconn.EspecialidadMedicoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author alfredo
 */
@Stateless
@Path("com.gonet.testconn.especialidadmedico")
public class EspecialidadMedicoFacadeREST extends AbstractFacade<EspecialidadMedico> {

	@PersistenceContext(unitName = "com.tracktopell_TestConnection_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	private EspecialidadMedicoPK getPrimaryKey(PathSegment pathSegment) {
		/*
		 * pathSemgent represents a URI path segment and any associated matrix parameters.
		 * URI path part is supposed to be in form of 'somePath;especialidadId=especialidadIdValue;medicoCedulaProfesional=medicoCedulaProfesionalValue'.
		 * Here 'somePath' is a result of getPath() method invocation and
		 * it is ignored in the following code.
		 * Matrix parameters are used as field names to build a primary key instance.
		 */
		com.gonet.testconn.EspecialidadMedicoPK key = new com.gonet.testconn.EspecialidadMedicoPK();
		javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
		java.util.List<String> especialidadId = map.get("especialidadId");
		if (especialidadId != null && !especialidadId.isEmpty()) {
			key.setEspecialidadId(new java.lang.Integer(especialidadId.get(0)));
		}
		java.util.List<String> medicoCedulaProfesional = map.get("medicoCedulaProfesional");
		if (medicoCedulaProfesional != null && !medicoCedulaProfesional.isEmpty()) {
			key.setMedicoCedulaProfesional(medicoCedulaProfesional.get(0));
		}
		return key;
	}

	public EspecialidadMedicoFacadeREST() {
		super(EspecialidadMedico.class);
	}

	@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(EspecialidadMedico entity) {
		super.create(entity);
	}

	@PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") PathSegment id, EspecialidadMedico entity) {
		super.edit(entity);
	}

	@DELETE
    @Path("{id}")
	public void remove(@PathParam("id") PathSegment id) {
		com.gonet.testconn.EspecialidadMedicoPK key = getPrimaryKey(id);
		super.remove(super.find(key));
	}

	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public EspecialidadMedico find(@PathParam("id") PathSegment id) {
		com.gonet.testconn.EspecialidadMedicoPK key = getPrimaryKey(id);
		return super.find(key);
	}

	@GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<EspecialidadMedico> findAll() {
		return super.findAll();
	}

	@GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<EspecialidadMedico> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

	@GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
	public String countREST() {
		return String.valueOf(super.count());
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
