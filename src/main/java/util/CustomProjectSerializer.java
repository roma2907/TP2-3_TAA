package util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import domain.Project;

public class CustomProjectSerializer extends JsonSerializer<Project> {

	@Override
	public void serialize(Project project, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		generator.writeString(project.getId().toString());
	}

}
