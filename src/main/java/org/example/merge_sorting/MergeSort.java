package org.example.merge_sorting;

/**Задача

 Есть функция сортирующая массив элементов A:
 где А - массив, p и r - номера элементов начала и конца сорировки

 Sort(A,p,r)
 1 if p < r
 2    then           q := round_half_down((p+r)/2)
 3                   Sort(A,p,q)
 4                   Sort(A,q+1,r)
 5                   Merge(A,p,q,r)

 Пример массива:
 A = (5,2,4,6,1,3,2,6)

 Примера запуска:
 Sort(A,1,length[A]) - сортировка с 1, а не с нолевого!!

 Необходимо:
 Разработать алгоритм функции Merge

  *
 */


public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 4, 6, 1, 3, 2, 6};
        sort(numbers, 0, numbers.length - 1);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static void sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(arr, p, q);
            sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[p + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[q + 1 + j];

        int i = 0, j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
