/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy.view;

import handy.event.IEvent;

public interface IView {

	public void execute(IEvent event);

}
