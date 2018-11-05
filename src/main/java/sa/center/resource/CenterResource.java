package sa.center.resource;

import sa.center.model.Center;
//import sa.center.model.City;
import sa.center.service.CenterService;
//import sa.center.service.CityService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/center")
public class CenterResource {

    @Context
    UriInfo uriInfo;

    @EJB
    CenterService centerService;
    //CityService cityService;

    @GET
    public List<Center> getAllCenters(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return centerService.getAllCenters(first, maxResult);
    }
    /*@GET
    public List<City> getAllCities(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return cityService.getAllCity(first, maxResult);
    }*/

    @GET
    @Path("{code}")
    public Center getCenterByCode(@PathParam("code") long code) {
        return centerService.getCenterByCode(code);
    }

    @POST
    public Response createCenter(Center center) {
        centerService.createCenter(center);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{code}")
    public Response updateCenter(@PathParam("code") long code, Center center) {
        centerService.updateCenter(code, center);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{code}")
    public Response deleteCenter(@PathParam("code") long code) {
        centerService.deleteCenter(code);
        return Response.status(Response.Status.OK).build();
    }

}
