package Kolejka;

public interface Stack extends Queue {
    
    public void push(Object value); // od�� na stos
    public Object pop() ;//throws EmptyStackException; //pobierz ze stosu
    public Object peek() ;//throws EmptyStackException; //odczytaj ( nieniszcz�co ) ze stosu 
    public void clear(); //czy�� stos
    public int size(); // wysoko�� stosu
    public boolean isEmpty(); //true je�li stos jest pusty
}
