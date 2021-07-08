import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main{

    public static double Percentile(List<Double> entities, int percentile){ //поиск перцентеля
        return (int) ((percentile / 100.0 * entities.size()) - 1);
    }

    public static double Median(List<Double> entities){ //поиск медианы
        Collections.sort(entities);

        if (entities.size() % 2 == 0)
            return ((entities.get(entities.size() / 2) + entities.get(entities.size() / 2 - 1)) / 2f);

        return entities.get(entities.size() / 2);
    }

    public static double Maximum(List<Double> entities){ //поиск максимума
        double maximum = Integer.MIN_VALUE;

        if (entities == null || entities.size() == 0)
            return maximum;

        for (double j : entities){
            maximum = Math.max(maximum, j);
        }
        return maximum;
    }

    public static double Minimum(List<Double> entities){ //поиск минимума
        double minimum = Integer.MAX_VALUE;

        if (entities == null || entities.size() == 0)
            return minimum;

        for (double j : entities){
            minimum = Math.min(minimum, j);
        }
        return minimum;
    }

    public static double Average(List<Double> entities){ //поиск среднего значения
        int valueAverage = 0;

        if (entities == null || entities.size() == 0)
            return valueAverage;

        for (double j : entities){
            valueAverage += j;
        }

        return (double) valueAverage / entities.size();
    }

    public static void main(String[] args){
        List<Double> array = new ArrayList<>();

        File file = new File("");

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                array.add(Double.valueOf(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.printf("%.2f%n", Percentile(array, 90));
        System.out.printf("%.2f%n", Median(array));
        System.out.printf("%.2f%n", Maximum(array));
        System.out.printf("%.2f%n", Minimum(array));
        System.out.printf("%.2f%n", Average(array));
    }
}