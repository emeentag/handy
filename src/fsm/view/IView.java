package fsm.view;

import fsm.event.Event;

public interface IView {
	
	public void execute(Event event);

}
