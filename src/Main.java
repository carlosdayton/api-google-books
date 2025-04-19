import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Dotenv dotenv = Dotenv.load();

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do livro a ser buscado: ");
        String livro = sc.nextLine();

        String apikey = dotenv.get("GOOGLE_BOOKS_API_KEY");
        System.out.println("Minha chave: " + apikey);
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + livro.replace(" ", "+") + "&key=" + apikey;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}