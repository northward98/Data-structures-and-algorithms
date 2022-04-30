package exercise.sort;

/**
 * 选择排序
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 1, 3, 6};
        System.out.println("排序前");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println();

        selectSort(arr);
        System.out.println("排序后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i; //最小元素索引，初始化为 i
            //从 i+1 处开始遍历
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])//有比最小元素索引处更小的元素，更新索引
                    minIndex = j;
            }

            if (minIndex != i) {//若 minIndex 不等于 i，交换元素，是有序区间的元素有序
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
