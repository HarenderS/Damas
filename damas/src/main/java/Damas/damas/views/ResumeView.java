package Damas.damas.views;

import Damas.damas.controllers.ResumeController;
import Damas.damas.utils.YesNoDialog;

class ResumeView extends SubView {

    private static final String MESSAGE = "¿Queréis jugar otra";
    
    private YesNoDialog yesNoDialog;

    ResumeView(){
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    void interact(ResumeController resumeController) {
        assert resumeController != null;
        if (this.yesNoDialog.read(ResumeView.MESSAGE))
            resumeController.reset();
        else
            resumeController.next();
    }

}
