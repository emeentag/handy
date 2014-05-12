/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy.data;

import handy.eventhandler.IEventHandler;

public class HandyData {

	private int eid;
	private IEventHandler handler;

	public HandyData() {

	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public IEventHandler getHandler() {
		return handler;
	}

	public void setHandler(IEventHandler handler) {
		this.handler = handler;
	}

}
