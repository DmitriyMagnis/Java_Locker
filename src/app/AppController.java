package app;

public class AppController {
    public void runApp() {

        int[] numbers = new DataRepository().getData();

        Runnable task = createTask(numbers);
        Thread thread_1 = new Thread(task, "Thread-1");

        thread_1.start();
    }
    public Runnable createTask(int[] numbers) {
        DataHandler dataHandler = new DataHandler();
        return () -> {
            for (int num : numbers) {
                System.out.println(Thread.currentThread().getName() + " - Initial value is " + num);
                int newNum = dataHandler.modify(num);
                System.out.println(Thread.currentThread().getName() + " - New value is " + newNum);
            }
        };
    }
}
