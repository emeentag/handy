package fsm.event;

import fsm.data.EventData;

public abstract class Event {

	public int eid;
	
	private EventData data;
	
	public Event(int eid){
		this.eid = eid;
	}

	public Event(int eid, EventData data){
		setEid(eid);
		setData(data);
	}
	
	public int getEid() {
		return this.eid;
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
