package util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import domain.Sprint;

public class CustomSprintSerializer extends JsonSerializer<Sprint> {

	@Override
	public void serialize(Sprint sprint, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		generator.writeString(sprint.getId().toString());
	}

}
