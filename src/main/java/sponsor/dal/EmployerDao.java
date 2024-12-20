//package sponsor.dal;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import sponsor.model.Employer;
//
//public class EmployerDao {
//    private static EmployerDao instance = null;
//    protected ConnectionManager connectionManager;
//
//    protected EmployerDao() {
//        connectionManager = new ConnectionManager();
//    }
//
//    public static EmployerDao getInstance() {
//        if (instance == null) {
//            instance = new EmployerDao();
//        }
//        return instance;
//    }
//
//    public Employer create(Employer employer) throws SQLException {
//        String insertEmployer = "INSERT INTO Employer(EMPLOYER_NAME, EMPLOYER_ADDRESS_1, EMPLOYER_CITY, EMPLOYER_STATE_PROVINCE, EMPLOYER_POSTAL_CODE, EMPLOYER_COUNTRY) VALUES(?, ?, ?, ?, ?, ?)";
//        try (Connection connection = connectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(insertEmployer, PreparedStatement.RETURN_GENERATED_KEYS)) {
//
//            statement.setString(1, employer.getEmployerName());
//            statement.setString(2, employer.getEmployerAddress());
//            statement.setString(3, employer.getEmployerCity());
//            statement.setString(4, employer.getEmployerStateProvince());
//            statement.setString(5, employer.getEmployerPostalCode());
//            statement.setString(6, employer.getEmployerCountry());
//            statement.executeUpdate();
//
//            ResultSet resultKey = statement.getGeneratedKeys();
//            int employerId = -1;
//            if (resultKey.next()) {
//                employerId = resultKey.getInt(1);
//            }
//            employer = new Employer(employerId, employer.getEmployerName(), employer.getEmployerAddress(),
//                    employer.getEmployerCity(), employer.getEmployerStateProvince(), employer.getEmployerPostalCode(),
//                    employer.getEmployerCountry());
//            return employer;
//        }
//    }
//
//    public Employer getEmployerById(int employerId) throws SQLException {
//        String selectEmployer = "SELECT * FROM Employer WHERE EMPLOYER_ID=?";
//        try (Connection connection = connectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(selectEmployer)) {
//
//            statement.setInt(1, employerId);
//            ResultSet results = statement.executeQuery();
//
//            if (results.next()) {
//                String employerName = results.getString("EMPLOYER_NAME");
//                String employerAddress = results.getString("EMPLOYER_ADDRESS_1");
//                String employerCity = results.getString("EMPLOYER_CITY");
//                String employerStateProvince = results.getString("EMPLOYER_STATE_PROVINCE");
//                String employerPostalCode = results.getString("EMPLOYER_POSTAL_CODE");
//                String employerCountry = results.getString("EMPLOYER_COUNTRY");
//                return new Employer(employerId, employerName, employerAddress, employerCity, employerStateProvince,
//                        employerPostalCode, employerCountry);
//            }
//        }
//        return null;
//    }
//
//    public Employer delete(Employer employer) throws SQLException {
//        String deleteEmployer = "DELETE FROM Employer WHERE EMPLOYER_ID=?";
//        try (Connection connection = connectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(deleteEmployer)) {
//
//            statement.setInt(1, employer.getEmployerId());
//            statement.executeUpdate();
//            return null;
//        }
////    }
//}


package sponsor.dal;
import sponsor.model.*;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployerDao {
	private static EmployerDao instance = null;
    protected ConnectionManager connectionManager;

    protected EmployerDao() {
        connectionManager = new ConnectionManager();
    }

    public static EmployerDao getInstance() {
        if (instance == null) {
            instance = new EmployerDao();
        }
        return instance;
    }

    public Employer create(Employer employer) throws SQLException {
        String insertEmployer = "INSERT INTO Employer(EMPLOYER_NAME, EMPLOYER_ADDRESS_1, EMPLOYER_CITY, EMPLOYER_STATE_PROVINCE, EMPLOYER_POSTAL_CODE, EMPLOYER_COUNTRY, EMPLOYER_CASE_NUMBER) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertEmployer, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, employer.getEmployerName());
            statement.setString(2, employer.getEmployerAddress());
            statement.setString(3, employer.getEmployerCity());
            statement.setString(4, employer.getEmployerStateProvince());
            statement.setString(5, employer.getEmployerPostalCode());
            statement.setString(6, employer.getEmployerCountry());
            statement.setString(7, employer.getEmployerCaseNumber());
            statement.executeUpdate();

            ResultSet resultKey = statement.getGeneratedKeys();
            int employerId = -1;
            if (resultKey.next()) {
                employerId = resultKey.getInt(1);
            }
            employer = new Employer(employerId, employer.getEmployerName(), employer.getEmployerAddress(),
                    employer.getEmployerCity(), employer.getEmployerStateProvince(), employer.getEmployerPostalCode(),
                    employer.getEmployerCountry(), employer.getEmployerCaseNumber());
            return employer;
        }
    }

    public Employer getEmployerById(int employerId) throws SQLException {
        String selectEmployer = "SELECT * FROM Employer WHERE EMPLOYER_ID=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectEmployer)) {

            statement.setInt(1, employerId);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                String employerName = results.getString("EMPLOYER_NAME");
                String employerAddress = results.getString("EMPLOYER_ADDRESS_1");
                String employerCity = results.getString("EMPLOYER_CITY");
                String employerStateProvince = results.getString("EMPLOYER_STATE_PROVINCE");
                String employerPostalCode = results.getString("EMPLOYER_POSTAL_CODE");
                String employerCountry = results.getString("EMPLOYER_COUNTRY");
                String employerCaseNumber = results.getString("EMPLOYER_CASE_NUMBER");
                return new Employer(employerId, employerName, employerAddress, employerCity, employerStateProvince,
                        employerPostalCode, employerCountry, employerCaseNumber);
            }
        }
        return null;
    }

    public Employer delete(Employer employer) throws SQLException {
        String deleteEmployer = "DELETE FROM Employer WHERE EMPLOYER_ID=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteEmployer)) {

            statement.setInt(1, employer.getEmployerId());
            statement.executeUpdate();
            return null;
        }
    }
    
    public List<Employer> getAllEmployers() throws SQLException {
        List<Employer> employers = new ArrayList<>();
        String selectAll = "SELECT * FROM Employer";
        
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAll);
             ResultSet results = statement.executeQuery()) {
            
            while (results.next()) {
                Employer employer = new Employer(
                    results.getInt("EMPLOYER_ID"),
                    results.getString("EMPLOYER_NAME"),
                    results.getString("EMPLOYER_ADDRESS_1"),
                    results.getString("EMPLOYER_CITY"),
                    results.getString("EMPLOYER_STATE_PROVINCE"),
                    results.getString("EMPLOYER_POSTAL_CODE"),
                    results.getString("EMPLOYER_COUNTRY"),
                    results.getString("EMPLOYER_CASE_NUMBER")
                    
                );
                employers.add(employer);
            }
        }
        return employers;
    }
}
