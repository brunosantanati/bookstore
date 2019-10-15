package br.com.casadocodigo;

import java.util.*;
import java.util.stream.*;
import br.com.casadocodigo.data.*;
import br.com.casadocodigo.model.*;

public class Main {
	public static void main(String... args) {
		System.out.println("\nLista de livros disponiveis \n");
		List<Book> books = Books.all();
		IntStream.range(0, books.size()).forEach(i -> {
			System.out.println(i + " - " + books.get(i).getName());
		});
	}
}