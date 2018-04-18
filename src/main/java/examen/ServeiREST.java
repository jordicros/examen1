package examen;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by jordi on 18/04/2018.
 */
@Path("/service")
public class ServeiREST {
    MathManagerImpl manager;
    public ServeiREST() throws IOException {
        manager = MathManagerImpl.getInstance();
    }
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response afegirAlumne(Alumne al){
        manager.getAlumnes().add(al);
        return Response.ok().build();
    }
    @GET
    @Path("/operacions/alumne/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacio> allOpsBySomeone(@PathParam("id") int id){
        return manager.operacionsAlumne(id);
    }
    @GET
    @Path("/operacions/institut/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacio> allOpsBySomeone(@PathParam("nom") String nom){
        return manager.operacionsInstitut(nom);
    }
    @GET
    @Path("/sort/instituts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Institut> sortedInstituts()
    {
        return manager.sortInstisByOperations();
    }
    @POST
    @Path("/operacions/new/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newOP(@PathParam("id") int id, Operacio op)
    {
        int i=0,trobat=0;
        while(i<manager.getAlumnes().size()&&trobat==0)
        {
            if(manager.getAlumnes().get(i).id == id)
                trobat=1;
            else
                i++;
        }
        if(trobat==1) {
            manager.realitzarOperacio(op,manager.getAlumnes().get(i));
            return Response.ok().entity("Comanda realitzada").build();
        }
        else
            return Response.ok().entity("Sha produït un error").build();
    }
    @GET
    @Path("/operacions/generate")
    @Produces(MediaType.APPLICATION_JSON)
    public Operacio resultOP(){
        Operacio temp = manager.processarOperacio();
        if(temp == null)
        {
            temp = new Operacio();
            temp.idSolicitant = -1;
        }
        return temp;
    }

}
