package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Leetcode_380 {
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}

class RandomizedSet {
    private final Map<Integer, Integer> valToIndex;
    private final List<Integer> values;
    private final Random random;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int lastValue = values.get(values.size() - 1);

        values.set(index, lastValue);
        valToIndex.put(lastValue, index);

        values.remove(values.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
