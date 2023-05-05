import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import mouseeventskata.Mouse;
import mouseeventskata.MouseEventListener;
import mouseeventskata.MouseEventType;
import org.junit.jupiter.api.Test;

class MouseEventsShould {

  // TODO:
  // - Notify listeners that a single click has occurred

  @Test
  void notify_listeners_that_a_single_click_has_occurred() {
    MouseEventListener listener = mock(MouseEventListener.class);
    Mouse mouse = new Mouse();
    mouse.subscribe(listener);

    int millisecondsLater = 500;
    mouse.pressLeftButton(0);
    mouse.releaseLeftButton(millisecondsLater);

    verify(listener).handleMouseEvent(MouseEventType.SingleClick);
  }

  @Test
  void notify_listeners_that_a_double_click_has_occurred() {
    MouseEventListener listener = mock(MouseEventListener.class);
    Mouse mouse = new Mouse();
    mouse.subscribe(listener);

    long initialTimestamp = 0;
    long millisecondsLater = 100;
    mouse.pressLeftButton(initialTimestamp);
    mouse.releaseLeftButton(initialTimestamp + millisecondsLater);
    mouse.pressLeftButton(initialTimestamp + millisecondsLater * 2);
    mouse.releaseLeftButton(initialTimestamp + millisecondsLater * 3);

    verify(listener).handleMouseEvent(MouseEventType.DoubleClick);
  }

}
