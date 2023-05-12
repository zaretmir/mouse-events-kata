package mouseeventskata;

import java.util.ArrayList;
import java.util.List;

public class Mouse {
  private List<MouseEventListener> listeners = new ArrayList<>();
  private final long timeWindowInMillisecondsForDoubleClick = 500;
  private MouseState state = new MouseState();

  public void pressLeftButton(long currentTimeInMilliseconds){
    /*... debe notificar a los suscriptores ...*/
    /*... y gestionar el estado ...*/
    state.setState("Left button pressed", currentTimeInMilliseconds);
  }

  public void releaseLeftButton(long currentTimeInMilliseconds){
    /*... debe notificar a los suscriptores ...*/
    /*... y gestionar el estado ...*/
    boolean doubleClickTimeWindowPassed = (currentTimeInMilliseconds - state.executionTimestamp) > timeWindowInMillisecondsForDoubleClick;
    if (state.action.equals("Left button pressed") && doubleClickTimeWindowPassed) {
      notifySubscribers(MouseEventType.SingleClick);
      state.setState("Idle", currentTimeInMilliseconds);
    }
    if (state.action.equals("Left button pressed") && !doubleClickTimeWindowPassed) {
      state.setState("Maybe double click", state.executionTimestamp);
    }
    if (state.action.equals("Maybe double click & left button pressed (back)") && doubleClickTimeWindowPassed) {
      notifySubscribers(MouseEventType.SingleClick);
      state.setState("Idle", currentTimeInMilliseconds);
    }



    else if (state.action.equals("Maybe double click")) {

    }
  }

  public void move(Position from, Position to,long
    currentTimeInMilliseconds){
    /*... debe notificar a los suscriptores ...*/
    /*... y gestionar el estado ...*/
  }

  public void subscribe(MouseEventListener listener){
    listeners.add(listener);
  }

  private void notifySubscribers(MouseEventType eventType) {
    listeners.forEach(listener -> listener.handleMouseEvent(eventType));
  }
}
