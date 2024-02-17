package nutritionology.database.sql.scripts;

/**
 * Хранилище запросов для запросов к таблице "Блюдо" (Dish),
 * СИ (MS), рецепт (Recipe) и продукт блюдо Мап.
 */
public class DishSQlScript {

    /**
     * Добавление блюда.
     */
    public final String AddDish =
            "INSERT INTO [aspnet-Nutritionology].[dbo].[Dish]" +
                    "   ( " +
                    "       Number" +
                    "       , Name" +
                    "       , Weight" +
                    "       , IsDrink" +
                    "   ) " +
                    "VALUES" +
                    "   (" +
                    "       @number" +
                    "       , @name" +
                    "       , @weight" +
                    "       , @isDrink" +
                    "   )";

    /**
     * Добавление продуктов через таблицу ProductDishMap.
     */
    public final String AddProducts =
            "INSERT INTO [dbo].[ProductDishMap]" +
                    "   (" +
                    "       [ProductId]" +
                    "       , [DishId]" +
                    "       , [MSId]" +
                    "       , [Weight]" +
                    "   ) " +
                    "VALUES ";

    /**
     * Получение блюда с продуктами.
     */
    public final String GetDish =
            "SELECT D.DishId," +
                    "   D.Name," +
                    "   D.Weight," +
                    "   PDM.ProductDishMapId," +
                    "   PDM.Weight," +
                    "   MS.MSId," +
                    "   MS.ShortName," +
                    "   P.ProductId," +
                    "   P.FullName, " +
                    "   R2.RecipeId," +
                    "   R2.Description," +
                    "   MT.Name " +
                    "FROM [aspnet-Nutritionology].[dbo].[Dish] D" +
                    "   LEFT JOIN ProductDishMap PDM " +
                    "       ON D.DishId = PDM.DishId" +
                    "   LEFT JOIN Product P " +
                    "       ON PDM.ProductId = P.ProductId" +
                    "   LEFT JOIN MeasurementSystem MS " +
                    "       ON PDM.MSId = MS.MSId" +
                    "   INNER JOIN Recipe R2 " +
                    "       ON D.DishId = R2.DishId " +
                    "   INNER JOIN DishMealTimeMap DMTM" +
                    "       ON DMTM.DishId = D.DishId" +
                    "   INNER JOIN MealTime MT" +
                    "       ON MT.MealTimeId = DMTM.MealTimeId ";

    /**
     * Получение блюда с продуктами.
     */
    public final String GetDishForName =
            GetDish +
                    "WHERE R2.IsPrivate = 0 AND D.Name LIKE ";

    /**
     * Получение Guid блюда по его названию.
     */
    public final String GetDishGuidForName =
            "SELECT DishId " +
                    "FROM [aspnet-Nutritionology].[dbo].[Dish] " +
                    "WHERE Name LIKE ";

    /**
     * Добавление приемов пищи блюду.
     */
    public final String AddMealTimeToDish =
            "INSERT INTO [aspnet-Nutritionology].[dbo].[DishMealTimeMap] " +
                    "   (" +
                    "       [MealTimeId]" +
                    "       , [DishId]" +
                    "   ) " +
                    "VALUES ";

    /**
     * Добавление фоток блюду.
     */
    public final String AddPhotoToDish =
            "INSERT INTO [aspnet-Nutritionology].[dbo].[PhotoDish] " +
                    "   (" +
                    "       [Photo]" +
                    "       , [DishId]" +
                    "   ) " +
                    "VALUES ";

    /**
     * Добавление рецепта.
     */
    public final String AddRecipe =
            "INSERT INTO [aspnet-Nutritionology].[dbo].[Recipe] " +
                    "   (" +
                    "       [Desscription]" +
                    "       , [DishId]" +
                    "       , [IsPrivate]" +
                    "   ) " +
                    "VALUES " +
                    "   (" +
                    "       @description" +
                    "       , @dishId" +
                    "       , @isPrivate" +
                    "   )";

    /**
     * Получение блюда по категории.
     */
    public final String GetDishesForMealTime =
            GetDish + "WHERE MT.Name LIKE ";
}
