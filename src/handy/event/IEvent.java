/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy.event;

import handy.data.EventData;

public interface IEvent {

	public int getEid();

	public void setEid(int eid);

	public EventData getData();

	public void setData(EventData data);

}
