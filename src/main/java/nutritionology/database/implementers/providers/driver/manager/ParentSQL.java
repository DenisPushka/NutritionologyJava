package nutritionology.database.implementers.providers.driver.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Родительский SQL класс.
 */
public class ParentSQL {

    /**
     * Строка подключения.
     */
    protected String ConnectionString;

    public ParentSQL() {
        FileInputStream fis;
        Properties property = new Properties();

//        try {
//            fis = new FileInputStream("src/main/resources/config.properties");
//            property.load(fis);
//
//            String host = property.getProperty("db.host");
//            String name = property.getProperty("db.name");
//            String login = property.getProperty("db.login");
//            String password = property.getProperty("db.password");
//
//            ConnectionString = String.format(
////                    "jdbc:mysql://DenisBaranovski:3306/nutritionology"
//                    "jdbc:mysql://%s:3306/%s?user=%s&password=%s"
//                    , host, name, login, password);
//
//            System.out.println("HOST: " + host
//                    + ", LOGIN: " + login
//                    + ", PASSWORD: " + password);
//
//        } catch (IOException e) {
//            System.err.println("ОШИБКА: Файл свойств отсуствует!");
//        }
    }
//    /// <summary>
//    /// Добавление элементов, используется только для asp net provider.
//    /// </summary>
//    /// <param name="query">Запрос на добавление.</param>
//    protected async Task AddObjectInDb(string query)
//    {
//        await using var connection = new SqlConnection(Connection);
//        var command = new SqlCommand(query, connection);
//
//        await DoQuery(connection, command);
//    }
//
//    /// <summary>
//    /// Выполнение запроса, используется для asp net provider.
//    /// </summary>
//    /// <param name="connection">Объект подключения.</param>
//    /// <param name="command">Объект запроса для выпонения команды.</param>
//    protected async Task DoQuery(SqlConnection connection, DbCommand command)
//    {
//        try
//        {
//            await connection.OpenAsync();
//            await command.ExecuteNonQueryAsync();
//            await connection.CloseAsync();
//        }
//        catch (Exception e)
//        {
//            Debug.WriteLine(e);
//            throw;
//        }
//    }
}
