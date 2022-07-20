package jogoDaVelha;

import javax.swing.JOptionPane;

public class jogoDaVelha {

	static int matriz[][] = new int[3][3];
	static String conversao[][] = new String[3][3];
	static boolean finalizou;

	public static void main(String[] args) {

		int contador = 0;
		boolean xGanhou = false;
		boolean oGanhou = false;
		int jogadas = 0;

		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {

				matriz[l][c] = contador++;
				conversao[l][c] = String.valueOf(matriz[l][c] + 1);
			}
		}

		mostrarMatriz();

		do {

			jogadas++;
			jogar(xGanhou, oGanhou, jogadas);
		} while (finalizou != true);

		JOptionPane.showMessageDialog(null, "JOGO FINALIZOU!!!!!", "JOGO DA VELHA", JOptionPane.INFORMATION_MESSAGE);

	}

	/*******************************************************************************/

	public static void mostrarMatriz() {

		String mostrarMatriz = "";

		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {

				mostrarMatriz += "     | " + conversao[l][c] + " | ";

			}

			mostrarMatriz += "\n";

		}

		JOptionPane.showMessageDialog(null, mostrarMatriz, "JOGO DA VELHA", JOptionPane.INFORMATION_MESSAGE);

	}

	/*******************************************************************************/

	public static boolean verificarPosicao(int x, int y) {
		boolean repetiu = false;
		if (conversao[x][y].equals("x") || conversao[x][y].equals("o")) {
			repetiu = true;
			JOptionPane.showMessageDialog(null, "Posição já preenchida, jogue novamente! ", "JOGO DA VELHA",
					JOptionPane.INFORMATION_MESSAGE);
			mostrarMatriz();
		}
		return repetiu;

	}

	/*******************************************************************************/

	public static void jogar(boolean xGanhou, boolean oGanhou, int jogadas) {

		int x = 0;
		int y = 0;
		int jogadorX = 0;
		int jogadorO = 0;
		boolean repetiu = true;

		if (finalizou == false) {

			do {

				jogadorX = Integer.parseInt(
						JOptionPane.showInputDialog("Jogador X informe qual posição gostaria de jogar, de 1 a 9"));
				while (jogadorX < 1 || jogadorX > 9) {
					jogadorX = Integer.parseInt(JOptionPane.showInputDialog(
							"Jogada inválida! Jogador X informe qual posição gostaria de jogar, de 1 a 9"));
				}

				for (int l = 0; l < 3; l++) {
					for (int c = 0; c < 3; c++) {

						if (jogadorX == matriz[l][c] + 1) {
							x = l;
							y = c;
							repetiu = verificarPosicao(x, y);
							if (!repetiu) {
								conversao[l][c] = "x";

							}
						}
					}
				}

			} while (repetiu == true);

		}

		validacaoX(xGanhou);

		mostrarMatriz();

		if (finalizou == false) {

			if (jogadas != 5) {

				do {
					jogadorO = Integer.parseInt(
							JOptionPane.showInputDialog("Jogador O informe qual posição gostaria de jogar, de 1 a 9"));
					while (jogadorO < 1 || jogadorO > 9) {
						jogadorO = Integer.parseInt(JOptionPane.showInputDialog(
								"Jogada inválida! Jogador O informe qual posição gostaria de jogar, de 1 a 9"));
					}

					for (int l = 0; l < 3; l++) {
						for (int c = 0; c < 3; c++) {

							if (jogadorO == matriz[l][c] + 1) {
								x = l;
								y = c;
								repetiu = verificarPosicao(x, y);

								if (!repetiu) {
									conversao[l][c] = "o";

								}
							}

						}

					}

				} while (repetiu == true);

			} else {
				JOptionPane.showMessageDialog(null, "Deu velha!", "JOGO DA VELHA", JOptionPane.INFORMATION_MESSAGE);
				finalizou = true;

			}

			validacaoO(oGanhou);

			mostrarMatriz();
		}

	}

	/*******************************************************************************/

	public static void validacaoX(boolean xGanhou) {

		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {

				if (conversao[l][0] == "x" && conversao[l][1] == "x" && conversao[l][2] == "x") {
					finalizou = true;
					xGanhou = true;
				} else if (conversao[0][c] == "x" && conversao[1][c] == "x" && conversao[2][c] == "x") {
					finalizou = true;
					xGanhou = true;
				} else if (conversao[0][0] == "x" && conversao[1][1] == "x" && conversao[2][2] == "x") {
					finalizou = true;
					xGanhou = true;
				} else if (conversao[0][2] == "x" && conversao[1][1] == "x" && conversao[2][0] == "x") {
					finalizou = true;
					xGanhou = true;
				}
			}
		}

		if (xGanhou == true) {
			JOptionPane.showMessageDialog(null, "X ganhou!!!!", "JOGO DA VELHA", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/*******************************************************************************/

	public static void validacaoO(boolean oGanhou) {

		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {

				if (conversao[l][0] == "o" && conversao[l][1] == "o" && conversao[l][2] == "o") {
					finalizou = true;
					oGanhou = true;
				} else if (conversao[0][c] == "o" && conversao[1][c] == "o" && conversao[2][c] == "o") {
					finalizou = true;
					oGanhou = true;
				} else if (conversao[0][0] == "o" && conversao[1][1] == "o" && conversao[2][2] == "o") {
					finalizou = true;
					oGanhou = true;
				} else if (conversao[0][2] == "o" && conversao[1][1] == "o" && conversao[2][0] == "o") {
					finalizou = true;
					oGanhou = true;

				}
			}
		}

		if (oGanhou == true) {
			JOptionPane.showMessageDialog(null, "O ganhou!!!!", "JOGO DA VELHA", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}