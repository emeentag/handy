package fsm.controller;

import fsm.model.Model;

public class Controller {

	Model model;
	
	public Controller(Model model){
		this.model = model;
		initiateFSM();
	}

	private void initiateFSM() {
		//FSM.getInstance
		
	}

	public String toUpperCase(String str) {
		return str.toUpperCase();
		
	}

	public String splitText(String str){
		return str.split("_")[1];
	}
	
	
	
}
