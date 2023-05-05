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
    if (state.action.equals("Left button pressed")) {
      notifySubscribers(MouseEventType.SingleClick);
    }
    state.setState("Idle", currentTimeInMilliseconds);
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
