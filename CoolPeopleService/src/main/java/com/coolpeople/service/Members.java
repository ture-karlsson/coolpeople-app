package com.coolpeople.service;

import java.util.Date;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("members")
public class Members {

    @EJB
    MemberStore memberStore;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getMembers() {
        return Json.createObjectBuilder()
                .add("timestamp", new Date().toString())
                .add("members", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", "1").add("name", "ture").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996"))
                        .add(Json.createObjectBuilder().add("id", "2").add("name", "david").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996"))
                        .add(Json.createObjectBuilder().add("id", "3").add("name", "henri").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996"))
                        .add(Json.createObjectBuilder().add("id", "4").add("name", "martin").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996")))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject addMember() {

        return null;
    }

}
