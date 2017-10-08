/**
 * Created by Kevin on 10/7/17.
 */
import com.ciscospark.*;
import java.net.URI;

class Example {
    public static void main(String[] args) {
        // To obtain a developer access token, visit http://developer.ciscospark.com
        String accessToken = "OTY3YTEwYjgtMjcxZS00MDZlLTljN2MtMTk2YmNiMDkwNDk5MTA2YTQzNjEtZGQ2";

        // Initialize the client
        Spark spark = Spark.builder()
                .baseUrl(URI.create("https://api.ciscospark.com/v1"))
                .accessToken(accessToken)
                .build();

        // Create a new room
        Room room = new Room();
        room.setTitle("Hello World");
        room = spark.rooms().post(room);

        // Post a text message to the room
        Message message = new Message();
        message.setRoomId(room.getId());
        message.setText("Hello World!");
        spark.messages().post(message);
    }
}