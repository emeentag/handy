/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy;

import handy.data.HandyData;
import handy.event.Event;
import handy.view.IView;

import java.util.ArrayList;

public class Handy {

	private static Handy instance;
	private ArrayList<HandyData> eventList = new ArrayList<HandyData>();

	public Handy() {
	}

	public static Handy getInstance() {
		if (instance != null) {
			return instance;
		}
		return instance = new Handy();
	}

	public void registerToEvent(int eid, IView view) {
		HandyData data = new HandyData();
		data.setEid(eid);
		data.setView(view);
		eventList.add(data);
	}

	public void deregisterFromEvent(int eid, IView view) {
		for (int i = 0; i < eventList.size(); ++i) {
			if (eventList.get(i).getEid() == eid
					&& view.equals(eventList.get(i).getView())) {
				eventList.remove(i);
			}
		}
	}

	public void invokeEventHandler(Event event) {
		for (int i = 0; i < eventList.size(); ++i) {
			if (eventList.get(i).getEid() == event.getEid()) {
				eventList.get(i).getView().execute(event);
			}
		}
	}

}
