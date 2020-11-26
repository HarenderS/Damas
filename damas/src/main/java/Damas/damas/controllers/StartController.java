package Damas.damas.controllers;

import Damas.damas.models.Game;
import Damas.damas.models.State;
import Damas.damas.views.StartView;

public class StartController extends InteractorController{

	public StartController(Game game, State state) {
        super(game, state);
	}

	@Override
	public void control() {
		new StartView().start();
		writeGame(this);
		next();
	}

}
