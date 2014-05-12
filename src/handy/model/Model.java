/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy.model;

import handy.Handy;
import handy.event.IEvent;
import handy.view.IView;

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
