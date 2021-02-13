package fr.upec.episen.mounir;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Produces(MediaType.APPLICATION_JSON)
@Path("/owners")
public class OwnerRestService {


    @PUT
    @Path("/{identification}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveOwnerName(@PathParam("identification") String id, @PathParam("name")String newName){


        String identification= id;
        String name="";
        switch (identification) {
            case "AB-123-CD":
                name = newName;
                break;
            case "MC-007-CM":
                name = newName;
                break;
            default:
                name = "inconnu";
                break;
        }


        return name;
    }
}
