package Damas.damas.views;

import java.util.regex.Pattern;

import Damas.damas.controllers.PlayController;
import Damas.damas.models.Color;
import Damas.damas.models.Coordinate;
import Damas.damas.models.Error;

class PlayView extends SubView {

	private static final String COLOR_PARAM = "#color";
	private static final String[] COLOR_VALUES = { "blancas", "negras" };
	private static final String PROMPT = "Mueven las " + PlayView.COLOR_PARAM + ": ";
	private static final String CANCEL_FORMAT = "-1";
	private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
	private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
	private String string;

	PlayView() {
		super();
	}

	void interact(PlayController playController) {
		assert playController != null;
		readMovement(playController);
	}

	private void readMovement(PlayController playController) {
		Error error;
		do {
			error = null;
			this.string = this.read(playController.getColor());
			if (this.isCanceledFormat())
				playController.cancel();
			else if (!this.isMoveFormat()) {
				error = Error.BAD_FORMAT;
				new ErrorView(error).writeln();
			} else {
				error = writeMovement(playController);
			}
		} while (error != null);
	}

	private Error writeMovement(PlayController playController) {
		Error error = playController.move(this.getCoordinates());
		if (error != null) {
			new ErrorView(error).writeln();
		} else {
			new GameView().write(playController);
			if (playController.isBlocked())
				this.writeLost();
		}
		return error;
	}

	private String read(Color color) {
		final String titleColor = PlayView.PROMPT.replace(PlayView.COLOR_PARAM, PlayView.COLOR_VALUES[color.ordinal()]);
		return this.console.readString(titleColor);
	}

	private boolean isCanceledFormat() {
		return string.equals(PlayView.CANCEL_FORMAT);
	}

	private boolean isMoveFormat() {
		return Pattern.compile(PlayView.MOVEMENT_FORMAT).matcher(string).find();
	}

	private Coordinate[] getCoordinates() {
		assert this.isMoveFormat();
		String[] subCorrdenates = string.split("\\.");
		Coordinate[] coordinates = new Coordinate[subCorrdenates.length];
		for (int i = 0; i < subCorrdenates.length; i++) {
			coordinates[i] = Coordinate.getInstance(subCorrdenates[i]);
		}
		return coordinates;
	}

	private void writeLost() {
		this.console.writeln(LOST_MESSAGE);
	}

}