package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import desafioPlataforma.Lesson;
import desafioPlataforma.Task;
import desafioPlataforma.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Quantas aulas tem o curso? ");
		int N = sc.nextInt();

		List<Lesson> list = new ArrayList<Lesson>();

		for (int i = 0; i < N; i++) {
			System.out.print("Dados da " + (i + 1) + " a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)?");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Título: ");
			String titulo = sc.nextLine();
			if (type == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seg = sc.nextInt();
				Video s = new Video(titulo, url, seg);
				list.add(s);
			} else {
				System.out.print("Descrição: ");
				String descricao = sc.nextLine();
				System.out.print("Quantidade de questões:");
				int quantidadeQuestoes = sc.nextInt();
				Task q = new Task(titulo, descricao,quantidadeQuestoes );
				list.add(q);
			}

		}
		
		System.out.println();
		int duracao =0;
		for(Lesson curso : list) {
			duracao += curso.duration();
					
		}
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", duracao );

		sc.close();
	}

}
