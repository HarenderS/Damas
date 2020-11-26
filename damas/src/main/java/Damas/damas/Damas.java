package Damas.damas;

import java.util.HashMap;
import java.util.Map;

import Damas.damas.controllers.InteractorController;
import Damas.damas.controllers.PlayController;
import Damas.damas.controllers.ResumeController;
import Damas.damas.controllers.StartController;
import Damas.damas.models.Game;
import Damas.damas.models.State;
import Damas.damas.models.StateValue;

public class Damas {
	
	private Game game;
	private State state;
	private Map<StateValue, InteractorController> controllers;
	
    private Damas(){
    	this.game = new Game();
		this.state = new State();
        this.controllers = new HashMap<StateValue, InteractorController>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
		this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
		this.controllers.put(StateValue.EXIT, null);
    }

    private void play() {
        InteractorController controller;
		do {
			controller = this.controllers.get(this.state.getValueState());
			if (controller != null) {
            	controller.control();
            }
		} while (controller != null); 
    }

    public static void main(String[] args){
        new Damas().play();
    }
}
