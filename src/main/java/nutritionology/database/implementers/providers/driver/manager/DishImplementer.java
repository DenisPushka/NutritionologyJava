package nutritionology.database.implementers.providers.driver.manager;

import nutritionology.models.Dish;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Реализатор запросов к таблице "Блюдо" (Dish),
 * СИ (MS), рецепт (Recipe) и продукт блюдо Мап.
 */
@Component
public class DishImplementer extends ParentSQL {

    /**
     * Получение блюда по имени.
     *
     * @param name Название блюда.
     * @return Искомое блюдо.
     */
    public Dish GetDishForName(String name) {
        // TODO VALIDATION.

        Dish dish = new Dish();

        try {
            Connection connection = DriverManager.getConnection(ConnectionString);
            Statement stmt = connection.createStatement();
//            ResultSet executeQuery = stmt.executeQuery(
//                    // TODO ВЫНЕСТИ В ФАЙЛ ЗАПРОСОВ.
//                    "SELECT DishId, Number, Name, Weight, IsDrink, TypeLunchId " +
//                            "FROM [aspnet-Nutritionology].[dbo].[Dish] " +
//                            "WHERE Name like '%" + name + "%'");
//
//            while (executeQuery.next()) {
//                System.out.println(
//                        executeQuery.getString("DishId") +
//                                " " + executeQuery.getString("Name") +
//                                " " + executeQuery.getString("IsDrink") +
//                                " " + executeQuery.getString("TypeLunch")
//                );
//            }
//
//            executeQuery.close();
            stmt.close();
            connection.close();
        } catch (Exception ex) {

            // TODO ВЫНЕСТИ.
            for (StackTraceElement stack : ex.getStackTrace()) {
                System.err.println(stack.toString());
            }

            String separator = "-";
            separator = separator.repeat(40);
            System.err.println(separator + "\n" + ex);
        }


        return dish;
    }
}
