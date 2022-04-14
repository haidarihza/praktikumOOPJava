public class ListMap implements Map {
    private ListMapEntry first;

    public void set(String key, String value) {
        ListMapEntry curr = this.first;
        Boolean isFound = false;
        if (curr == null){
            ListMapEntry newmap = new ListMapEntry(key, value);
            first = newmap;
            isFound = true;
        }
        else{
            while ((curr.getNext() != null) && !isFound) {
                if (curr.getKey().equals(key)){
                    curr.setValue(value);
                    isFound = true;
                }
                curr = curr.getNext();
            }
            if (curr.getKey().equals(key)){
                curr.setValue(value);
                isFound = true;
            }
            if (!isFound) {
                ListMapEntry newmap = new ListMapEntry(key, value);
                curr.setNext(newmap);
            }
        }
    }

    public String get(String key) {
        ListMapEntry curr = this.first;
        Boolean isFound = false;
        String result = null;
        while ((curr != null) && !isFound) {
            if (curr.getKey().equals(key)){
                isFound = true;
                result = curr.getValue();
            }
            curr = curr.getNext();
        }
        return result;
    }

    public int size() {
        ListMapEntry curr = this.first;
        int count = 0;
        while (curr != null) {
            count += 1;
            curr = curr.getNext();
        }
        return count;
    }
}
