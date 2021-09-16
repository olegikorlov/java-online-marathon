package com.olegorlov.softserve.jom.sprint10.selfpreporation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) throws SQLException {

    DriverManager.registerDriver(new org.h2.Driver());
    Connection connection = DriverManager.getConnection("", "", "");
    connection.setAutoCommit(false);
    connection.getMetaData();

    //set a Savepoint
    Savepoint savepoint1 = connection.setSavepoint("Savepoint1");

    String SQL = "INSERT INTO Employees " +
        "VALUES (106, 20, 'Rita', 'Tez')";

    Statement statement = connection.createStatement();
    statement.executeUpdate(SQL);
//    statement.get

    String SQL1 = "INSERT INTO Employees " +
        "VALUES (?)";

    PreparedStatement preparedStatement = connection.prepareStatement(SQL1);
    preparedStatement.setInt(1, 45);
    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.getMetaData();
    List<String> strings = new ArrayList<>();
    while (resultSet.next()) {
      strings.add(resultSet.getString("id"));
    }

    connection.rollback(savepoint1);
    connection.commit();
  }
}
