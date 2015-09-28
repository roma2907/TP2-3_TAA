package util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import domain.Release;
public class CustomReleaseSerializer extends JsonSerializer<Release> {

	@Override
	public void serialize(Release release, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		generator.writeString(release.getId().toString());
	}

}
