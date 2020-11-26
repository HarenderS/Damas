package Damas.damas.views;

import java.util.regex.Pattern;

import Damas.damas.controllers.PlayController;
import Damas.damas.models.Color;
import Damas.damas.models.Coordinate;
import Damas.damas.models.Error;

public class PlayView extends SubView {

	private static final String COLOR_PARAM = "#color";
	private static final String[] COLOR_VALUES = { "blancas", "negras" };
	private static final String PROMPT = "Mueven las " + PlayView.COLOR_PARAM + ": ";
	private static final String CANCEL_FORMAT = "-1";
	private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
	private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
//	private String string;

//	public PlayView() {
//		super();
//	}

//	void interact(PlayController playController) {
//		assert playController != null;
//		readMovement(playController);
//	}

//	private void readMovement(PlayController playController) {
//		Error error;
//		do {
//			error = Error.NULL;
//			this.string = this.read(playController.getColor());
//			if (this.isCanceledFormat())
//				playController.cancel();
//			else if (!this.isMoveFormat()) {
//				error = Error.BAD_FORMAT;
//				new ErrorView(error).writeln();
//			} else {
//				error = writeMovement(playController);
//			}
//		} while (!error.isNull());
//	}

//	private Error writeMovement(PlayController playController) {
//		Error error = playController.move(this.getCoordinates());
//		if (!error.isNull()) {
//			new ErrorView(error).writeln();
//		} else {
//			playController.writeGame(playController);
//			if (playController.isBlocked())
//				this.writeLost();
//		}
//		return error;
//	}

	public String read(Color color) {
		final String titleColor = PlayView.PROMPT.replace(PlayView.COLOR_PARAM, PlayView.COLOR_VALUES[color.ordinal()]);
		return this.console.readString(titleColor);
	}

	public boolean isCanceledFormat(String string) {
		return string.equals(PlayView.CANCEL_FORMAT);
	}

	public boolean isMoveFormat(String string) {
		return Pattern.compile(PlayView.MOVEMENT_FORMAT).matcher(string).find();
	}

	public void writeLost() {
		this.console.writeln(LOST_MESSAGE);
	}

}