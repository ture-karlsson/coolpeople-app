package com.coolpeople.service;

import java.util.Date;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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

        if (memberStore.getMembers().size() > 0) {

            System.out.println("Number of members: " + memberStore.getMembers().size());

            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("timestamp", new Date().toString());

            JsonArrayBuilder memberList = Json.createArrayBuilder();

            for (Member member : memberStore.getMembers()) {

                memberList.add(Json.createObjectBuilder()
                        .add("id", member.getId())
                        .add("name", member.getName())
                        .add("longitude", member.getLongitude())
                        .add("latitude", member.getLatitude())
                        .add("timestamp", member.getTimestamp()));
            }

            builder.add("members", memberList);

            return builder.build();
        } // Create some sample data if the list is empty
        else {
            return Json.createObjectBuilder()
                    .add("timestamp", new Date().toString())
                    .add("members", Json.createArrayBuilder()
                            .add(Json.createObjectBuilder().add("id", "1").add("name", "ture").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394372"))
                            .add(Json.createObjectBuilder().add("id", "2").add("name", "david").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394373"))
                            .add(Json.createObjectBuilder().add("id", "3").add("name", "henri").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394374"))
                            .add(Json.createObjectBuilder().add("id", "4").add("name", "martin").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394375")))
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject addMember(Member member) {

        JsonObjectBuilder builder = Json.createObjectBuilder();

        if (member != null) {
            System.out.println("member.name = " + member.getName());

            builder.add("timestamp", new Date().toString())
                    .add("id", member.getId())
                    .add("name", member.getName())
                    .add("longitude", member.getLongitude())
                    .add("latitude", member.getLatitude())
                    .add("timestamp", member.getTimestamp());

            memberStore.addMember(member);
        } else {
            builder.add("timestamp", new Date().toString())
                    .add("error", "Provided member was null");
        }

        return builder.build();

    }

    @POST
    @Path("/nearby")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getNearby(Member me) {

        return Json.createObjectBuilder()
                .add("timestamp", new Date().toString())
                .add("members", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", "1").add("name", "ture").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394372"))
                        .add(Json.createObjectBuilder().add("id", "2").add("name", "david").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394373"))
                        .add(Json.createObjectBuilder().add("id", "3").add("name", "henri").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394374"))
                        .add(Json.createObjectBuilder().add("id", "4").add("name", "martin").add("longitude", "17.689008899999997").add("latitude", "59.619794399999996").add("timestamp", "1477394375")))
                .build();
    }

}
