package mouseeventskata;

public class MouseState {
  String action;
  long executionTimestamp;

  public void setState(String action, long executionTimestamp){
    this.action = action;
    this.executionTimestamp = executionTimestamp;
  }
}
