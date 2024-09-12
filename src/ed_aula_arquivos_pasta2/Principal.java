package ed_aula_arquivos_pasta2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {
	static FileReader fr;
	static BufferedReader br;
	static FileWriter fw;
	static BufferedWriter bw;
	static final String ARQ_ENTRADA = "C:\\Users\\FATEC ZONA LESTE\\Desktop\\ex3_in.txt";
	static final String ARQ_SAIDA = "C:\\Users\\FATEC ZONA LESTE\\Desktop\\ex3_out.txt";

	public static void main(String[] args) throws IOException {
		fr = new FileReader(ARQ_ENTRADA);
		br = new BufferedReader(fr);
		fw = new FileWriter(ARQ_SAIDA);
		bw = new BufferedWriter(fw);
		//leitura();
		//escrita();
		//formataDataSubstring();
		//formataDataSplit();
		//separarSobrenome();
		//quiz();
		//ex1Ordenacao();
		//ex2AcimaMedia();
		ex3ResultadoJogo();
		//é uma boa pratica fechar os arquivos e métodos depois que usarmos
		br.close();
		bw.close();
		fr.close();
		fw.close();

	}

	private static void ex3ResultadoJogo() throws IOException {
		//A partir de um arquivo txt “ex3_in.txt” com o conteúdo a seguir, gravar um arquivo de saída “ex3_out.txt” com o
		//nome do vencedor ao lado do jogo ou empate. Cada linha representa um jogo com o resultado ao lado. Os gols da
		//esquerda são do primeiro time. Seu algoritmo deve funcionar para n partidas.
		
		String linha = br.readLine();
		
		while(linha != null) {

			String valores[] = linha.split("-");
			String timeCasa = valores[0];
			String timeFora = valores[1];
			int golsTimeCasa = Integer.parseInt(valores[2]);
			int golsTimeFora = Integer.parseInt(valores[3]);
			
			if (golsTimeCasa > golsTimeFora) {
				fw.write(linha + "\tVencedor: " + timeCasa + "\n");
			} else if (golsTimeCasa < golsTimeFora) {
				fw.write(linha + "\tVencedor: " + timeFora + "\n");
			} else {
				fw.write(linha + "\tEmpate\n");
			}
			//ler toda a linha
			linha = br.readLine();
		}
		
		//realizando um "commit"
		bw.flush();
		
	}

	private static void ex2AcimaMedia() throws IOException {
		//A partir de um arquivo txt “ex2_in.txt” com o conteúdo a seguir, gravar um arquivo de saída
		//“ex2_out.txt” somente com os alunos com nota igual ou maior que 7.
		String linha = br.readLine();
		
		while(linha != null) {

			String valores[] = linha.split(" ");
			double nota = Double.parseDouble(valores[valores.length -1]);
			
			if (nota >= 7) {
				fw.write(linha + "\n");
			}
			//ler toda a linha
			linha = br.readLine();
		}
		
		//realizando um "commit"
		bw.flush();
		
	}

	private static void ex1Ordenacao() throws IOException {
		//A partir de um arquivo txt “ex1_in.txt” com o conteúdo da próxima página, gravar um arquivo de 
		//saída “ex1_out.txt” em ordem alfabética.
		String linha = br.readLine();
		ArrayList<String> nomes = new ArrayList<String>();
		while(linha != null) {
			nomes.add(linha);
			linha = br.readLine();
		}
		//organiza a lista em ordem alfabetica
		Collections.sort(nomes);
		
		for (String nome : nomes) {
			bw.write(nome + "\n");
		}
		//realizando um "commit"
		bw.flush();
		
		
	}

}