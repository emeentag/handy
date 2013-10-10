package fsm;

import java.util.ArrayList;

import fsm.data.FSMData;
import fsm.event.Event;
import fsm.model.Model;
import fsm.view.IView;

public class FSM {

	private static FSM instance;
	private ArrayList<FSMData> eventList = new ArrayList<FSMData>();
	private Model model;
	FSMData data;

	public FSM(Model model) {
		this.model = model;
	}

	public static FSM getInstance(Model model) {
		if (instance != null) {
			return instance;
		} else {
			return instance = new FSM(model);
		}
	}
	
	public void registerForEvent(int eid, IView view){
		data = new FSMData();
		data.eid = eid;
		data.view = view;
		eventList.add(data);
	}
	
	public void deregisterForEvent(int eid, IView view){
		for(int i = 0; i < eventList.size(); i++){
			if(eventList.get(i).eid == eid && view.equals(eventList.get(i).view)){
				eventList.remove(i);
			}
		}
	}
	
	public void invokeEventHandler(Event event){
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).eid == event.getEid()) {
				eventList.get(i).view.execute(event);
			}
		}
	}

}
