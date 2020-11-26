package Damas.damas.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import Damas.damas.controllers.ResumeController;
import Damas.damas.views.ResumeView;

public class ResemeControllerTest {

	@Mock
	public ResumeController resumeController;
	
	@Mock
	public ResumeView resumeView;
	
	@Before
	public void test() {
		initMocks(this);
	}
	
	@Test
	public void resumeReciveTrueAndResetTest() {
		when(resumeView.readResume()).thenReturn(true);
		
		resumeController.control();
		verify(resumeController).next();
	}
}
