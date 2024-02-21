import java.util.LinkedList;
import java.util.Queue;
//4. lab8
public class JosephusProblem {
    public static int josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // إضافة الأشخاص إلى صف الانتظار
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            // إزالة k-1 أشخاص من الصف
            for (int i = 0; i < k - 1; i++) {
                int person = queue.remove();
                queue.add(person);
            }

            // إزالة الشخص الحالي
            queue.remove();
        }

        // إعادة الشخص الأخير المتبقي
        return queue.peek();
    }

    public static void main(String[] args) {
        int n = 7; // عدد الأشخاص الأصلي
        int k = 3; // عدد الأشخاص المتبقيين قبل إزالة شخص واحد

        int survivor = josephus(n, k);
        System.out.println("The survivor is: " + survivor);
    }
}
