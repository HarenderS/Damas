package Damas.damas.views;

import Damas.damas.controllers.InteractorController;
import Damas.damas.controllers.InteractorControllersVisitor;
import Damas.damas.controllers.PlayController;
import Damas.damas.controllers.ResumeController;
import Damas.damas.controllers.StartController;

public class View implements InteractorControllersVisitor {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View(){
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    public void interact(InteractorController controller) {
        assert controller != null;
        controller.accept(this);
    }

	public void visit(StartController startController) {
        assert startController != null;
        this.startView.interact(startController);
		
	}

	public void visit(PlayController playController) {
        assert playController != null;
        this.playView.interact(playController);
		
	}

	public void visit(ResumeController resumeController) {
        assert resumeController != null;
        this.resumeView.interact(resumeController);
		
	}

}
