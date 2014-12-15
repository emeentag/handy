/*
 * Project: Handy
 * Author : Serdar SIMSEK - ssimsek@outlook.com
 * Desc   : An event-handler system;
 */

package handy.eventhandler;

import handy.event.Event;

public interface IEventHandler {

	public void execute(Event event);

}
