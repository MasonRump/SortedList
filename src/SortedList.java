import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String value) {
        int index = binarySearchInsert(value);
        list.add(index, value);
    }

    public int binarySearch(String target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = list.get(mid).compareTo(target);

            if (compare == 0) {
                return mid; // found
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -(low + 1);
    }

    private int binarySearchInsert(String value) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid).compareTo(value) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public String search(String value) {
        int result = binarySearch(value);

        if (result >= 0) {
            return "FOUND at index: " + result;
        } else {
            int insertPos = -(result + 1);
            return "NOT FOUND. Would be at index: " + insertPos;
        }
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}