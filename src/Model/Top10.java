package Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Top10
  {

    private Map<String, Integer> top10;

    public Top10()
      {
        top10 = Collections.synchronizedMap(new HashMap<String, Integer>());
      }

    public void showTop10()
      {
        Map<String, Integer> sortedTop10 = new TreeMap<>(new ValueComparator(top10));
        sortedTop10.putAll(top10);
        int counter = 1;
        for (Map.Entry<String, Integer> entry : sortedTop10.entrySet())
          {
            counter++;
            System.out.println(entry.getKey() + ": " + entry.getValue());
            if (counter > 10)
              {
                break;
              }
          }
        System.out.println("Printed top 10");
      }

    public void addResult(String fileName, int count)
      {
        top10.put(fileName, count);
      }

    public void clearTop10()
      {
        top10 = null;
      }

    class ValueComparator implements Comparator<String>
      {

        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base)
          {
            this.base = base;
          }

        @Override
        public int compare(String a, String b)
          {
            if (base.get(a) >= base.get(b))
              {
                return -1;
              }
            else
              {
                return 1;
              }
          }
      }
  }
