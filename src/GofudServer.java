import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GofudServer implements EventBroker {
  // maps a topic to a list of subscribers
  // feel free to change/add data structures
  private Map<String, ArrayList<Subscriber>> topics;

  public GofudServer() {
    this.topics = new HashMap<String, ArrayList<Subscriber>>();
  }

  // TODO: method when server/broker is sending an event through a topic
  public void sendEvent(String topic, Event event) {
    if (topics.containsKey(topic)){
        List<Subscriber> temp = topics.get(topic);
        for (Subscriber s : temp) {
            s.onEvent(event);
        }    
    }
  }
  
  // TODO: method when a subscriber wants to subscribe to a topic
  public void addSubscriber(String topic, Subscriber subscriber) {
    ArrayList<Subscriber> s;
    if (topics.containsKey(topic)) {
      s = topics.get(topic);
    }
    else {
      s = new ArrayList<Subscriber>();
    }
    s.add(subscriber);
    topics.put(topic, s);
  }
}