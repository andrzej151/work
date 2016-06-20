package Slownik;

public class ShakerSort {
	private final Comparator _comparator;

	public ShakerSort(Comparator comparator) {
		_comparator = comparator;
	}

	public void sort(Towar[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			boolean swapped = false;
			for (int j = i; j < array.length - i - 1; j++) {
				if (_comparator.compare(array[j],array[j + 1]) >= 0) {
					Towar tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					swapped = true;
				}
			}

			for (int j = array.length - 2 - i; j > i; j--) {
				if (_comparator.compare(array[j],array[j - 1]) <= 0) {
					Towar tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
					swapped = true;
				}
			}

			if (!swapped)
				break;

		}

	}
}