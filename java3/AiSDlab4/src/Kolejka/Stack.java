package Kolejka;

public interface Stack extends Queue {
    
    public void push(Object value); // od³ó¿ na stos
    public Object pop() ;//throws EmptyStackException; //pobierz ze stosu
    public Object peek() ;//throws EmptyStackException; //odczytaj ( nieniszcz¹co ) ze stosu 
    public void clear(); //czyœæ stos
    public int size(); // wysokoœæ stosu
    public boolean isEmpty(); //true jeœli stos jest pusty
}
