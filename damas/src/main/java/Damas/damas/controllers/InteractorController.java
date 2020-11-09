package Damas.damas.controllers;

import Damas.damas.models.Coordinate;
import Damas.damas.models.Game;
import Damas.damas.models.Piece;
import Damas.damas.models.State;

public abstract class InteractorController extends Controller {

	protected InteractorController(Game game, State state) {
		super(game, state);
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}

	abstract public void accept(InteractorControllersVisitor controllersVisitor);

}
