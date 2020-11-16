package Damas.damas.models;

public class GameBuilder {

	public Game game;
	public Board board;
	
	public GameBuilder() {
		this.board = new Board();
	}

	public Game build() {
		this.game = new Game(this.board);
		return this.game;
	}
	
	public GameBuilder createBoard(String... positions) {
		for (int i = 0; i < Coordinate.getDimension(); i++) {
			for (int j = 0; j < positions[i].length(); j++) {
				Color color = getColor(positions[i].charAt(j));
				if (color != null) {
					if (Character.isUpperCase(positions[i].charAt(j))) {
						this.board.put(new Coordinate(i, j), new Draught(color));
					} else {
						this.board.put(new Coordinate(i, j), new Pawn(color));
					}
				}
			}
		}
		return this;
	}
	
	public Color getColor(char c) {
		switch (c) {
		case 'n':
		case 'N':
			return Color.BLACK;
		case 'b':
		case 'B':	
			return Color.WHITE;
		default:
			return null;
		}
	}
}

