import java.util.LinkedList;
import java.util.Queue;
//
//public class RoundRobinScheduler {
//    public static void roundRobinScheduling(int[] arrivalTime, int[] burstTime, int timeSlice) {
//        int n = arrivalTime.length;
//        Queue<Integer> queue = new LinkedList<>();
//        int[] remainingTime = new int[n];
//
//        // نسخ بيانات الانفجار الأصلية إلى مصفوفة البقاء على قيد الحياة
//        for (int i = 0; i < n; i++) {
//            remainingTime[i] = burstTime[i];
//        }
//
//        int currentTime = 0;
//        int completedTasks = 0;
//
//        while (completedTasks < n) {
//            // إضافة المهام التي وصل وقتها إلى صف الانتظار
//            for (int i = 0; i < n; i++) {
//                if (arrivalTime[i] <= currentTime && remainingTime[i] > 0) {
//                    queue.add(i);
//                }
//            }
//
//            // احتساب وقت التنفيذ للمهمة الحالية
//            if (!queue.isEmpty()) {
//                int currentTask = queue.remove();
//
//                if (remainingTime[currentTask] <= timeSlice) {
//                    // قضى المهمة كل الوقت المخصص لها
//                    currentTime += remainingTime[currentTask];
//                    remainingTime[currentTask] = 0;
//                    completedTasks++;
//                } else {
//                    // قضى المهمة جزءًا من الوقت المخصص لها وسيتم التبديل
//                    currentTime += timeSlice;
//                    remainingTime[currentTask] -= timeSlice;
//                }
//
//                System.out.println("Task " + currentTask + " executed at time " + currentTime);
//            } else {
//                // لا توجد مهمة جاهزة للتنفيذ، انتقل إلى الوقت التالي
//                currentTime++;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arrivalTime = {0, 2, 4, 6}; // أوقات الوصول للمهام
//        int[] burstTime = {5, 3, 2, 4}; // أوقات الانفجار للمهام
//        int timeSlice = 3; // وقت التصفية
//
//        roundRobinScheduling(arrivalTime, burstTime, timeSlice);
//    }
//}


public class RoundRobinScheduling {
    public static void schedule(Queue<String> readyQueue, int timeQuantum) {
        while (!readyQueue.isEmpty()) {
            String process = readyQueue.poll(); // Dequeue the process from the front of the ready queue

            // Execute the process for the time quantum
            System.out.println("Executing process: " + process);
            // Simulate process execution by delaying for a fixed time period
            try {
                Thread.sleep(timeQuantum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check if the process has completed within the time quantum
            if (Math.random() > 0.5) {
                System.out.println("Process " + process + " completed.");
            } else {
                System.out.println("Process " + process + " did not complete within the time quantum.");
                readyQueue.offer(process); // Enqueue the process back into the ready queue
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> readyQueue = new LinkedList<>();
        readyQueue.offer("Process A");
        readyQueue.offer("Process B");
        readyQueue.offer("Process C");
        readyQueue.offer("Process D");

        int timeQuantum = 100; // Time quantum in milliseconds

        schedule(readyQueue, timeQuantum);
    }
}
