package nutritionology.services.interfaces;

import nutritionology.models.dictionaries.Product;
import nutritionology.models.dictionaries.ProductName;
import nutritionology.models.maps.ProductMRItem;

/**
 * Интерфейс для запросов к таблице "Продукт".
 * Включает запросы для таблиц: название продукта (NameProduct), фото блюда (PhotoDish).
 */
public interface ProductServiceInterface {

    /**
     * Добавление категории продуктов.
     *
     * @param name Название категории.
     * @return Созданный объект.
     */
    ProductName AddProductName(String name);

    /**
     * Получение всех категорий.
     *
     * @return Массив категорий.
     */
    ProductName[] GetProductNames();

    /**
     * Добавление продукта.
     *
     * @param product Добавляемый продукт.
     * @return Добавленный продукт.
     */
    Product AddProduct(Product product);

    /**
     * Добавление свойств продукта.
     *
     * @param productMRItems Добавляемые свойста продукта.
     * @return Все свойства данного продукта.
     */
    // ?
    ProductMRItem[] AddProductMrItems(ProductMRItem[] productMRItems);

    /**
     * Получение всех продуктов.
     *
     * @return Массив продуктов.
     */
    Product[] GetAllProducts();

    /**
     * Получение всех продуктов по определенной категории.
     *
     * @param productName Категория по которой нужно найти продукты.
     * @return Массив продуктов по выбранной категории.
     */
    Product[] GetProductForName(ProductName productName);
}
