package Kolejka;

public interface Queue {
	 
    public void enqueue(Object value); //wstaw do kolejki
    public Object dequeue() ;//throws EmptyQueueException; //pobierz z kolejki
    public void clear(); //usu� wszystkie elementy
    public int size();  //d�ugo�� kolejki
    public boolean isEmpty(); // true je�li kolejka jest pusta
}
