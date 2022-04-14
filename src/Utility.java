public class Utility {
    public static <T> void swap(T[]arr, int i, int j) {
        if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static <T> T[] repeat(T[] arr, int n) {
        T[] result = (T[]) new Object[n*arr.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i*arr.length+j] = arr[j];
            }
        }
        return result;
    }

    public static <T> String join(T[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if ( i == arr.length-1){
                result += arr[i];
            }
            else{
                result += arr[i] + ",";
            }
        }
        return result;
    }

    public static <T extends Number> double sum(T[] arr) {
        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i].doubleValue();
        }
        return result;
    }
}
