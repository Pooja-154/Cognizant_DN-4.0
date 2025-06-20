class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "[Order ID: " + orderId + ", Customer: " + customerName + ", Total: ₹" + totalPrice + "]";
    }
}
public class Main {
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(101, "Alice", 1500.0),
            new Order(102, "Bob", 850.5),
            new Order(103, "Charlie", 2900.0),
            new Order(104, "Diana", 1200.0)
        };

        Order[] orders2 = orders1.clone();

        System.out.println("Bubble Sort by totalPrice:");
        bubbleSort(orders1);
        for (Order o : orders1) {
            System.out.println(o);
        }

        System.out.println("----");

        System.out.println("Quick Sort by totalPrice:");
        quickSort(orders2, 0, orders2.length - 1);
        for (Order o : orders2) {
            System.out.println(o);
        }
    }

    public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice <= pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
