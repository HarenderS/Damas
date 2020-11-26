package Damas.damas.controllers;

import Damas.damas.models.Game;
import Damas.damas.models.State;
import Damas.damas.views.ResumeView;

public class ResumeController extends InteractorController {

	public ResumeController(Game game, State state) {
        super(game, state);
	}

	@Override
	public void control() {
		this.resume(new ResumeView().readResume());
	}

	private void resume(Boolean reStart) {
		if (reStart) {
			this.reset();
		} else {
			next();
		}
	}
	
	private void reset() {
		this.state.reset();
		this.game.reset();
	}
}
