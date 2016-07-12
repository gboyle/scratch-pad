package com.mycompany.srv;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

@Path("/my")
public class HelloWorld {
	
	Logger log = Logger.getAnonymousLogger();
	
	
	static String download="/tmp/";

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        return input;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
        input.setVal2(input.getVal1());
        return Response.ok().entity(input).build();
    }
    
    private void logAttachment(Attachment at) throws IOException {
    	
    	String id=at.getContentId();    	
    	MediaType mt=at.getContentType();
    	String filename=at.getContentDisposition().getFilename();
    	
    	log.info("id="+id+" mt="+mt.toString()+" file="+filename);
    	
    	if(filename != null) {
    		
    		File f = new File(download+filename);
    	
    		at.transferTo(f);
    	
    		return;	
    	}    	
    }
    
    @POST
    @Path("/downloads")
    public void addAttachments(MultipartBody body) throws Exception {
    
    	logAttachment(body.getRootAttachment());
    	
    	List<Attachment> attachments=body.getAllAttachments();
    	
    	for(Attachment at:attachments) {
    		logAttachment(at);
    	}
    }    
}

