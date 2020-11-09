package Damas.damas.controllers;

import Damas.damas.models.Color;
import Damas.damas.models.Coordinate;
import Damas.damas.models.Game;
import Damas.damas.models.State;

class Controller {

    protected Game game;
    protected State state;

    protected Controller(Game game, State state) {
        assert game != null;
        assert state != null;
        this.game = game;
        this.state = state;
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.game.getColor(coordinate);
    }

    public int getDimension() {
        return this.game.getDimension();
    }

}
