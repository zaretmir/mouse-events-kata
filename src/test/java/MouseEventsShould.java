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

}
