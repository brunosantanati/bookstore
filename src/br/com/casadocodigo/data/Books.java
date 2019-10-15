package br.com.casadocodigo.data;

import br.com.casadocodigo.model.*;
import java.util.*;
import java.util.stream.*;
import java.net.URI;
//import jdk.incubator.http.*; //Java 9
import java.net.http.*; //Java 11

public class Books {

  public static List<Book> all() {
    try {
      String csv = HttpClient.newHttpClient()
      .send(HttpRequest.newBuilder()
        .uri(new URI("https://turini.github.io/livro-java-9/books.csv"))
        .GET().build(), 
      //HttpResponse.BodyHandler.asString()).body(); //Java 9
      HttpResponse.BodyHandlers.ofString()).body(); //Java 11

      return Stream.of(csv.split("\n"))
        .map(Books::create)
        .collect(Collectors.toList());

    } catch (Exception e) {
      throw new RuntimeException("Nao foi possivel conectar ", e);
    }
  }

  public static Book create(String line) {
    String[] split = line.split(",");  
    String name = split[0];
    String author = split[2];
    Category category = Category.valueOf(split[3]);
    return new Book(name, author, category);
  }

  public static Optional<Book> findSimilar(Book book) {
    return Books.all().stream()
      .filter(b -> b.getCategories().equals(book.getCategories()))
      .filter(b -> !b.getAuthor().equals(book.getAuthor()))
      .findAny();
  }
}