package net.tyler.messaging

import scala.collection.mutable.ArrayBuffer

abstract class StateQuerier {

  /**
   * A collection of all messages stored in the order that they arrived (not
   * necessarily time order).
   */
  protected val Buffer = new ArrayBuffer[Message]
  
  /**
   * Returns a list of all events which occurred before a given time t.
   */
  def eventsPreTickVal(t: Long) = Buffer filter {_.ticks < t}
  
  /**
   * Returns a list of all events which occurred after a given time t.
   */
  def eventsPostTickVal(t: Long) = Buffer filter {_.ticks > t}
  
  /**
   * Returns a list of all events which occurred before a given time t and that
   * match one of a list of possible message types.
   */
  def messageEvents(t: Long, messageTypes: List[Manifest[Message]]) = {
    eventsPreTickVal(t).filter((message: Message) => {
      messageTypes.contains(Manifest.classType(message.getClass))
    })
  }
}