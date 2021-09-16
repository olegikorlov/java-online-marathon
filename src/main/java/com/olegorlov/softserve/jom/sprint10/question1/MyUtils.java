package com.olegorlov.softserve.jom.sprint10.question1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class MyUtils {

  private Connection connection;
  private Statement statement;
  private String schemaName;

  public Connection createConnection() throws SQLException {
    DriverManager.registerDriver(new org.h2.Driver());
    connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    return connection;
  }

  public void closeConnection() throws SQLException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
    connection = null;
  }

  public Statement createStatement() throws SQLException {
    statement = connection.createStatement();
    return statement;
  }

  public void closeStatement() throws SQLException {
    if (statement != null && !statement.isClosed()) {
      statement.close();
    }
    statement = null;
  }

  public void createSchema(String schemaName) throws SQLException {
    this.schemaName = schemaName;
    String sql = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
    statement.execute(sql);
  }

  public void dropSchema() throws SQLException {
    String sql = "DROP SCHEMA IF EXISTS " + schemaName + " CASCADE";
    statement.execute(sql);
  }

  public void useSchema() throws SQLException {
    final String sql = "USE " + schemaName;
    statement.execute(sql);
  }

  public void createTableRoles() throws SQLException {
    String sql = "" +
        "CREATE TABLE IF NOT EXISTS Roles (" +
        "id INT NOT NULL AUTO_INCREMENT," +
        "roleName VARCHAR(255) NOT NULL," +
        "PRIMARY KEY (id))";
    statement.execute(sql);
  }

  public void createTableDirections() throws SQLException {
    String sql = "" +
        "CREATE TABLE IF NOT EXISTS Directions (" +
        "id INT NOT NULL AUTO_INCREMENT," +
        "directionName VARCHAR(255) NOT NULL," +
        "PRIMARY KEY (id))";
    statement.execute(sql);
  }

  public void createTableProjects() throws SQLException {
    String sql = "" +
        "CREATE TABLE IF NOT EXISTS Projects (" +
        "id INT NOT NULL AUTO_INCREMENT," +
        "projectName VARCHAR(255) NOT NULL," +
        "directionId INT NOT NULL," +
        "PRIMARY KEY (id)," +
        "FOREIGN KEY (directionId) REFERENCES Directions(id))";
    statement.execute(sql);
  }

  public void createTableEmployee() throws SQLException {
    String sql = "" +
        "CREATE TABLE IF NOT EXISTS Employee (" +
        "id INT NOT NULL AUTO_INCREMENT," +
        "firstName VARCHAR(255) NOT NULL," +
        "roleId INT NOT NULL," +
        "projectId INT NOT NULL," +
        "PRIMARY KEY (id)," +
        "FOREIGN KEY (roleId) REFERENCES Roles(id)," +
        "FOREIGN KEY (projectId) REFERENCES Projects(id))";
    statement.execute(sql);
  }

  public void dropTable(String tableName) throws SQLException {
    String sql = "DROP TABLE " + tableName;
    statement.execute(sql);
  }

  public void insertTableRoles(String roleName) throws SQLException {
    String sql = "INSERT INTO Roles(roleName) VALUES('" + roleName + "')";
    statement.executeUpdate(sql);
  }

  public void insertTableDirections(String directionName) throws SQLException {
    String sql = "INSERT INTO Directions(directionName) VALUES('" + directionName + "')";
    statement.executeUpdate(sql);
  }

  public void insertTableProjects(String projectName, String directionName) throws SQLException {
    String sql = String.format("INSERT INTO Projects(projectName, directionId) VALUES('%s', %d)",
        projectName, getDirectionId(directionName));
    statement.executeUpdate(sql);
  }

  public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
    String sql = String.format("INSERT INTO Employee(firstName, roleId, projectId) VALUES('%s', %d, %d)",
        firstName, getRoleId(roleName), getProjectId(projectName));
    statement.executeUpdate(sql);
  }

  public int getRoleId(String roleName) throws SQLException {
    String sql = "SELECT id FROM Roles WHERE roleName = '" + roleName + "'";
    return getId(sql);
  }

  public int getDirectionId(String directionName) throws SQLException {
    String sql = "SELECT id FROM Directions WHERE directionName = '" + directionName + "'";
    return getId(sql);
  }

  public int getProjectId(String projectName) throws SQLException {
    String sql = "SELECT id FROM Projects WHERE projectName = '" + projectName + "'";
    return getId(sql);
  }

  public int getEmployeeId(String firstName) throws SQLException {
    String sql = "SELECT id FROM Employee WHERE firstName = '" + firstName + "'";
    return getId(sql);
  }

  private int getId(String sql) throws SQLException {
    ResultSet resultSet = statement.executeQuery(sql);
    if (resultSet.next()) {
      return resultSet.getInt("id");
    }
    return -1;
  }

  public List<String> getAllRoles() throws SQLException {
    String sql = "SELECT roleName FROM Roles";
    return getValues(sql, "roleName");
  }

  public List<String> getAllDirestion() throws SQLException {
    String sql = "SELECT directionName FROM Directions";
    return getValues(sql, "directionName");
  }

  public List<String> getAllProjects() throws SQLException {
    String sql = "SELECT projectName FROM Projects";
    return getValues(sql, "projectName");
  }

  public List<String> getAllEmployee() throws SQLException {
    String sql = "SELECT firstName FROM Employee";
    return getValues(sql, "firstName");
  }

  public List<String> getAllDevelopers() throws SQLException {
    String sql = String.format("SELECT firstName FROM Employee WHERE roleId = %d",
        getRoleId("Developer"));
    return getValues(sql, "firstName");
  }

  public List<String> getAllJavaProjects() throws SQLException {
    String sql = String.format("SELECT DISTINCT projectName FROM Projects WHERE directionId = %d",
        getDirectionId("Java"));
    return getValues(sql, "projectName");
  }

  public List<String> getAllJavaDevelopers() throws SQLException {
    String sql = "" +
        "SELECT e.firstName FROM Employee e " +
        "JOIN Projects p ON e.projectId = p.id " +
        "JOIN Directions d ON p.directionId = d.id " +
        "JOIN Roles r ON e.roleId = r.id " +
        "WHERE r.roleName = '" + "Developer" + "' " +
        "AND d.directionName = '" + "Java" + "'";
    return getValues(sql, "firstName");
  }

  private List<String> getValues(String sql, String columnName) throws SQLException {
    List<String> values = new ArrayList<>();
    ResultSet resultSet = statement.executeQuery(sql);
    while (resultSet.next()) {
      values.add(resultSet.getString(columnName));
    }
    return values;
  }

}
