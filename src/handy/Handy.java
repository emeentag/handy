/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy;

import handy.data.HandyData;
import handy.event.Event;
import handy.eventhandler.IEventHandler;

import java.util.ArrayList;

public class Handy {

	private ArrayList<HandyData> eventList = new ArrayList<HandyData>();

	public Handy() {

	}

	private void registerToEvent(int eid, IEventHandler handler) {
		HandyData data = new HandyData();
		data.setEid(eid);
		data.setHandler(handler);
		eventList.add(data);
	}

	private void deregisterFromEvent(int eid, IEventHandler handler) {
		for (int i = 0; i < eventList.size(); ++i) {
			if (eventList.get(i).getEid() == eid
					&& handler.equals(eventList.get(i).getHandler())) {
				eventList.remove(i);
			}
		}
	}

	private void invokeEventHandler(Event event) {
		for (int i = 0; i < eventList.size(); ++i) {
			if (eventList.get(i).getEid() == event.getEid()) {
				eventList.get(i).getHandler().execute(event);
			}
		}
	}

	public void raiseEvent(Event event) {
		invokeEventHandler(event);
	}

	public void addEventHandler(int eid, IEventHandler handler) {
		registerToEvent(eid, handler);
	}

	public void removeEventHandler(int eid, IEventHandler handler) {
		deregisterFromEvent(eid, handler);
	}

}
