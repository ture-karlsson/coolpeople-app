package com.coolpeople.service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("members")
public class Members {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getMembers(){
        return Json.createObjectBuilder().add("hello", "world").build();
    }

}
