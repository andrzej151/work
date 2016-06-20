package Slownik;

public class InsertSort  {
    private final Comparator _comparator;

    public InsertSort(Comparator comparator)  { _comparator = comparator; }

    public String[] sort(String[] list) {
    	int i, j; 
    	String newValue;
        for (i = 1; i < list.length; i++) {
              newValue = list[i];
              j = i;
              while (j > 0 && (list[j - 1].compareTo(newValue)>=0)) {
                    list[j] = list[j - 1];
                    j--;
              }
              list[j] = newValue;
        }
        return list;
    }
}
