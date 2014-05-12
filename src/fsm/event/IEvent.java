/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package fsm.event;

import fsm.data.EventData;

public interface IEvent {

	public void execute(IEvent event);

	public int getEid();

	public void setEid(int eid);

	public EventData getData();

	public void setData(EventData data);

}
