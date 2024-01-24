package nutritionology.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Date 08.01.2024
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tuple2<A, B> implements Cloneable{
    private A first;
    private B second;

    @Override
    public Tuple2<String, Double> clone() throws CloneNotSupportedException {
        super.clone();

        return new Tuple2<>(first.toString(), (Double) second);
    }
}
