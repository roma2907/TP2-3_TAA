package util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import domain.Developper;

public class CustomDevelopperSerializer extends JsonSerializer<Developper> {

	@Override
	public void serialize(Developper developper, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		generator.writeString(developper.getId().toString());
	}

}
