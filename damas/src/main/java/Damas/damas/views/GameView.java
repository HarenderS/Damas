package Damas.damas.views;

import Damas.damas.controllers.InteractorController;
import Damas.damas.models.Coordinate;
import Damas.damas.models.Piece;

class GameView extends SubView {

    void write(InteractorController controller) {
        assert controller != null;
        this.writeNumbersLine(controller.getDimension());
        for (int i = 0; i < controller.getDimension(); i++)
            this.writePiecesRow(i, controller);
        this.writeNumbersLine(controller.getDimension());
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for (int i = 0; i < DIMENSION; i++)
            this.console.write((i + 1) + "");
        this.console.writeln();
    }

    private void writePiecesRow(final int row, InteractorController controller) {
        this.console.write((row + 1) + "");
        for (int j = 0; j < controller.getDimension(); j++) {
            Piece piece = controller.getPiece(new Coordinate(row, j));
            if (piece == null)
                this.console.write(" ");
            else 
                this.console.write(piece.getCode());
        }
        this.console.writeln((row + 1) + "");
    }

}
