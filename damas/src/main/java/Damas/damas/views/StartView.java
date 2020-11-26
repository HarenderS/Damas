package Damas.damas.views;

public class StartView extends SubView {

    private static final String TITTLE = "Draughts";

    public StartView(){
        super();
    }
    
    public void start() {
    	this.console.writeln(StartView.TITTLE);
    }

}
