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

	private ArrayList<ArrayList<HandyData>> eventList;

	public Handy() {
		eventList = new ArrayList<ArrayList<HandyData>>();
	}

	private void registerToEvent(int eid, IEventHandler handler)
			throws Exception {
		// Need to find the actual eventList. If it is exist return it else
		// create a new one then return it.
		// After find it bind the handler on it. If not find it add the handler
		// to the actual eventList.
		ArrayList<HandyData> eventHandlerList = decideEventHandlerList(eid);

		if (isHandlerBindedToEvent(eventHandlerList, handler)) {
			throw new Exception("This handler already binded to this event: "
					+ eid + " before!");
		} else {
			HandyData data = new HandyData();
			data.setEid(eid);
			data.setHandler(handler);
			eventHandlerList.add(data);
		}
	}

	private void deregisterFromEvent(int eid, IEventHandler handler)
			throws Exception {
		// Need to find the actual eventList. If it is exist return it else
		// create a new one then return it.
		// After find it de-register the handler on it. If not find it throw
		// exception.
		ArrayList<HandyData> eventHandlerList = decideEventHandlerList(eid);

		// Need to remove eventList from the eventGroup. Because we should not
		// add and empty evenList to the eventGroup.
		if (eventHandlerList.isEmpty()) {
			eventList.remove(eventHandlerList);
			throw new Exception(
					"This handler is tried to de-register from this event: "
							+ eid
							+ " which was not exist! \nHandler needs to be binded first to this event, for removing.");
		}

		if (isHandlerBindedToEvent(eventHandlerList, handler)) {
			// This handler is binded this event so let's remove handler.
			removeHandler(eventHandlerList, handler);
			return;
		}

		// This handler wasn't binded to this event before!
		// It needs to be binded first to remove.
		throw new Exception("This handler was not binded to this event: " + eid
				+ " before! \nIt needs to be binded first to remove.");
	}

	private void removeHandler(ArrayList<HandyData> eventHandlerList,
			IEventHandler handler) {
		for (int i = 0; i < eventHandlerList.size(); i++) {
			if (handler.equals(eventHandlerList.get(i).getHandler())) {
				eventHandlerList.remove(i);
				if (eventHandlerList.isEmpty()) {
					eventList.remove(eventHandlerList);
				}
				return;
			}
		}
	}

	private void invokeEventHandler(Event event) throws Exception {
		// Need to find the actual eventList. If it is exist return it else
		// create a new one then return it.
		// After find it invoke the handler-s on it.
		ArrayList<HandyData> eventHandlerList = decideEventHandlerList(event
				.getEid());

		// Need to remove eventList from the eventGroup. Because we should not
		// add and empty evenList to the eventGroup.
		if (eventHandlerList.isEmpty()) {
			eventList.remove(eventHandlerList);
			throw new Exception(
					"There is no handler to be binded this event: "
							+ event.getEid()
							+ " \nIt is not allowed to raise an event which is not listened by any handler.");
		}
		
		for (int i = 0; i < eventHandlerList.size(); ++i) {
			eventHandlerList.get(i).getHandler().execute(event);
		}
	}

	private boolean isHandlerBindedToEvent(ArrayList<HandyData> eventList,
			IEventHandler handler) {
		for (int i = 0; i < eventList.size(); ++i) {
			if (handler.equals(eventList.get(i).getHandler())) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<HandyData> decideEventHandlerList(int eid) {
		ArrayList<HandyData> eventHandlerList;
		for (int i = 0; i < eventList.size(); i++) {
			eventHandlerList = eventList.get(i);
			// Check for understanding, is this event grouped before.
			if (eventHandlerList.get(0).getEid() == eid) {
				// Already grouped before.
				return eventHandlerList;
			}
		}
		eventHandlerList = new ArrayList<HandyData>();
		eventList.add(eventHandlerList);

		return eventHandlerList;
	}

	// Main functions.
	public void raiseEvent(Event event) {
		try {
			invokeEventHandler(event);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void addEventHandler(int eid, IEventHandler handler) {
		try {
			registerToEvent(eid, handler);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void removeEventHandler(int eid, IEventHandler handler) {
		try {
			deregisterFromEvent(eid, handler);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
