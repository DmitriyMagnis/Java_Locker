package app;

public class AppController {
    public void runApp() {

        int[] numbers = new DataRepository().getData();

        Thread thread_1 = new Thread(createTask(numbers), "Thread-1");

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
