package SortingAlgorithm;

public class HeapSort {
    // Need to be reviewed/
    int[] a;
    int n;
    int left;
    int right;
    int largest;

    public void buildHeap(){
        for(int i = this.n/2; i >= 0;i--){
            maxHeap(i);
        }
    }

    public void maxHeap(int i){
        left = 2*i;
        right = 2*i+1;
        largest = i;
        if(left < n && a[left] > a[i])
            largest = left;
        if(right < n && a[right] > a[largest])
            largest = right;
        if (largest != i){
            exchange(largest,i);
            maxHeap(largest);
        }
    }

    public void exchange(int a, int b){
        int temp  = this.a[a];
        this.a[a] = this.a[b];
        this.a[b] = temp;
    }

    public void sort(){
        buildHeap();
        for(int i = n; i>0; i--){
            exchange(0,i);
            n = n-1;
            maxHeap(0);
        }
    }

    public HeapSort(int[] a) {
        this.a = a;
        this.n = a.length - 1;
    }

    public static void main(String[] args){
        int[] a = {1,3,0,4,5,6,32,22};
        HeapSort heapSort = new HeapSort(a);
        heapSort.sort();
        for (int i : heapSort.a){
            System.out.println(i);
        }
    }
}
