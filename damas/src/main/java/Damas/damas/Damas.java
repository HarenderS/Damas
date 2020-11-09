package Damas.damas;

import Damas.damas.controllers.InteractorController;
import Damas.damas.controllers.Logic;
import Damas.damas.views.View;

public class Damas {
	private View view;
    private Logic logic;

    private Damas(){
        this.view = new View();
        this.logic = new Logic();
    }

    private void play() {
        InteractorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null)
				this.view.interact(controller);
		} while (controller != null); 
    }

    public static void main(String[] args){
        new Damas().play();
    }
}
