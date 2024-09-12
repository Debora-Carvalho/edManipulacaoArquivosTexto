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
	static final String ARQ_ENTRADA = "C:\\Users\\FATEC ZONA LESTE\\Desktop\\ex4_in.txt";
	static final String ARQ_SAIDA = "C:\\Users\\FATEC ZONA LESTE\\Desktop\\ex4_out.txt";

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
		//ex3ResultadoJogo();
		ex4CampeaoPartida();
		//é uma boa pratica fechar os arquivos e métodos depois que usarmos
		br.close();
		bw.close();
		fr.close();
		fw.close();

	}

	private static void ex4CampeaoPartida()  throws IOException {
		//No exemplo abaixo, a linha com valor “4” indica o número de times, a linha “04Santos” representa o código e nome do time.
		//Após os nomes dos times, temos a linha que indica o número de partidas (“5” no exemplo). Na linha “1 4 2 1”, os dois primeiros dígitos são os códigos dos
		//times que se enfrentaram, já os dois últimos são o número de gols de cada time. No caso, 2 a 1 para o São Paulo contra o Santos. Mostre o time com
		//mais pontos e o número de pontos. Seu algoritmo deve funcionar para 2 até 99 times e x partidas. Caso 2 ou mais times fiquem com os mesmos pontos,
		//imprimir qualquer um deles (para facilitar um pouco).
		
		int numTimes = Integer.parseInt(br.readLine());
		String nomesTimes[] = new String[numTimes];
		int pontosTimes[] = new int[numTimes];
		
		for (int i = 0; i < numTimes; i++) {
			nomesTimes[i] = br.readLine().substring(2);   //utilizo substring para subtrair os dois primeiros caracteres na leitura
		} 
		
		//calculo de pontuacao
		int numPartidas = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < numPartidas; i++) {
			String linha = br.readLine(); 
			String valores[] = linha.split(" ");
	
			int codTimeCasa = Integer.parseInt(valores[0]);
			int codTimeFora = Integer.parseInt(valores[1]);
			int golsTimeCasa = Integer.parseInt(valores[2]);
			int golsTimeFora = Integer.parseInt(valores[3]);
			
			if (golsTimeCasa > golsTimeFora) {
				pontosTimes[codTimeCasa] +=3;
			} else if (golsTimeCasa < golsTimeFora) {
				pontosTimes[codTimeFora] +=3;
			} else {
				pontosTimes[codTimeCasa] ++;
				pontosTimes[codTimeFora] ++;
			}
		} 
		
		//verifica o time com maior pontos
		int indMaiorPontos = 0;
		int maiorPontos = 0;
		
		for (int i = 0; i < numTimes; i++) {
			if (pontosTimes[i] > maiorPontos) {
				indMaiorPontos = i;
				maiorPontos = pontosTimes[i];
			}
		}
		
		System.out.println("Campeão: " + nomesTimes[indMaiorPontos]);
		System.out.println("Pontos: " + maiorPontos);
		
		//realizando um "commit"
		bw.flush();
		
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