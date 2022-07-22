# Learning-Java-REST-API

This is a demonstration of RESTful call in Java. Using a sample audio file, the simple application posts a request to the https://app.assemblyai.com/ api which transcribes the speech in the audio file. The application then retieves the result and stores the transcript to an object.

## Getting Started

### Dependencies

* Maven 3.8.6
* Google Gson 2.9.0

### Installing

1. Get a free API Key at [https://app.assemblyai.com/](https://app.assemblyai.com/)
2. Clone the repo
   ```sh
   git clone https://github.com/bradclemson97/Learning-Java-REST-API.git
   ```
3. Enter your API in `RestApiTutorial.java`
   ```js
  .header('Authorization', value = 'ENTER YOUR API KEY');
   ```

## Help

When running, the application will keep sending the get request until it completes. 
```
While running, the application is designed to check and return the status of the request every second. Once a 'complete' or error' status is returned the request is no longer sent. 
```

## Authors

Contributors names and contact info

ex. Bradley Clemson 
ex. [@bradclemson](https://twitter.com/bradclemson)

## Version History

* 0.1
    * Initial Release

## Acknowledgments

* [AssemblyAI](https://app.assemblyai.com/)
* [Audio Samples](https://github.com/audio-samples)


<p align="right">(<a href="#top">back to top</a>)</p>


