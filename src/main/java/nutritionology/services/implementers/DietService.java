package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.jpa.DayOfWeekRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.DietRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MealTimeRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.PhotoRepositoryJPA;
import nutritionology.models.Diet;
import nutritionology.models.dictionaries.DayOfWeek;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.models.dictionaries.Photo;
import nutritionology.models.maps.DietDish;
import nutritionology.services.interfaces.DietServiceInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;

import static nutritionology.services.CreatorMenu.calculateNutrientsInDish;

/**
 * @Date 11.02.2024
 */
@Service
public class DietService implements DietServiceInterface {

    private final MealTimeRepositoryJPA mealTimeRepositoryJPA;
    private final DayOfWeekRepositoryJPA dayOfWeekRepositoryJPA;
    private final DietRepositoryJPA dietRepositoryJPA;

    private final PhotoRepositoryJPA photoRepositoryJPA;
    @Value("${upload.path}")
    private String uploadPath;

    public DietService(MealTimeRepositoryJPA mealTimeRepositoryJPA, DayOfWeekRepositoryJPA dayOfWeekRepositoryJPA, DietRepositoryJPA dietRepositoryJPA, PhotoRepositoryJPA photoRepositoryJPA) {
        this.mealTimeRepositoryJPA = mealTimeRepositoryJPA;
        this.dayOfWeekRepositoryJPA = dayOfWeekRepositoryJPA;
        this.dietRepositoryJPA = dietRepositoryJPA;
        this.photoRepositoryJPA = photoRepositoryJPA;
    }

    @Override
    public MealTime[] getMealTimes() {
        return mealTimeRepositoryJPA.findAll().toArray(new MealTime[0]);
    }

    @Override
    public DayOfWeek[] getAllDaysOdfWeek() {
        return dayOfWeekRepositoryJPA.findAll().toArray(new DayOfWeek[0]);
    }

    @Override
    public Diet getDietById(String uuid) {
        Diet diet =  dietRepositoryJPA.findById(UUID.fromString(uuid)).get();
        try {
            for (DietDish dietDish : diet.getDietDishes()) {
                dietDish.getDish().setPhotos(new HashSet<>(photoRepositoryJPA.findAllByDish(dietDish.getDish())));
                for (Photo photo : dietDish.getDish().getPhotos()) {
                    BufferedImage bImage = ImageIO.read(new File(uploadPath + "//" + photo.getPhotoName()));
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(bImage, "jpg", bos );
                    byte [] data = bos.toByteArray();

                    photo.setData(Base64.getEncoder().encodeToString(data));
//                    photo.setData(data);
                    bos.close();
                }

                HashMap<String, Double> bufferForDish = new HashMap<>();

                calculateNutrientsInDish(dietDish.getDish().getProductDishes(), bufferForDish);

                dietDish.getDish().setNutrients(bufferForDish);
            }

            return diet;
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        return null;
    }
}
