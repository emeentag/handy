/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package fsm.view;

import fsm.event.IEvent;

public interface IView {

	public void execute(IEvent event);

}
