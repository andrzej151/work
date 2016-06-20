package Dysk;


public class ArrayIterator implements Iterator

{   final Object[] _array;
    final int _first;
    final int _last;
    int _current=-1;
   
    public ArrayIterator(Object[] array, int start, int length)
    {_array=array;
     _first=start;
     _last=start+length-1;
    }
    
    public ArrayIterator(Object[] array)
    {_array=array;
     _first=0;
     _last=array.length-1;
    }
    

    public void first()
    { _current=_first; }
 
    public void last()
    { _current=_last; }

    public void next()
    {++_current;}
 
    
    public void previous()
    {--_current; }

    public boolean isDone()
    {return _current <_first || _current> _last; }

    public Object current()
    { return _array[_current];}
}


