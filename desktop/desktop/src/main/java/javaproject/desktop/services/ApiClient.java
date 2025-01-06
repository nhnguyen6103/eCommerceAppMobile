package javaproject.desktop.services;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final HttpClient client = HttpClient.newHttpClient();

    public ApiClient() {
    }

    // GET request
    public HttpResponse<String> sendGetRequest(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> sendGetRequestWithToken(String url, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Authorization", STR."Bearer \{token}")
                .header("Content-Type", "application/json") // Add headers as needed
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }



    //POST request
    public HttpResponse<String> sendPostRequest(String url, String body) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json") // Add headers as needed
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    //POST request with token
    public HttpResponse<String> sendPostRequestWithBearerToken(String url, String body, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Authorization", STR."Bearer \{token}")
                .header("Content-Type", "application/json") // Add headers as needed
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> sendDeleteRequestWithBearerToken(String url, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .header("Authorization", STR."Bearer \{token}")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
