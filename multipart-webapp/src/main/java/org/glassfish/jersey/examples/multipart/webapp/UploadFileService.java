/**
 * 
 */
package org.glassfish.jersey.examples.multipart.webapp;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.simpleframework.http.message.PartSeries;

/**
 * @author bliu
 * 
 */
@Path("/file")
public class UploadFileService {

	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String getHello() {
		return "Hello word";
	}

	@POST
	@Path("/uploadmutipart")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadmutipart(final FormDataMultiPart multiPart) {

		Map<String, List<FormDataBodyPart>> fields = multiPart.getFields();
		Iterator<Entry<String, List<FormDataBodyPart>>> it = fields.entrySet()
				.iterator();
		while (it.hasNext()) {
			Entry<String, List<FormDataBodyPart>> mapEntry = (Entry<String, List<FormDataBodyPart>>) it
					.next();
			String key = mapEntry.getKey();
			List<FormDataBodyPart> value = mapEntry.getValue();
			Iterator<FormDataBodyPart> itl = value.iterator();
			
			while(itl.hasNext()){
				FormDataBodyPart part = itl.next();
				String name = part.getName();
				BodyPartEntity ent = (BodyPartEntity) part.getEntity();
				InputStream is = ent.getInputStream();
				FormDataContentDisposition fpos = part.getFormDataContentDisposition();
				String ffileName = fpos.getFileName();
				Map<String, String> pars = fpos.getParameters();
				int a = pars.size();
			}
		}
		return Response.ok().entity(multiPart).build();

	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadfile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		String uploadedFileLocation = "d://uploaded/"
				+ fileDetail.getFileName();

		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.ok().entity(output).build();
	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
