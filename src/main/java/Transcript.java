public class Transcript {

    /*this will correspond to the request body 'the transcript' which we are posting in our post request
      the only thing we need is our audio_url
      we are then going to create an object of this class and let GSON automatically translate that object into a json
      string that we can use for our request...
    */
    private String audio_url;
    //we also need id to contain to the response id from the json post response...
    private String id;
    //we also need to monitor the status of the post request...
    private String status;
    //the text field of the get response will be the data we need from AssemblyAI...
    private String text;

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
