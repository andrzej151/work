package Slownik;



public class QuickSort  {
    private final Comparator _comparator;

   public QuickSort(Comparator comparator)  { _comparator = comparator; }

   // wynikiem jest posortowana oryginalna lista
   public String[] sort(String [] list) {
       quicksort(list, 0, list.length - 1);
       return list;
   }

   private void quicksort(Object[] list, int startIndex, int endIndex) {
       if (endIndex > startIndex) {
       int partition = partition(list, startIndex, endIndex);
       quicksort(list, startIndex, partition );
       quicksort(list, partition + 1, endIndex);
       }
   }
  // podzia³ wed³ug Lomuto   
  private int partition(Object[] list, int left, int right) {
      //jako element dziel¹cy bierzemy ostatni
      Object value=list[right];
      int i=left-1;
      while (left <= right){
           if( _comparator.compare(list[left], value) <= 0)
                swap(list, ++i,left);
           ++left;
           }

       return i<right ? i :i-1;
   }   
  
   private void swap(Object[] list, int left, int right) {
       if (left != right) {
          Object temp = list[left];
          list[left]= list[right];
          list[right]= temp;
       }   
   }
}
