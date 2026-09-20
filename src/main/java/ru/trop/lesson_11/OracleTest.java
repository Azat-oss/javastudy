package ru.trop.lesson_11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {
    public static void main(String[] args) {

        // 1. Настройки подключения
        String url = "jdbc:oracle:thin:@//localhost:1521/XE"; // Обрати внимание: два слэша //, а не пробел и двоеточие
        String username = "system";
        String password = "oracle123";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 2. Загружаем драйвер (для новых версий Java это опционально, но полезно для понимания)
            Class.forName("oracle.jdbc.OracleDriver");

            // 3. Устанавливаем соединение
            connection = DriverManager.getConnection(url, username, password);

            // 4. Создаем инструкцию (Statement)
            statement = connection.createStatement();

            // 5. Выполняем SQL запрос
            // Запрос "SELECT * FROM v$version" выводит информацию о версии Oracle
            String sql = "SELECT * FROM v$version";
            resultSet = statement.executeQuery(sql);

            // 6. Обрабатываем результат
            if (resultSet.next()) {
                // Выводим первый столбец полученной строки
                System.out.println("Oracle Version: " + resultSet.getString(1));
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер Oracle не найден! Добавь зависимость в pom.xml.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Ошибка при работе с базой данных.");
            e.printStackTrace();
        } finally {
            // 7. Обязательно закрываем ресурсы в обратном порядке (самые вложенные первыми)
            // Это заменяет @Cleanup
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }





    }
}
