package Damas.damas.controllers;

import Damas.damas.models.Coordinate;
import Damas.damas.models.Error;
import Damas.damas.models.Game;
import Damas.damas.models.State;
import Damas.damas.views.ErrorView;
import Damas.damas.views.PlayView;

public class PlayController extends InteractorController {

	private CancelController cancelController;
	private MoveController moveController;
	private String readedCoordinates;
	private PlayView playView;
	
	public PlayController(Game game, State state) {
		super(game, state);
		this.cancelController = new CancelController(game, state);
		this.moveController = new MoveController(game, state);
	}

	@Override
	public void control() {
		this.playView = new PlayView(); 
		readMovement();
		
	}
//	
//	public Error move(Coordinate... coordinates) {
//		return this.moveController.move(coordinates);
//	}
//
//	public void cancel() {
//		this.cancelController.cancel();
//	}
//
//	public Color getColor() {
//		return this.game.getTurnColor();
//	}
//
//	public boolean isBlocked() {
//		return this.game.isBlocked();
//	}


	private void readMovement() {
		Error error;
		do {
			error = Error.NULL;
			this.readedCoordinates = this.playView.read(this.game.getTurnColor());
			if (this.playView.isCanceledFormat(readedCoordinates))
				this.cancelController.cancel();
			else if (!this.playView.isMoveFormat(readedCoordinates)) {
				error = Error.BAD_FORMAT;
				new ErrorView(error).writeln();
			} else {
				error = writeMovement();
			}
		} while (!error.isNull());
	}
	
	private Error writeMovement() {
		Error error = this.moveController.move(this.getCoordinates());
		if (!error.isNull()) {
			new ErrorView(error).writeln();
		} else {
			writeGame(this);
			if (this.game.isBlocked())
				this.playView.writeLost();
		}
		return error;
	}
	
	private Coordinate[] getCoordinates() {
		assert this.playView.isMoveFormat(this.readedCoordinates);
		String[] subCorrdenates = this.readedCoordinates.split("\\.");
		Coordinate[] coordinates = new Coordinate[subCorrdenates.length];
		for (int i = 0; i < subCorrdenates.length; i++) {
			coordinates[i] = Coordinate.getInstance(subCorrdenates[i]);
		}
		return coordinates;
	}

}