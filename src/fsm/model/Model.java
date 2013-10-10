package fsm.model;

import fsm.FSM;
import fsm.event.Event;
import fsm.view.IView;

public class Model {
	
	String data;

	public Model(){

	}
	
	public void raiseEvent(Event event){		
		FSM.getInstance(this).invokeEventHandler(event);
	}

	public void addEventHandler(int eid, IView view){
		FSM.getInstance(this).registerForEvent(eid, view);
	}

	public void removeEventHandler(int eid, IView view){
		FSM.getInstance(this).deregisterForEvent(eid, view);
	}
	
}
