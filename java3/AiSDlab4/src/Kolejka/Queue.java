package Kolejka;

public interface Queue {
	 
    public void enqueue(Object value); //wstaw do kolejki
    public Object dequeue() ;//throws EmptyQueueException; //pobierz z kolejki
    public void clear(); //usuñ wszystkie elementy
    public int size();  //d³ugoœæ kolejki
    public boolean isEmpty(); // true jeœli kolejka jest pusta
}
