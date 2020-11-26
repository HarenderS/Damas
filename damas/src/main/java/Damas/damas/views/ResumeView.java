package Damas.damas.views;

import Damas.damas.utils.YesNoDialog;

public class ResumeView{

    private static final String MESSAGE = "¿Queréis jugar otra";
    
    public Boolean readResume() {
    	return new YesNoDialog().read(ResumeView.MESSAGE);
    }

}
