package Damas.damas.controllers;

import Damas.damas.models.Game;
import Damas.damas.models.State;

class CancelController extends Controller {

    protected CancelController(Game game, State state) {
        super(game, state);
    }

    public void cancel() {
		this.game.cancel();
		this.state.next();
	}

}