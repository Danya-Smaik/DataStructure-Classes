
package com.mycompany.datastructure;

public class DynamicArray {

    private double[] arr;
    private int nElement;

    public DynamicArray(int max) {
        arr = new double[max];
        nElement = 0;
    }

    public boolean isFull() {
        return nElement == arr.length;
    }

    public boolean isEmpty() {
        return nElement == 0;
    }

    public int size() {
        return nElement;
    }

    private void resize() {
        double[] newArr = new double[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void add(double num) {
        if (isFull()) {
            resize();
        }
        arr[nElement] = num;
        nElement++;
    }

    public int linearSearch(double value) {
        for (int i = 0; i < nElement; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(double value) {
        int low = 0;
        int high = nElement - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private void shiftDown(int index) {
        for (int i = nElement - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
    }

    public boolean insertAtIndex(int ind, double value) {
        if (ind < 0 || ind > nElement) {
            return false;
        }
        if (isFull()) {
            resize();
        }
        shiftDown(ind);
        arr[ind] = value;
        nElement++;
        return true;
    }

    public boolean removeAtIndex(int ind) {
        if (ind < 0 || ind >= nElement) {
            return false;
        }
        for (int i = ind; i < nElement - 1; i++) {
            arr[i] = arr[i + 1];
        }
        nElement--;
        return true;
    }

    public double get(int index) {
        if (index < 0 || index >= nElement) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return arr[index];
    }

    public void set(int index, double value) {
        if (index < 0 || index >= nElement) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        arr[index] = value;
    }

    public boolean contains(double value) {
        return linearSearch(value) != -1;
    }

    public int indexOf(double value) {
        return linearSearch(value);
    }

    public void clear() {
        nElement = 0;
    }

    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= nElement || j >= nElement) return;
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nElement; i++) {
            sb.append(arr[i]);
            if (i < nElement - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
