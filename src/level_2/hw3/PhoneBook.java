package level_2.hw3;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> MAP = new HashMap<>();

    public void add(String name, String phone) {
        if (MAP.containsKey(name)) {
            MAP.get(name).add(phone);
        } else {
            List<String> list = new LinkedList<>();
            list.add(phone);
            MAP.put(name, list);
        }
    }

    public String get(String name) {
        if (MAP.containsKey(name)) {
            return MAP.get(name).toString();
        }
        return null;
    }
}
