/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy.event;

import handy.data.EventData;

public class Event {
	private int eid;
	private EventData data;

	public Event() {
		
	}

	public Event(int eid, EventData data) {
		setEid(eid);
		setData(data);
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public EventData getData() {
		return data;
	}

	public void setData(EventData data) {
		this.data = data;
	}

}
