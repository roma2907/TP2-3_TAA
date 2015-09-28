package util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import domain.UserStory;

public class CustomUserStorySerializer extends JsonSerializer<UserStory> {

	@Override
	public void serialize(UserStory userStory, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		generator.writeString(userStory.getId().toString());
	}

}
