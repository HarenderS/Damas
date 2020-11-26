package Damas.damas.controllers;

import Damas.damas.models.Coordinate;
import Damas.damas.models.Game;
import Damas.damas.models.Piece;
import Damas.damas.models.State;
import Damas.damas.utils.Console;
import Damas.damas.views.GameView;

public abstract class InteractorController extends Controller {

	protected InteractorController(Game game, State state) {
		super(game, state);
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}
	
	public void writeGame(InteractorController controller) {
        assert controller != null;
        GameView gameView = new GameView();
        gameView.writeNumbersLine(controller.getDimension());
        for (int i = 0; i < controller.getDimension(); i++) {
        	new Console().write((i + 1) + "");
        	for (int j = 0; j < controller.getDimension(); j++) {
        		gameView.writePiecesRow(i, controller.getPiece(new Coordinate(i, j)));
			}
        	new Console().writeln((i + 1) + "");
        }
        gameView.writeNumbersLine(controller.getDimension());
    }
	
	public void next() {
		this.state.next();
	}
	
	abstract public void control();

}
