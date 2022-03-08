import java.util.Scanner;
public class current_time {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Input the time zone offset to GMT: ");
        long timeZoneChange = input.nextInt();

        long totalMilliseconds = System.currentTimeMillis();

        long totalSeconds = totalMilliseconds / 1000;

        long currentSecond = totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;

        long currentMinute = totalMinutes % 60;

        long totalHours = totalMinutes / 60;

        long currentHour = ((totalHours + timeZoneChange) % 24) -12;

        System.out.println("Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond);
    }
}

/*public class current_time {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        int minutes = (currentTimeMillis/1000)/60;
        int seconds = (currentTimeMillis/1000)%60;
        int hour = minutes/60;
        System.out.println(hour + ":" + minutes + ":" + seconds);

    }
}
/*Input the time zone offset to GMT: 256
output: Current time is 5:7:51
*/