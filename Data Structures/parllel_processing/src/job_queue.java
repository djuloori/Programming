import java.util.*;

/**
 * Created by Dhruva Juloori on 7/3/2017.
 */
public class job_queue {
    static ArrayList<Integer> workerlist = new ArrayList<>();
    static ArrayList<Long> starttime = new ArrayList<>();

    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    long num_of_workers = input.nextLong();
    long num_of_jobs = input.nextLong();
    long[] job_durations = new long[(int)num_of_jobs];
     for(int i = 0; i < job_durations.length; i++){
        job_durations[i] = input.nextLong();
     }
     version(num_of_workers,num_of_jobs,job_durations);
        for (int i = 0; i < workerlist.size(); i++){
            System.out.println(workerlist.get(i) + " " + starttime.get(i));
        }
    }

    static class worker{
     int id;
     long nextfreetime;
     public worker(int id){
         this.id = id;
         this.nextfreetime = 0;
     }
    }

    static void version(long num_of_workers, long num_of_jobs, long[] job_durations){
        PriorityQueue<worker> pq = new PriorityQueue<>((int) num_of_workers, new Comparator<worker>() {
            @Override
            public int compare(worker o1, worker o2) {
                return o1.nextfreetime == o2.nextfreetime ? o1.id - o2.id : (int) (o1.nextfreetime - o2.nextfreetime);
            }
        });

        for(int i = 0; i < num_of_workers; i++){
            pq.add(new worker(i));
        }

        for (int i = 0; i < num_of_jobs; i++){
            worker thread = pq.remove();
            workerlist.add(thread.id);
            starttime.add(thread.nextfreetime);
            thread.nextfreetime+= job_durations[i];
            pq.add(thread);
        }
    }
}
