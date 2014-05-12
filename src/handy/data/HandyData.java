/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy.data;

import handy.view.IView;

public class HandyData {

	private int eid;
	private IView view;

	public HandyData() {

	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public IView getView() {
		return view;
	}

	public void setView(IView view) {
		this.view = view;
	}

}
