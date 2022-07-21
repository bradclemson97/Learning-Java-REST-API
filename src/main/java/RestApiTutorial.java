import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.URI;
import java.net.http.HttpResponse;

public class RestApiTutorial {
    public static void main(String[] args) throws Exception {

        //Set the url to the audio we want to post
        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://github.com/audio-samples/audio-samples.github.io/blob/master/samples/mp3/ted_speakers/BillGates/sample-1.mp3?raw=true");
        Gson gson = new Gson();
        //pass into the method the object (transcript) we want to translate to Gson
        //Create a new jsonRequest string to save the result
        String jsonRequest = gson.toJson(transcript);
        System.out.println(jsonRequest);

        //This is our post request
        //the URI is the URL of the API, name and value is our API key from AssemblyAI
        HttpRequest postRequest = (HttpRequest) HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", "0000000000000000000000001")
                .POST(BodyPublishers.ofString(jsonRequest))
                .build();

        //To send the request we are using the HttpClient library
        HttpClient httpClient = HttpClient.newHttpClient();

        //HttpResponse is an object to hold the post response
        //BodyHandlers.ofString lets it know what we expect a string in response
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse.body());

        //This Get call will keep sending until AssemblyAI is done processing the audio
        //We need to grab the response id from the json post response and translate the string into an object
        //we can use 'Transcript' class and add an 'id' object
        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        transcript.getId();

        HttpRequest getRequest = (HttpRequest) HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", "d52a0a9e534646c8b61831cb09aed46c")
                .build();

        //HttpResponse is an object to hold the get response
        //BodyHandlers.ofString lets it know what we expect a string in response
        //the sending of this get call is in a while loop so we keep sending the request until it completes
        while (true) {

            HttpResponse<String> getResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

            //Translates the body of the get repsonse and translates it into the 'transcript' variable...
            transcript = gson.fromJson(getResponse.body(), Transcript.class);

            //after we make the call each time lets print out the status of the response...
            System.out.println(transcript.getStatus());

            //Lets also check the value of the status so we can check for whether it is complete or errored
            //and if so lets break out of the loop
            if ("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())) {
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println("Transcription completed!");
        System.out.println(transcript.getText());
    }
}
