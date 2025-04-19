import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static java.net.http.HttpClient.newHttpClient;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do livro a ser buscado: ");
        String livro = sc.nextLine();

        String api = "AIzaSyDig9n50BB--EdeGHe0f8jwKQgYIVJEiv4";
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + livro.replace(" ", "+") + "&key=" + api;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}