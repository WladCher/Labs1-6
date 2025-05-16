import java.util.Scanner;

public class Hipui {

    static class BinaryMaxHeap {
        int[] data;
        int size;

        BinaryMaxHeap(int capacity) {
            data = new int[capacity];
            size = 0;
        }

        void add(int value) {
            data[size] = value;
            siftUp(size++);
        }

        int removeMax() {
            int max = data[0];
            data[0] = data[--size];
            siftDown(0);
            return max;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (data[index] > data[parent]) {
                    swap(index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        private void siftDown(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int largest = index;

                if (left < size && data[left] > data[largest]) {
                    largest = left;
                }
                if (right < size && data[right] > data[largest]) {
                    largest = right;
                }
                if (largest != index) {
                    swap(index, largest);
                    index = largest;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = scanner.nextInt();
        BinaryMaxHeap heap = new BinaryMaxHeap(commands);

        for (int i = 0; i < commands; i++) {
            int type = scanner.nextInt();
            if (type == 0) {
                heap.add(scanner.nextInt());
            } else if (type == 1) {
                System.out.println(heap.removeMax());
            }
        }

        scanner.close();
    }
}
