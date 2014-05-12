/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package fsm.model;

import fsm.Handy;
import fsm.event.IEvent;
import fsm.view.IView;

public class Model {

	public Model() {

	}

	public void raiseEvent(IEvent event) {
		Handy.getInstance().invokeEventHandler(event);
	}

	public void addEventHandler(int eid, IView view) {
		Handy.getInstance().registerToEvent(eid, view);
	}

	public void removeEventHandler(int eid, IView view) {
		Handy.getInstance().deregisterFromEvent(eid, view);
	}

}
