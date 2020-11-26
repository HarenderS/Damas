package Damas.damas.views;

import Damas.damas.models.Piece;

public class GameView extends SubView {

	public void writeNumbersLine(final int DIMENSION) {
		this.console.write(" ");
		for (int i = 0; i < DIMENSION; i++)
			this.console.write((i + 1) + "");
		this.console.writeln();
	}

	public void writePiecesRow(final int row, Piece piece) {
		if (piece == null)
			this.console.write(" ");
		else
			this.console.write(piece.getCode());
		
	}

}
