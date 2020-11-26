package Damas.damas.views;

import Damas.damas.models.Error;

public class ErrorView extends SubView{

	public final static String[] ERRORMESSAGE = {
			"Error!!! Formato incorrecto",
			"Error!!! There is nothing in the origen",
			"Error!!! This is not your piece",
			"Error!!! This move is not in diagonal",
			"Error!!! The target coordinate is not empty",
			"Error!!! You can only move to front",
			"Error!!! Move without eating",
			"Error!!! You can't eat your own piece",
			"Error!!! Too much eat",
			"Error!!! Too much jumps"
		};
		
		protected Error error;
		
		public ErrorView(Error error) {
			this.error = error;
		}
		
		public void writeln() {
			if (!error.isNull()){
				this.console.writeln(ErrorView.ERRORMESSAGE[this.error.ordinal()]);
			}
		}
		
}
